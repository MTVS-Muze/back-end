package com.muze.domain.map.command.application.controller;

import com.muze.domain.map.command.application.dto.RequestMapDTO;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.command.application.service.CreateMapService;
import com.muze.domain.map.command.application.service.DeleteMapService;
import com.muze.domain.map.command.application.service.UpdateMapService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class MapController {

    private final CreateMapService createMapService;

    private final UpdateMapService updateMapService;

    private final DeleteMapService deleteMapService;

    @Autowired
    public MapController(CreateMapService createMapService, UpdateMapService updateMapService, DeleteMapService deleteMapService) {
        this.createMapService = createMapService;
        this.updateMapService = updateMapService;
        this.deleteMapService = deleteMapService;
    }


    @Operation(summary = "Map 등록", description = "사용자가 만든 Map 저장")
    @PostMapping("/create")
    public ResponseEntity<ResponseMapDTO> createMap(@RequestBody RequestMapDTO createDTO){
        ResponseMapDTO map = createMapService.createMap(createDTO);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


}