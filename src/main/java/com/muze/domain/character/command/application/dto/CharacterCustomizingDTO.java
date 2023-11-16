package com.muze.domain.character.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterCustomizingDTO {
    @Schema(hidden = true)
    private Long memberId;
    private Integer color;
    private Integer hat;
    private Integer face;

    public CharacterCustomizingDTO(Integer color, Integer hat, Integer face) {
        this.color = color;
        this.hat = hat;
        this.face = face;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}

