package com.muze.domain.character.command.domain.service;

import com.muze.domain.character.command.application.dto.CharacterCustomizingDTO;
import com.muze.domain.character.command.domain.aggregate.entity.Character;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    public Character dtoToCharacterEntity(CharacterCustomizingDTO characterCustomizingDTO){
        return new Character(characterCustomizingDTO.getMemberId(), characterCustomizingDTO.getColor(),characterCustomizingDTO.getHat(),characterCustomizingDTO.getFace());
    }
}
