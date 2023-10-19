package com.muze.domain.like.query.domain.repository;

import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    Boolean isLiked(Long memberId, Origin origin, Long originId);
    Integer getCount(Origin origin, Long originId);
}
