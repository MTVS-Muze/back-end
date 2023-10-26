package com.muze.domain.map.query.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindMapDTO {

    private Long id;

    private String memberId;

    private String title;

    private String song;

    private String data;

    private LocalDateTime createdDate;



    @Override
    public String toString() {
        return "FindMapDTO{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", song='" + song + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
