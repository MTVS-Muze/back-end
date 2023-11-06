package com.muze.domain.friend.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class MemberVO {
    @Column(nullable = false, name = "member_id")
    private Long id;

    public MemberVO(Long id) {
        this.id = id;
    }
}
