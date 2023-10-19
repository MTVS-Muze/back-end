package com.muze.domain.like.command.domain.service;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.domain.aggregate.entity.Like;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    public Like toLikeEntity(LikeDTO likeDTO){
        return new Like(likeDTO.getMemberId(),likeDTO.getOrigin(), likeDTO.getOriginId());
    }

}
