package com.muze.domain.map.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.beans.ConstructorProperties;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Map 요청 객체")
public class RequestMapDTO {
    private Long id;
    private Long memberId;
    private String title;
    private String song;
    private String data;


    public RequestMapDTO(Long id) {
        this.id = id;
    }

//    @ConstructorProperties({"title", "song", "memberId"})
//    public RequestMapDTO(String title, String song, Long memberId) {
//        this.title = title;
//        this.song = song;
//        this.memberId = memberId;
//    }


    public RequestMapDTO(Long memberId, String title, String song, String data) {
        this.memberId = memberId;
        this.title = title;
        this.song = song;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestMapDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", song='" + song + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
