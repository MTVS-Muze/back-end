package com.muze.domain.member.query.domain.repository;

import com.muze.domain.member.query.application.dto.FindMemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    FindMemberDTO findById(Long id);

    FindMemberDTO findBySub(String sub);

    FindMemberDTO findByEmail(String email);
}
