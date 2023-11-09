package com.muze.domain.friend.query.application.dto;

import com.muze.domain.member.query.application.dto.FindMemberDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class FriendListsDTO {
    private List<FindMemberDTO> friendList;

    public FriendListsDTO(List<FindMemberDTO> friendList) {
        this.friendList = friendList;
    }
}

