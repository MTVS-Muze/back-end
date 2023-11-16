package com.muze.domain.like.command.application.dto;

import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@ToString
public class LikeDTO {
    @Schema(hidden = true)
    private Long memberId;
    private Origin origin;
    @NotNull(message = "originId는 Null일 수 없습니다.")
    @Positive(message = "originId는 음수일 수 없습니다.")
    @Schema(description = "MAP의 id", defaultValue = "1")
    private Long originId;
    public LikeDTO(Long memberId, Origin origin, Long originId) {
        this.memberId = memberId;
        this.origin = origin;
        this.originId = originId;
    }

    public LikeDTO(Origin origin, Long originId) {
        this.origin = origin;
        this.originId = originId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}


