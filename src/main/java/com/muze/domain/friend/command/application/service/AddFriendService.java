package com.muze.domain.friend.command.application.service;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.domain.aggregate.entity.Friend;
import com.muze.domain.friend.command.domain.repository.FriendRepository;
import com.muze.domain.friend.command.domain.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFriendService {
    private final FriendRepository friendRepository;
    private final FriendService friendService;

    @Autowired
    public AddFriendService(FriendRepository friendRepository, FriendService friendService) {
        this.friendRepository = friendRepository;
        this.friendService = friendService;
    }

    public Long addFriend(FriendDTO friendDTO){
        Friend newFriend = friendService.toFriendEntity(friendDTO);
        Friend friend = friendRepository.save(newFriend);
        return friend.getId();
    }

    public Boolean checkFriend(FriendDTO friendDTO){
        return friendRepository.findByMemberId_IdAndFriendId_Id(friendDTO.getMemberId(),friendDTO.getFriendId()).isPresent();
    }

}
