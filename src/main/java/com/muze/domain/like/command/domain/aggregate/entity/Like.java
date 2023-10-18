package com.muze.domain.like.command.domain.aggregate.entity;

import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import com.muze.domain.like.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Origin origin;

    @Embedded
    private MemberVO memberId;

    @Column(nullable = false, name = "origin_id")
    private Long originId;

    public Like(Origin origin, MemberVO memberId, Long originId) {
        this.origin = origin;
        this.memberId = memberId;
        this.originId = originId;
    }
}

