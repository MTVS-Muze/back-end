package com.muze.domain.like.query.application.service;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.domain.aggregate.entity.Like;
import com.muze.domain.like.query.domain.repository.LikeMapper;
import org.springframework.stereotype.Service;

@Service
public class LikeInfoService {
    private final LikeMapper likeMapper;

    public LikeInfoService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public Integer getCount(LikeDTO likeDTO){
        return likeMapper.getCount(likeDTO.getOrigin(), likeDTO.getOriginId());
    }

    public Boolean isLiked(LikeDTO likeDTO){
        return likeMapper.isLiked(likeDTO.getMemberId(),likeDTO.getOrigin(),likeDTO.getOriginId());
    }
}
