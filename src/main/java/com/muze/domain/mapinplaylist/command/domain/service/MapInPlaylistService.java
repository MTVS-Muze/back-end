package com.muze.domain.mapinplaylist.command.domain.service;

import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.mapinplaylist.command.domain.aggregate.entity.MapInPlaylist;
import org.springframework.stereotype.Service;

@Service
public class MapInPlaylistService {
    public MapInPlaylist toMapInPlaylistEntity(AddPlaylistDTO addPlaylistDTO){
        return new MapInPlaylist(addPlaylistDTO.getMapId(),addPlaylistDTO.getPlaylistId());
    }
}
