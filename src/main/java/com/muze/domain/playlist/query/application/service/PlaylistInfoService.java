package com.muze.domain.playlist.query.application.service;

import com.muze.domain.playlist.query.application.dto.PlaylistDTO;
import com.muze.domain.playlist.query.domain.repository.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistInfoService {
    private final PlaylistMapper playlistMapper;

    @Autowired
    public PlaylistInfoService(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    public List<PlaylistDTO> findAllPlaylist(){
        return playlistMapper.findAllPlaylist();
    }
    public List<PlaylistDTO> findPlaylistByMemberId(Long memberId){
        return playlistMapper.findPlaylistByMemberId(memberId);
    }
}
