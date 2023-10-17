package com.muze.domain.security.command.domain.repository;

import com.muze.domain.security.command.domain.aggregate.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByMember_Id(long memberId);
    Optional<Token> findTokenByAccessToken(String accessToken);
}
