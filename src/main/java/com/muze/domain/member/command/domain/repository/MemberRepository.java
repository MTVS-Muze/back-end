package com.muze.domain.member.command.domain.repository;

import com.muze.domain.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
