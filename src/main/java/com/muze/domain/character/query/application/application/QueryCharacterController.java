package com.muze.domain.character.query.application.application;

import com.muze.domain.character.query.application.dto.MyCharacterDTO;
import com.muze.domain.character.query.application.service.FindCharacterService;
import com.muze.global.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class QueryCharacterController {
    private final FindCharacterService findCharacterService;

    @Autowired
    public QueryCharacterController(FindCharacterService findCharacterService) {
        this.findCharacterService = findCharacterService;
    }


    @Operation(summary = "캐릭터 조회", description = "캐릭터 커스터마이징 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "캐릭터 커스터마이징 조회 성공",
                    content = @Content(
                            schema = @Schema())),
    })
    @GetMapping
    public ResponseEntity<?> findCharacter(
            @Parameter(hidden = true) @AuthenticationPrincipal UserPrincipal userPrincipal){
        MyCharacterDTO myCharacter= findCharacterService.findCharacter(userPrincipal.getId());
        return ResponseEntity.ok(myCharacter);
    }
}
