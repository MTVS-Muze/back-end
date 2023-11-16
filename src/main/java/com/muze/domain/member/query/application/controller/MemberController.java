package com.muze.domain.member.query.application.controller;

import com.muze.domain.map.query.application.dto.FindMapDTO;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import com.muze.domain.member.query.application.service.FindMemberService;
import com.muze.global.security.principal.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "사용자 정보 조회", description = "토큰으로 사용자 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "사용자 정보 조회 성공",
                    content = @Content(
                            schema = @Schema(implementation = FindMemberDTO.class)))
    })
    @GetMapping("/info")
    public ResponseEntity<FindMemberDTO> giveInfo(@Parameter(hidden = true) @AuthenticationPrincipal UserPrincipal userPrincipal){
        FindMemberDTO findMember = findMemberService.findMemberById(userPrincipal.getId());
        return new ResponseEntity<>(findMember, HttpStatus.OK);
    }
}
