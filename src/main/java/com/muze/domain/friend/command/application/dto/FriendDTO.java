package com.muze.domain.friend.command.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class FriendDTO {
    @Schema(hidden = true)
    private Long memberId;
    @NotNull(message = "friendId는 Null일 수 없습니다.")
    @Schema(description = "친구의 memberId", defaultValue = "1")
    private Long friendId;


    public FriendDTO(Long memberId, Long friendId) {
        this.memberId = memberId;
        this.friendId = friendId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public FriendDTO(Long friendId) {

        this.friendId = friendId;
    }
}



