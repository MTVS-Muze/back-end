package com.muze.domain.map.command.application.service;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.domain.aggregate.entity.Map;
import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;
import com.muze.domain.map.command.domain.repository.MapRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class CRUMapServiceTests {

    @Autowired
    private CreateMapService createMapService;

    @Autowired
    private UpdateMapService updateMapService;

    @Autowired
    private DeleteMapService deleteMapService;

    @Autowired
    private MapRepository mapRepository;
    private static Stream<Arguments> mapInfo(){
        return Stream.of(
                Arguments.of(
                        new RequestMapDTO(
                                1L,
                                "map.csv 파일 data"
                        )
                )
        );
    }

    @DisplayName("RequestDTO로 Map이 데이터가 생성되는지 확인")
    @ParameterizedTest
    @MethodSource("mapInfo")
    void createMapTest(RequestMapDTO createMapDTO){
        Assertions.assertDoesNotThrow(
                ()->createMapService.createMap(createMapDTO)
        );
    }

    @DisplayName("RequestDTO로 Map data가 수정되는지 확인")
    @ParameterizedTest
    @MethodSource("mapInfo")
    void updateMapTest(RequestMapDTO createMapDTO){
        // given
        MemberVO memberId = MemberVO.builder().memeberId(createMapDTO.getMemberId()).build();
        Map createMap = mapRepository.save(new Map(memberId, createMapDTO.getData()));

        String beforeData = createMap.getData();
        String afterData = "수정된 Map.csv data";
        System.out.println("before update = " + createMap.getData());

        RequestMapDTO updateMap = new RequestMapDTO(createMap.getId(), createMap.getMemberId().getId(), afterData);
        //when
        boolean result = updateMapService.updateMap(updateMap);

        System.out.println("after update = " + createMap.getData());
        //then
        Assertions.assertTrue(result);
        Assertions.assertNotEquals(beforeData, createMap.getData());
    }

    @DisplayName("Id로 Map이 삭제되는지 확인")
    @ParameterizedTest
    @MethodSource("mapInfo")
    void deleteMapTest(RequestMapDTO createMapDTO){
        // given
        MemberVO memberId = MemberVO.builder().memeberId(createMapDTO.getMemberId()).build();
        Map createMap = mapRepository.save(new Map(memberId, createMapDTO.getData()));
        RequestMapDTO deleteMapDTO = new RequestMapDTO(createMap.getId(), createMap.getMemberId().getId(), createMap.getData());

        int deleteBeforeCount =(int) mapRepository.count();

        //when
        deleteMapService.deleteMap(deleteMapDTO);
        //then
        Assertions.assertEquals(mapRepository.count(), deleteBeforeCount-1);
    }
}
