package com.muze.domain.like.command.application.dto;

import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@ToString
public class LikeDTO {
    @NotNull
    @Positive
    private Long memberId;
    @NotBlank
    private Origin origin;
    @NotNull
    @Positive
    private Long originId;

    public LikeDTO(Long memberId, Origin origin, Long originId) {
        this.memberId = memberId;
        this.origin = origin;
        this.originId = originId;
    }
}


