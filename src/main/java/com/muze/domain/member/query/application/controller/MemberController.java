package com.muze.domain.member.query.application.controller;

import com.muze.domain.member.query.application.dto.FindMemberDTO;
import com.muze.domain.member.query.application.service.FindMemberService;
import com.muze.global.security.principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final FindMemberService findMemberService;

    @Autowired
    public MemberController(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @GetMapping("/info")
    public ResponseEntity<FindMemberDTO> giveInfo(@AuthenticationPrincipal UserPrincipal userPrincipal){
        FindMemberDTO findMember = findMemberService.findMemberById(userPrincipal.getId());

        return new ResponseEntity<>(findMember, HttpStatus.OK);
    }
}
