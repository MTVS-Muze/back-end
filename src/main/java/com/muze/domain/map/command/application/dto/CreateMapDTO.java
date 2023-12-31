package com.muze.domain.map.command.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Schema(description = "Map 생성 DTO")
public class CreateMapDTO {

    @Schema(description = "Media Art 제목", defaultValue = "도심의 빛")
    @NotNull
    private String title;

    @Schema(description = "Media Art 노래", defaultValue = "Think About' Chu")
    @NotNull
    private String song;

    @Schema(description = "Media Art 가수", defaultValue = "Sam kim")
    @NotNull
    private String singer;

    @Schema(description = "Media Art 설명", defaultValue = "이 미디어 아트는 도심의 빛을 어쩌구..~")
    @NotNull
    private String info;

    @Schema(description = "Media Art Map data", defaultValue = "{SpawnInfos=[{Location=(100.000000, 100.000000, 0.000000)}]}")
    @NotNull
    private String data;



//    @ConstructorProperties({"title", "song", "memberId"})
//    public RequestMapDTO(String title, String song, Long memberId) {
//        this.title = title;
//        this.song = song;
//        this.memberId = memberId;
//    }


    public CreateMapDTO(String title, String song, String data) {
        this.title = title;
        this.song = song;
        this.data = data;
    }


    @Override
    public String toString() {
        return "RequestMapDTO{" +
                ", title='" + title + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
