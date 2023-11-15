package com.muze.domain.map.command.application.controller;

import com.muze.domain.map.command.application.dto.CreateMapDTO;
import com.muze.domain.map.command.application.dto.ResponseMapDTO;
import com.muze.domain.map.command.application.service.CreateMapService;
import com.muze.domain.map.command.application.service.DeleteMapService;
import com.muze.domain.map.command.application.service.UpdateMapService;
import com.muze.global.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Map Command Controller")
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


//    @Operation(summary = "Map 등록", description = "사용자가 만든 Map 저장")
//    @PostMapping("/create")
//    public ResponseEntity<ResponseMapDTO> createMap(@RequestPart(value = "dto") RequestMapDTO createDTO
//                                                    ,@RequestPart(value = "file") MultipartFile file
//    ){
//        ResponseMapDTO map = createMapService.createMap(createDTO,file);
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
//    }

    @Operation(summary = "Map 등록", description = "사용자가 만든 Map 저장")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "맵 데이터 저장 성공",
                    content = @Content(
                            schema = @Schema(implementation = ResponseMapDTO.class)))
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseMapDTO> createMap(@RequestBody CreateMapDTO createDTO
                                                    ,@Parameter(hidden = true) @AuthenticationPrincipal UserPrincipal userPrincipal){
        Long memberId = userPrincipal.getId();
        ResponseMapDTO map = createMapService.createMap(createDTO, memberId);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
