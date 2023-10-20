package com.muze.domain.map.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Map 응답 객체")
public class ResponseMapDTO {

    private Long id;

    private Long memberId;

    private String data;

    public ResponseMapDTO(Long id, Long memberId, String data) {
        this.id = id;
        this.memberId = memberId;
        this.data = data;
    }
}
