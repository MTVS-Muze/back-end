package com.muze.domain.mapinplaylist.command.application.service;

import com.muze.domain.mapinplaylist.command.domain.repository.MapInPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemovePlaylistService {
    private final MapInPlaylistRepository mapInPlaylistRepository;

    @Autowired
    public RemovePlaylistService(MapInPlaylistRepository mapInPlaylistRepository) {
        this.mapInPlaylistRepository = mapInPlaylistRepository;
    }

     public void removePlaylist(Long id){
        mapInPlaylistRepository.deleteById(id);
     }

     @Transactional
     public  void removeAllPlaylist(Long id){
        mapInPlaylistRepository.deleteAllByPlaylistId_Id(id);
     }
}
