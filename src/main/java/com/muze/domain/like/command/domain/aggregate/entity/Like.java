package com.muze.domain.like.command.domain.aggregate.entity;

import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import com.muze.domain.like.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "LIKE_TB")
@Getter
@NoArgsConstructor
@ToString
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

    public Like(Long memberId, Origin origin,  Long originId) {
        this.origin = origin;
        this.memberId = new MemberVO(memberId);
        this.originId = originId;
    }
}

