package com.muze.domain.character.query.domain.repository;

import com.muze.domain.character.query.application.dto.MyCharacterDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterMapper {
     MyCharacterDTO findCharacterByMemberId(Long memberId);
}
