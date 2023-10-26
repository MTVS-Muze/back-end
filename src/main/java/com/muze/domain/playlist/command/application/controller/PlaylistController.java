package com.muze.domain.playlist.command.application.controller;

import com.muze.domain.playlist.command.application.dto.CreatePlaylistDTO;
import com.muze.domain.playlist.command.application.service.CreatePlaylistService;
import com.muze.domain.playlist.command.application.service.DeletePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private final CreatePlaylistService createPlaylistService;
    private final DeletePlaylistService deletePlaylistService;


    @Autowired
    public PlaylistController(CreatePlaylistService createPlaylistService, DeletePlaylistService deletePlaylistService) {
        this.createPlaylistService = createPlaylistService;
        this.deletePlaylistService = deletePlaylistService;
    }


    @PostMapping
    public ResponseEntity<?> createPlaylist(@RequestBody @Valid CreatePlaylistDTO createPlaylistDTO){
        createPlaylistService.CreatePlaylist(createPlaylistDTO);
        return ResponseEntity.ok("api 호출 성공");
        //생성된 dto를 return해야됨.
    }
}
