package com.muze.domain.like.command.application.controller;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.application.service.CancelLikeService;
import com.muze.domain.like.command.application.service.EnrollLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final CancelLikeService cancelLikeService;
    private final EnrollLikeService enrollLikeService;

    @Autowired
    public LikeController(CancelLikeService cancelLikeService, EnrollLikeService enrollLikeService) {
        this.cancelLikeService = cancelLikeService;
        this.enrollLikeService = enrollLikeService;
    }

    @PostMapping
    public ResponseEntity<?> enrollOrDeleteLike(@RequestBody @Valid LikeDTO likeDTO){

        enrollLikeService.enrollLike(likeDTO);
        return ResponseEntity.ok().build();
    }
}
