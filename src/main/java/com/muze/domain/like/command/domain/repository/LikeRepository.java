package com.muze.domain.like.command.domain.repository;

import com.muze.domain.like.command.domain.aggregate.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
