//package com.muze.domain.map.query.application.service;
//
//import com.muze.domain.map.command.application.dto.RequestMapDTO;
//import com.muze.domain.map.command.application.dto.ResponseMapDTO;
//import com.muze.domain.map.command.application.service.CreateMapService;
//import com.muze.domain.map.command.application.service.DeleteMapService;
//import com.muze.domain.map.command.domain.repository.MapRepository;
//import com.muze.domain.map.query.application.dto.FindMapDTO;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//@SpringBootTest
//public class RMapServiceTests {
//
//    @Autowired
//    private FindMapService findMapService;
//
//    @Autowired
//    private CreateMapService createMapService;
//
//    @Autowired
//    private DeleteMapService deleteMapService;
//
//
//    private static Stream<Arguments> mapInfo(){
//        return Stream.of(
//                Arguments.of(
//                        new RequestMapDTO(
//                                1L,
//                                "test용 제목_1",
//                                "test용 음악이름_1",
//                                "map.csv 파일 data_1"
//                        ),
//                        new RequestMapDTO(
//                                2L,
//                                "test용 제목_2",
//                                "test용 음악이름_2",
//                                "map.csv 파일 data_2"
//                        )
//                )
//        );
//    }
//
//
//
//    @DisplayName("생성된 map이 전부 조회되는지 확인")
//    @ParameterizedTest
//    @MethodSource("mapInfo")
//    void createMapTest(RequestMapDTO createMapDTO1, RequestMapDTO createMapDTO2){
//        //given
//        int beforeSize = findMapService.findAll().size();
//        ResponseMapDTO map1 =createMapService.createMap(createMapDTO1);
//        ResponseMapDTO map2 =createMapService.createMap(createMapDTO2);
//
//        RequestMapDTO mapId1 = new RequestMapDTO(map1.getId());
//        RequestMapDTO mapId2 = new RequestMapDTO(map2.getId());
//        //when
//        List<FindMapDTO> maps = findMapService.findAll();
//
//        int afterSize = findMapService.findAll().size();
//        //then
//        Assertions.assertNotNull(maps);
//        Assertions.assertEquals(beforeSize+2, afterSize);
//
//        deleteMapService.deleteMap(mapId1);
//        deleteMapService.deleteMap(mapId2);
//    }
//}
