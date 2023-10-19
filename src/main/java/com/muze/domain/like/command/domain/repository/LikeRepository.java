package com.muze.domain.like.command.domain.repository;

import com.muze.domain.like.command.domain.aggregate.entity.Like;
import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
    void deleteByMemberId_IdAndOriginAndOriginId(Long memberId, Origin origin, Long originId);
}
