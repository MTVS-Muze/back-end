package com.muze.domain.character.command.domain.repository;

import com.muze.domain.character.command.domain.aggregate.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findCharacterByMemberId_Id(Long memberId);
}
