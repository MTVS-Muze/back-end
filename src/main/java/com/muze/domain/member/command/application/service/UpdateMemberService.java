package com.muze.domain.member.command.application.service;

import com.muze.domain.member.command.application.dto.UpdateMemberDTO;
import com.muze.domain.member.command.domain.aggregate.entity.Member;
import com.muze.domain.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateMemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public UpdateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public boolean updateMember(UpdateMemberDTO updateMemberDTO){
        Optional<Member> member = memberRepository.findById(updateMemberDTO.getId());
        if(member.isPresent()){
            Member updateMember = member.get();
            if(!updateMemberDTO.getProfileImage().isEmpty()){
                updateMember.setProfileImage(updateMemberDTO.getProfileImage());
            }
            if(!updateMemberDTO.getName().isEmpty()){
                updateMember.setName(updateMemberDTO.getName());
            }
            return true;
        }else return false;
    }
}
