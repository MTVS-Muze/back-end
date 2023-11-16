package com.muze.domain.character;

import com.muze.domain.character.command.application.dto.CharacterCustomizingDTO;
import com.muze.domain.character.command.application.service.CharacterCustomizingService;
import com.muze.domain.character.command.domain.repository.CharacterRepository;
import com.muze.domain.character.query.application.service.FindCharacterService;
import com.muze.domain.friend.command.application.dto.FriendDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class characterTests {
    @Autowired
    private FindCharacterService findCharacterService;
    @Autowired
    private CharacterCustomizingService characterCustomizingService;
    @Autowired
    private CharacterRepository characterRepository;


    private static Stream<Arguments> character() {
        return Stream.of(
                Arguments.of(

                        new CharacterCustomizingDTO(1L,1,1,1)
                )
        );

    }

    private static Stream<Arguments> updateCharacter() {
        return Stream.of(
                Arguments.of(
                        new CharacterCustomizingDTO(1L,1,1,1),
                        new CharacterCustomizingDTO(1L,2,2,2)
                )
        );

    }

    @DisplayName("캐릭터 커스터마이징 생성 테스트")
    @ParameterizedTest
    @MethodSource("character")
    public void CreateCharacterCustomizingTest(CharacterCustomizingDTO characterCustomizingDTO){
        Long id = characterCustomizingService.CharacterCustomizing(characterCustomizingDTO);
        Assertions.assertTrue(characterRepository.findById(id).isPresent());
    }


//    @DisplayName("캐릭터 커스터마이징 업데이트 테스트")
//    @ParameterizedTest
//    @MethodSource("updateCharacter")
//    public void UpdateCharacterCustomizingTest(CharacterCustomizingDTO create, CharacterCustomizingDTO update){
//
//        characterCustomizingService.CharacterCustomizing(create);
//        characterCustomizingService.CharacterCustomizing(update);
//        Assertions.assertEquals(findCharacterService.findCharacter(update.getMemberId()).getColor(), update.getColor());
//    }
}
