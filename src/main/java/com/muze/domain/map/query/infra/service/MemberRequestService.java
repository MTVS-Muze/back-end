package com.muze.domain.map.query.infra.service;


import com.muze.domain.map.query.domain.service.MemberRequest;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import com.muze.domain.member.query.application.service.FindMemberService;
import com.muze.global.common.annotation.InfraService;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class MemberRequestService implements MemberRequest {

    private final FindMemberService findMemberService;

    @Autowired
    public MemberRequestService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @Override
    public FindMemberDTO findMemberById(Long memberId) {
        return findMemberService.findMemberById(memberId);
    }
}
