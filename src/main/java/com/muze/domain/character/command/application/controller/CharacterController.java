package com.muze.domain.character.command.application.controller;

import com.muze.domain.character.command.application.dto.CharacterCustomizingDTO;
import com.muze.domain.character.command.application.service.CharacterCustomizingService;
import com.muze.global.security.principal.UserPrincipal;
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

    @PostMapping
    public ResponseEntity<?> createOrUpdateCharacter(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestBody CharacterCustomizingDTO characterCustomizingDTO){
        characterCustomizingDTO.setMemberId(userPrincipal.getId());
        System.out.println("characterCustomizingDTO = " + characterCustomizingDTO);
        characterCustomizingService.CharacterCustomizing(characterCustomizingDTO);
        return ResponseEntity.ok("성공적으로 저장되었습니다.");
    }
}
