package com.muze.mapinplaylist.service;

import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.mapinplaylist.command.application.service.AddPlaylistService;
import com.muze.domain.mapinplaylist.command.application.service.RemovePlaylistService;
import com.muze.domain.mapinplaylist.command.domain.repository.MapInPlaylistRepository;
import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
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
public class MapInPlaylistServiceTests {

    @Autowired
    private AddPlaylistService addPlaylistService;
    @Autowired
    private RemovePlaylistService removePlaylistService;
    @Autowired
    private MapInPlaylistRepository mapInPlaylistRepository;



    private static Stream<Arguments> AddPlaylist() {
        return Stream.of(
                Arguments.of(

                        new AddPlaylistDTO(0L, 0L)

                )
        );

    }

    private static Stream<Arguments> AddPlaylists() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                new AddPlaylistDTO(0L, 0L),
                                new AddPlaylistDTO(0L, 1L),
                                new AddPlaylistDTO(0L, 2L)
                                )

                )
        );

    }


    @DisplayName("플레이리스트 추가 테스트")
    @ParameterizedTest
    @MethodSource("AddPlaylist")
    public void AddPlaylistTest(AddPlaylistDTO addPlaylistDTO){
        Long id = addPlaylistService.addPlaylist(addPlaylistDTO);
        Assertions.assertNotNull(id,"정상적으로 생성되지 않음");
    }

    @DisplayName("플레이리스트 삭제 테스트")
    @ParameterizedTest
    @MethodSource("AddPlaylist")
    public void RemovePlaylistTest(AddPlaylistDTO addPlaylistDTO){
        Long id = addPlaylistService.addPlaylist(addPlaylistDTO);
        removePlaylistService.removePlaylist(id);
        Assertions.assertFalse(mapInPlaylistRepository.findById(id).isPresent());
    }

    @DisplayName("플레이리스트 전체 삭제 테스트")
    @ParameterizedTest
    @MethodSource("AddPlaylists")
    public void RemoveAllPlaylistTest(List<AddPlaylistDTO> addPlaylistDTOs){
        Long id = addPlaylistDTOs.get(0).getPlaylistId();
        for (AddPlaylistDTO DTO: addPlaylistDTOs) {
            addPlaylistService.addPlaylist(DTO);
        }
        removePlaylistService.removeAllPlaylist(id);
        Assertions.assertFalse(mapInPlaylistRepository.findById(id).isPresent());
    }

}
