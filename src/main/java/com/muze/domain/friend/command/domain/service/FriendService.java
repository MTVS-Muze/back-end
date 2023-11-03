package com.muze.domain.friend.command.domain.service;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.domain.aggregate.entity.Friend;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    public Friend toFriendEntity(FriendDTO friendDTO){
        return new Friend(friendDTO.getMemberId(),friendDTO.getFriendId());
    }
}
