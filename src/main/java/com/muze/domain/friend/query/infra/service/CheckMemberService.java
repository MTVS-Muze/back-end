package com.muze.domain.friend.query.infra.service;

import com.muze.domain.member.query.application.dto.FindMemberDTO;
import com.muze.domain.member.query.application.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckMemberService implements com.muze.domain.friend.query.domain.service.CheckMemberService {
    private final FindMemberService findMemberService;

    @Autowired
    public CheckMemberService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @Override
    public FindMemberDTO checkMember(Long memberId) {
        return findMemberService.findMemberById(memberId);
    }
}
