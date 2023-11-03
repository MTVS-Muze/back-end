package com.muze.domain.friend.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class FriendVO {
    @Column(nullable = false, name = "friend_id")
    private Long id;

    public FriendVO(Long id) {
        this.id = id;
    }
}
