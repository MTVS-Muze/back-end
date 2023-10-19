package com.muze.domain.like.command.application.service;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.domain.aggregate.entity.Like;
import com.muze.domain.like.command.domain.repository.LikeRepository;
import com.muze.domain.like.command.domain.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollLikeService {

    private final LikeService likeService;
    private final LikeRepository likeRepository;

    @Autowired
    public EnrollLikeService(LikeService likeService, LikeRepository likeRepository) {
        this.likeService = likeService;
        this.likeRepository = likeRepository;
    }

    public Long enrollLike(LikeDTO likeDTO){
        System.out.println("하이");
        Like enrollLike = likeService.toLikeEntity(likeDTO);
        System.out.println(enrollLike);

        Like like = likeRepository.save(enrollLike);
        System.out.println(like);
        return like.getId();
    }
}
