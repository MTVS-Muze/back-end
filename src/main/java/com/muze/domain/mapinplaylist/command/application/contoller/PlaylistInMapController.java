package com.muze.domain.mapinplaylist.command.application.contoller;


import com.muze.domain.mapinplaylist.command.application.dto.AddPlaylistDTO;
import com.muze.domain.mapinplaylist.command.application.service.AddPlaylistService;
import com.muze.domain.mapinplaylist.command.application.service.RemovePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/playlistinmap")
public class PlaylistInMapController {

    private final AddPlaylistService addPlaylistService;
    private final RemovePlaylistService removePlaylistService;


    @Autowired
    public PlaylistInMapController(AddPlaylistService addPlaylistService, RemovePlaylistService removePlaylistService) {
        this.addPlaylistService = addPlaylistService;
        this.removePlaylistService = removePlaylistService;
    }

    @PostMapping
    public ResponseEntity<?> AddPlaylist(@RequestBody @Valid AddPlaylistDTO addPlaylistDTO){
        addPlaylistService.addPlaylist(addPlaylistDTO);


        return ResponseEntity.ok("api 호출 성공");
        //여기선 전체 플레이리스트를 호출해야함
    }
}
