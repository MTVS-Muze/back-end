package com.muze.domain.like.query.application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeInfoDTO {
    private Integer count;
    private Boolean isLiked;

    public LikeInfoDTO(Integer count, Boolean isLiked) {
        this.count = count;
        this.isLiked = isLiked;
    }
}
