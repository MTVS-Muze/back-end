package com.muze.domain.friend.command.domain.aggregate.entity;

import com.muze.domain.friend.command.domain.aggregate.vo.FriendVO;
import com.muze.domain.friend.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FRIEND_TB")
@Getter
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Embedded
    private MemberVO memberId;
    @Column
    @Embedded
    private FriendVO friendVO;
}