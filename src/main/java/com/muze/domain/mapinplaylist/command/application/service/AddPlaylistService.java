package com.muze.domain.mapinplaylist.command.application.service;

import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.mapinplaylist.command.domain.repository.MapInPlaylistRepository;
import com.muze.domain.mapinplaylist.command.domain.service.MapInPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPlaylistService {
    private final MapInPlaylistRepository mapInPlaylistRepository;
    private final MapInPlaylistService mapInPlaylistService;

    @Autowired
    public AddPlaylistService(MapInPlaylistRepository mapInPlaylistRepository, MapInPlaylistService mapInPlaylistService) {
        this.mapInPlaylistRepository = mapInPlaylistRepository;
        this.mapInPlaylistService = mapInPlaylistService;
    }

    public Long addPlaylist(AddPlaylistDTO addPlaylistDTO){
        return mapInPlaylistRepository.save(mapInPlaylistService.toMapInPlaylistEntity(addPlaylistDTO)).getId();
    }
}
