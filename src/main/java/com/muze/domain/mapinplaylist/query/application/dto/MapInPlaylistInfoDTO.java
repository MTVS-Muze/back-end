package com.muze.domain.mapinplaylist.query.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class MapInPlaylistInfoDTO {
    private Long id;
    private Long mapId;
    private Long playlistId;

    public MapInPlaylistInfoDTO(Long id, Long mapId, Long playlistId) {
        this.id = id;
        this.mapId = mapId;
        this.playlistId = playlistId;
    }
}
