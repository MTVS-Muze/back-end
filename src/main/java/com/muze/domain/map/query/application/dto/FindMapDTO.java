package com.muze.domain.map.query.application.dto;

import lombok.Getter;

@Getter
public class FindMapDTO {

    private Long id;

    private String memberId;

    private String title;

    private String song;

    private String data;

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
