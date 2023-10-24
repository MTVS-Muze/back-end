package com.muze.domain.playlist.command.domain.servicwe;

import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
import com.muze.domain.playlist.command.domain.aggregate.entity.Playlist;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    public Playlist toPlaylistEntity(CreatePlaylistDTO createPlaylistDTO){
        return new Playlist(createPlaylistDTO.getMemberId(), createPlaylistDTO.getTitle());
    }
}
