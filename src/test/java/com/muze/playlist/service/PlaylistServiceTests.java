package com.muze.playlist.service;
import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
import com.muze.domain.playlist.command.application.service.CreatePlaylistService;
import com.muze.domain.playlist.command.application.service.DeletePlaylistService;
import com.muze.domain.playlist.command.domain.repository.PlaylistRepository;
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
public class PlaylistServiceTests {
    @Autowired
    private CreatePlaylistService createPlaylistService;
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private DeletePlaylistService deletePlaylistService;

    private static Stream<Arguments> createPlaylist() {
        return Stream.of(
                Arguments.of(

                        new CreatePlaylistDTO(0L, "title")

                )
        );

    }

    @DisplayName("playlist 생성 테스트")
    @ParameterizedTest
    @MethodSource("createPlaylist")
    public void CreateServiceTest(CreatePlaylistDTO createPlaylistDTO){
        Long id = createPlaylistService.CreatePlaylist(createPlaylistDTO);
        Assertions.assertNotNull(id,"id가 null입니다.");
    }

    @DisplayName("playlist 생성 테스트")
    @ParameterizedTest
    @MethodSource("createPlaylist")
    public void DeleteServiceTests(CreatePlaylistDTO createPlaylistDTO){
        Long id = createPlaylistService.CreatePlaylist(createPlaylistDTO);
        deletePlaylistService.deletePlaylist(id);
        Assertions.assertFalse(playlistRepository.findById(id).isPresent(),"삭제가 정상적으로 진행되지 않음");
    }
}
