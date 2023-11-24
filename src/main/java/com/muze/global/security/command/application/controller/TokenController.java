package com.muze.global.security.command.application.controller;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.map.query.application.dto.FindResponseDTO;
import com.muze.domain.map.query.domain.repository.MapMapper;
import com.muze.global.common.annotation.CurrentMember;
import com.muze.global.security.principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TokenController {

    private final MapMapper mapMapper;

    @Autowired
    public TokenController(MapMapper mapMapper) {
        this.mapMapper = mapMapper;
    }

//    @GetMapping("/main")
//    public String tokenPage(@RequestParam("token") String token){
//        System.out.println("token = " + token);
//        Map<String, String> body =new HashMap<>();
//        body.put("token", token);
////        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
//        return token;
//    }

//    @GetMapping("/give/token")
//    public ResponseEntity<?> giveToken(@CurrentMember UserPrincipal userPrincipal){
//        System.out.println("통과!@!@!)@!)@!)@)!)@");
//        System.out.println("userPrincipal = " + userPrincipal);
////        Long memberId = userPrincipal.getId();
////        System.out.println("memberId = " + memberId);
//        Map<String, String> body = new HashMap<>();
//        body.put("token", "token is here!");
//        return new ResponseEntity<>(body,HttpStatus.ACCEPTED);
//    }

//    @PostMapping("/test/map")
//    public ResponseEntity<?> test (@RequestBody Map<?,?> map,
//                                   @AuthenticationPrincipal UserPrincipal userPrincipal){
//        System.out.println("map = " + map);
//        System.out.println("userPrincipal = " + userPrincipal);
//        return new ResponseEntity<>("hi", HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("/test/mk")
//    public ResponseEntity<?> test1 (){
//        FindMapDTO map = mapMapper.findById(1L);
//
//        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
//    }

    @GetMapping("/page")
    public String mainPage(){
        System.out.println("귤은 맛있을까?" );
        return "main";
    }

}
