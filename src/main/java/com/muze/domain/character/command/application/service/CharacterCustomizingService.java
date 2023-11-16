package com.muze.domain.character.command.application.service;


import com.muze.domain.character.command.application.dto.CharacterCustomizingDTO;
import com.muze.domain.character.command.domain.aggregate.entity.Character;
import com.muze.domain.character.command.domain.repository.CharacterRepository;
import com.muze.domain.character.command.domain.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharacterCustomizingService {
    private final CharacterRepository characterRepository;
    private final CharacterService characterService;

    @Autowired
    public CharacterCustomizingService(CharacterRepository characterRepository, CharacterService characterService) {
        this.characterRepository = characterRepository;
        this.characterService = characterService;
    }

    @Transactional
    public Long CharacterCustomizing(CharacterCustomizingDTO characterCustomizingDTO){
        if(characterRepository.findCharacterByMemberId_Id(characterCustomizingDTO.getMemberId()).isPresent()){
            Character currentCharacter = characterRepository.findCharacterByMemberId_Id(characterCustomizingDTO.getMemberId()).get();

            currentCharacter.setHat(characterCustomizingDTO.getHat());
            currentCharacter.setColor(characterCustomizingDTO.getColor());
            currentCharacter.setFace(characterCustomizingDTO.getFace());

            return currentCharacter.getId();
        }else{
            return characterRepository.save(characterService.dtoToCharacterEntity(characterCustomizingDTO)).getId();
        }
    }

}
