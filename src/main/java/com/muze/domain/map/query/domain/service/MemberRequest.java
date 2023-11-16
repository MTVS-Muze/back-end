package com.muze.domain.map.query.domain.service;

import com.muze.domain.member.query.application.dto.FindMemberDTO;

public interface MemberRequest {
    public FindMemberDTO findMemberById(Long memberId);
}
