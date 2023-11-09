package com.muze.domain.friend.command.application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class FriendDTO {
    @NotNull(message = "memberId는 Null일 수 없습니다.")
    private Long memberId;
    @NotNull(message = "friendId는 Null일 수 없습니다.")
    private Long friendId;


    public FriendDTO(Long memberId, Long friendId) {
        this.memberId = memberId;
        this.friendId = friendId;
    }
}



