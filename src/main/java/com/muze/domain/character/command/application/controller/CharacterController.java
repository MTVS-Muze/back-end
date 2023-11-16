package com.muze.domain.character.command.application.controller;

import com.muze.domain.character.command.application.dto.CharacterCustomizingDTO;
import com.muze.domain.character.command.application.service.CharacterCustomizingService;
import com.muze.global.common.annotation.CurrentMember;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/character")
public class CharacterController {
    private final CharacterCustomizingService characterCustomizingService;

    @Autowired
    public CharacterController(CharacterCustomizingService characterCustomizingService) {
        this.characterCustomizingService = characterCustomizingService;
    }


    @Operation(summary = "캐릭터 커스터마이징 등록", description = "새로운 커스터마이징을 등록하거나 업데이트함")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "커스터마이징 저장 성공",
                    content = @Content(
                            schema = @Schema())),
    })
    @PostMapping
    public ResponseEntity<?> createOrUpdateCharacter(
            @Parameter(hidden = true) @CurrentMember UserPrincipal userPrincipal,
            @RequestBody CharacterCustomizingDTO characterCustomizingDTO){
        characterCustomizingDTO.setMemberId(userPrincipal.getId());
        System.out.println("characterCustomizingDTO = " + characterCustomizingDTO);
        characterCustomizingService.CharacterCustomizing(characterCustomizingDTO);
        return ResponseEntity.ok("성공적으로 저장되었습니다.");
    }
}
