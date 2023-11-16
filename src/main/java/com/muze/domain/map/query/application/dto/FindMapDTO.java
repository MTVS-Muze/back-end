package com.muze.domain.map.query.application.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindMapDTO {

    @Schema(description = "DB 식별자 번호", defaultValue = "1")
    private Long id;

    @Schema(description = "Media Art 작성자 이름", defaultValue = "진용민")
    private String memberName;

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

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "FindMapDTO{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", title='" + title + '\'' +
                ", song='" + song + '\'' +
                ", singer='" + singer + '\'' +
                ", info='" + info + '\'' +
                ", data='" + data + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
