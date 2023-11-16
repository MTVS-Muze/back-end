package com.muze.domain.character.query.application.service;

import com.muze.domain.character.query.application.dto.MyCharacterDTO;
import com.muze.domain.character.query.domain.repository.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCharacterService {
    private final CharacterMapper characterMapper;

    @Autowired

    public FindCharacterService(CharacterMapper characterMapper) {
        this.characterMapper = characterMapper;
    }

    public MyCharacterDTO findCharacter(Long memberId){
        return characterMapper.findCharacterByMemberId(memberId);
    }
}
