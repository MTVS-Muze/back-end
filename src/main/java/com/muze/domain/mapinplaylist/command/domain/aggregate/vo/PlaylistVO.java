package com.muze.domain.mapinplaylist.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class PlaylistVO {
    @Column(nullable = false, name = "playlist_id")
    private Long id;
    public PlaylistVO(Long id){
        this.id = id;
    }

}
