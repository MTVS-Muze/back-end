package com.muze.domain.mapinplaylist.repository;

import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.mapinplaylist.command.application.service.AddPlaylistService;
import com.muze.domain.mapinplaylist.query.application.dto.MapInPlaylistInfoDTO;
import com.muze.domain.mapinplaylist.query.domain.repository.MapInPlaylistMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class MapInPlaylistRepositoryTests {

    @Autowired
    private MapInPlaylistMapper mapInPlaylistMapper;
    @Autowired
    private AddPlaylistService addPlaylistService;


    private static Stream<Arguments> AddPlaylists() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new AddPlaylistDTO(0L, 0L),
                                new AddPlaylistDTO(0L, 1L),
                                new AddPlaylistDTO(0L, 2L)
                        )
                        ,0L

                )
        );

    }

    @DisplayName("플레이리스트 조회 테스트")
    @ParameterizedTest
    @MethodSource("AddPlaylists")
    public void AddPlaylistTest(List<AddPlaylistDTO> addPlaylistDTOs, Long playlistId){
        for (AddPlaylistDTO dto:addPlaylistDTOs
             ) {
            addPlaylistService.addPlaylist(dto);
        }
        List<MapInPlaylistInfoDTO> dtos = mapInPlaylistMapper.findMapByPlaylistId(playlistId);

        dtos.forEach(System.out::println);
        Assertions.assertNotNull(dtos);
    }

}
