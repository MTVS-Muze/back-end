package com.muze.domain.playlist.command.application.service;

import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
import com.muze.domain.playlist.command.domain.repository.PlaylistRepository;
import com.muze.domain.playlist.command.domain.servicwe.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaylistService {
    private final PlaylistRepository playlistRepository;
    private final PlaylistService playlistService;

    @Autowired
    public CreatePlaylistService(PlaylistRepository playlistRepository, PlaylistService playlistService) {
        this.playlistRepository = playlistRepository;
        this.playlistService = playlistService;
    }


    public Long CreatePlaylist(CreatePlaylistDTO createPlaylistDTO){
        return playlistRepository.save(playlistService.toPlaylistEntity(createPlaylistDTO)).getId();
    }
}
