package com.muze.domain.playlist.command.application.service;

import com.muze.domain.playlist.command.domain.repository.PlaylistRepository;
import com.muze.domain.playlist.command.domain.servicwe.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlaylistService {
    private final PlaylistRepository playlistRepository;

    @Autowired
    public DeletePlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void deletePlaylist(Long playlistId){
        playlistRepository.deleteById(playlistId);
    }
}
