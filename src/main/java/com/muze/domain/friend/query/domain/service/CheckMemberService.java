package com.muze.domain.friend.query.domain.service;

import com.muze.domain.member.command.domain.aggregate.entity.Member;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface CheckMemberService {
    FindMemberDTO checkMember(Long memberId);
}
