package com.muze.domain.playlist.query.application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PlaylistDTO {
    private Long id;
    private String title;
    private Long memberId;

    public PlaylistDTO(Long id, String title, Long memberId) {
        this.id = id;
        this.title = title;
        this.memberId = memberId;
    }
}
