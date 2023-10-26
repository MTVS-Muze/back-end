package com.muze.domain.mapinplaylist.query.application.service;

import com.muze.domain.mapinplaylist.query.application.dto.MapInPlaylistInfoDTO;
import com.muze.domain.mapinplaylist.query.domain.repository.MapInPlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapInPlaylistInfoService {
    private final MapInPlaylistMapper mapInPlaylistMapper;


    @Autowired
    public MapInPlaylistInfoService(MapInPlaylistMapper mapInPlaylistMapper) {
        this.mapInPlaylistMapper = mapInPlaylistMapper;
    }

    public List<MapInPlaylistInfoDTO> findMapByPlaylistId(Long playlistId){
        return mapInPlaylistMapper.findMapByPlaylistId(playlistId);
    }
}

