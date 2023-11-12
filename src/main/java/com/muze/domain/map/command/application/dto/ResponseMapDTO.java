package com.muze.domain.map.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Schema(description = "Map 응답 객체")
public class ResponseMapDTO {

    private Long id;

    private Long memberId;

    private String title;

    private String song;

    private String singer;

    private String info;

    private String data;

    private LocalDateTime createdDate;

    public ResponseMapDTO(Long id, Long memberId, String title, String song, String singer, String info, String data, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.song = song;
        this.singer = singer;
        this.info = info;
        this.data = data;
        this.createdDate = createdDate;
    }
}
