package com.muze.domain.member.command.domain.service;

import com.muze.domain.member.command.application.dto.CreateMemberDTO;
import com.muze.domain.member.command.domain.aggregate.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public Member toMember(CreateMemberDTO createMemberDTO){
        return new Member(createMemberDTO.getName(), createMemberDTO.getEmail(), createMemberDTO.getSub(),
                createMemberDTO.getProfileImage(), createMemberDTO.getPlatform(), createMemberDTO.getRole());
    }
}
