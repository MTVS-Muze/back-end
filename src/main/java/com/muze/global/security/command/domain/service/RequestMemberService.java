package com.muze.global.security.command.domain.service;

import com.muze.domain.member.query.application.dto.FindMemberDTO;

public interface RequestMemberService {
    FindMemberDTO findMemberById(Long memberId);
}
