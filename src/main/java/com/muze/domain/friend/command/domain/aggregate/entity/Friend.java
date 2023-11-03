package com.muze.domain.friend.command.domain.aggregate.entity;

import com.muze.domain.friend.command.domain.aggregate.vo.FriendVO;
import com.muze.domain.friend.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "FRIEND_TB")
@Getter
@NoArgsConstructor
@ToString
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Embedded
    private MemberVO memberId;
    @Column
    @Embedded
    private FriendVO friendId;

    public Friend(Long memberId,Long friendId) {
        this.memberId = new MemberVO(memberId);
        this.friendId = new FriendVO(friendId);
    }
}