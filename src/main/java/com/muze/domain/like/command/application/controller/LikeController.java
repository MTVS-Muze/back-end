package com.muze.domain.like.command.application.controller;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.application.service.CancelLikeService;
import com.muze.domain.like.command.application.service.EnrollLikeService;
import com.muze.domain.like.command.domain.repository.LikeRepository;
import com.muze.domain.like.query.application.dto.LikeInfoDTO;
import com.muze.domain.like.query.application.service.LikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final CancelLikeService cancelLikeService;
    private final EnrollLikeService enrollLikeService;
    private final LikeInfoService likeInfoService;
    private final LikeRepository likeRepository;
    @Autowired
    public LikeController(CancelLikeService cancelLikeService, EnrollLikeService enrollLikeService, LikeInfoService likeInfoService, LikeRepository likeRepository) {
        this.cancelLikeService = cancelLikeService;
        this.enrollLikeService = enrollLikeService;
        this.likeInfoService = likeInfoService;
        this.likeRepository = likeRepository;
    }

    @PostMapping
    public ResponseEntity<?> enrollOrDeleteLike(@Valid LikeDTO likeDTO, BindingResult bindingResult
//                                             ,@AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError error : list) {
                return new ResponseEntity<>(error.getDefaultMessage() , HttpStatus.BAD_REQUEST);
            }
        }

        if(likeInfoService.isLiked(likeDTO)){
            cancelLikeService.CancelLike(likeDTO);
            Integer count = likeInfoService.getCount(likeDTO);
            return ResponseEntity.ok(new LikeInfoDTO(count,false));

        }else{
            enrollLikeService.enrollLike(likeDTO);
            Integer count = likeInfoService.getCount(likeDTO);
            return ResponseEntity.ok(new LikeInfoDTO(count,true));
        }
    }
}
