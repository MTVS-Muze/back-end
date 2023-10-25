package com.muze.domain.playlist.repository;

import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
import com.muze.domain.playlist.command.application.service.CreatePlaylistService;
import com.muze.domain.playlist.query.application.dto.PlaylistDTO;
import com.muze.domain.playlist.query.application.service.PlaylistInfoService;
import io.jsonwebtoken.lang.Assert;
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
public class PlaylistRepositoryTests {
    @Autowired
    private PlaylistInfoService playlistInfoService;
    @Autowired

    private CreatePlaylistService createPlaylistService;

    private static Stream<Arguments> CreatePlaylists() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new CreatePlaylistDTO(0L, "title1"),
                                new CreatePlaylistDTO(1L, "title2"),
                                new CreatePlaylistDTO(0L, "title3")
                        ),0L

                )
        );

    }
    @DisplayName("플레이리스트 전체조회 테스트")
    @ParameterizedTest
    @MethodSource("CreatePlaylists")
    public void findAllPlaylistTest(List<CreatePlaylistDTO> createPlaylistDTOS){
        for (CreatePlaylistDTO dto: createPlaylistDTOS
             ) {
         Long id = createPlaylistService.CreatePlaylist(dto);
        }
        List<PlaylistDTO> playlistDTOs = playlistInfoService.findAllPlaylist();
        playlistDTOs.forEach(System.out::println);
        Assertions.assertNotNull(playlistDTOs,"정상적으로 조회하지 못함");
    }

    @DisplayName("플레이리스트 memberId별 조회 테스트")
    @ParameterizedTest
    @MethodSource("CreatePlaylists")
    public void findAllPlaylistByMemberIdTest(List<CreatePlaylistDTO> createPlaylistDTOS,Long memberId){
        for (CreatePlaylistDTO dto: createPlaylistDTOS
        ) {
           createPlaylistService.CreatePlaylist(dto);
        }
        List<PlaylistDTO> playlistDTOs = playlistInfoService.findPlaylistByMemberId(memberId);
        playlistDTOs.forEach(System.out::println);
        Assertions.assertNotNull(playlistDTOs,"정상적으로 조회하지 못함");
    }
}
