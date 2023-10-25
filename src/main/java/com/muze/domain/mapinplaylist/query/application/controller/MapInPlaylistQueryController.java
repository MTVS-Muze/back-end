package com.muze.domain.mapinplaylist.query.application.controller;

import com.muze.domain.mapinplaylist.query.application.dto.MapInPlaylistInfoDTO;
import com.muze.domain.mapinplaylist.query.application.service.MapInPlaylistInfoService;
import com.muze.global.security.principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapinplaylist")
public class MapInPlaylistQueryController {
    private final MapInPlaylistInfoService mapInPlaylistInfoService;

    @Autowired
    public MapInPlaylistQueryController(MapInPlaylistInfoService mapInPlaylistInfoService) {
        this.mapInPlaylistInfoService = mapInPlaylistInfoService;
    }

    @GetMapping
    public ResponseEntity<List<MapInPlaylistInfoDTO>> getMapInPlaylist(@RequestParam Long playlistId
//                                           ,@AuthenticationPrincipal UserPrincipal userPrincipal
                                           ){

        return ResponseEntity.ok(mapInPlaylistInfoService.findMapByPlaylistId(playlistId));
    }
}
