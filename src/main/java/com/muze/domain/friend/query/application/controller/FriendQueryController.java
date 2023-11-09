package com.muze.domain.friend.query.application.controller;

import com.muze.domain.friend.query.application.dto.FriendListsDTO;
import com.muze.domain.friend.query.application.service.FindFriendsService;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/friend")
public class FriendQueryController {
    private final FindFriendsService findFriendsService;

    @Autowired
    public FriendQueryController(FindFriendsService findFriendsService) {
        this.findFriendsService = findFriendsService;
    }

    @GetMapping
    public ResponseEntity<?> findFriend(@RequestParam Long memberId){

        FriendListsDTO friendListsDTO = new FriendListsDTO(findFriendsService.findFriendsInfo(
                findFriendsService.findFriends(memberId)));

        return ResponseEntity.ok(friendListsDTO);
    }

}
