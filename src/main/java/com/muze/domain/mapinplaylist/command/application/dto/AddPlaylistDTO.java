package com.muze.domain.mapinplaylist.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@ToString
public class AddPlaylistDTO {
    @NotNull
    @Positive
    private Long playlistId;

    @NotNull
    @Positive
    private Long mapId;

    public AddPlaylistDTO(Long playlistId, Long mapId) {
        this.playlistId = playlistId;
        this.mapId = mapId;
    }
}
