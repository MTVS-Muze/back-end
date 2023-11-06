package com.muze.domain.friend.command.application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class FriendDTO {
    private Long memberId;
    private Long friendId;

    public FriendDTO(Long memberId, Long friendId) {
        this.memberId = memberId;
        this.friendId = friendId;
    }
}



