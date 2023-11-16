package com.muze.domain.character.query.application.application;

import com.muze.domain.character.query.application.dto.MyCharacterDTO;
import com.muze.domain.character.query.application.service.FindCharacterService;
import com.muze.global.security.principal.UserPrincipal;
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


    @GetMapping
    public ResponseEntity<?> findCharacter(@AuthenticationPrincipal UserPrincipal userPrincipal){
        MyCharacterDTO myCharacter= findCharacterService.findCharacter(userPrincipal.getId());
        return ResponseEntity.ok(myCharacter);
    }
}
