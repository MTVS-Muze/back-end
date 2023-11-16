package com.muze.domain.map.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Schema(description = "Map 응답 DTO")
public class ResponseMapDTO {
    @Schema(description = "DB 식별자 번호", defaultValue = "1")
    private Long id;

    @Schema(description = "Media Art 작성자 id", defaultValue = "1")
    private Long memberId;

    @Schema(description = "Media Art 제목", defaultValue = "도심의 빛")
    private String title;

    @Schema(description = "Media Art 노래", defaultValue = "Think About' Chu")
    private String song;

    @Schema(description = "Media Art 가수", defaultValue = "Sam kim")
    private String singer;

    @Schema(description = "Media Art 설명", defaultValue = "이 미디어 아트는 도심의 빛을 어쩌구..~")
    private String info;

    @Schema(description = "Media Art Map data", defaultValue = "{SpawnInfos=[{Location=(100.000000, 100.000000, 0.000000)}]}")
    private String data;

    @Schema(description = "Media Art 생성 날짜", defaultValue = "2023-11-15T12:51:14")
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
