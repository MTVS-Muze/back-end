package com.muze.domain.friend.command.application.service;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.domain.repository.FriendRepository;
import com.muze.domain.friend.command.domain.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteFriendService {
    private final FriendRepository friendRepository;
    private final FriendService friendService;


    @Autowired
    public DeleteFriendService(FriendRepository friendRepository, FriendService friendService) {
        this.friendRepository = friendRepository;
        this.friendService = friendService;
    }

    @Transactional
    public void deleteFriend(FriendDTO friendDTO){
        friendRepository.deleteByMemberId_IdAndFriendId_Id(friendDTO.getMemberId(), friendDTO.getFriendId());
    }
}
