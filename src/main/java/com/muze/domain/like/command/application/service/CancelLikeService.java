package com.muze.domain.like.command.application.service;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.domain.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelLikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public CancelLikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void CancelLike(LikeDTO likeDTO){
        likeRepository.deleteByMemberId_IdAndOriginAndOriginId(likeDTO.getMemberId(),likeDTO.getOrigin(),likeDTO.getOriginId());
    }
}
