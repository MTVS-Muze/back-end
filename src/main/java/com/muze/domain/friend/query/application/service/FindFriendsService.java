package com.muze.domain.friend.query.application.service;

import com.muze.domain.friend.query.domain.repository.FriendMapper;
import com.muze.domain.friend.query.domain.service.CheckMemberService;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindFriendsService {

    private final CheckMemberService checkMemberService;
    private final FriendMapper friendMapper;

    @Autowired
    public FindFriendsService(CheckMemberService checkMemberService, FriendMapper friendMapper) {
        this.checkMemberService = checkMemberService;
        this.friendMapper = friendMapper;
    }

    public List<Long> findFriends(Long memberId){
        return friendMapper.findAllFriendByMemberId(memberId);
    }
    public List<FindMemberDTO> findFriendsInfo(List<Long> friendIds){
        List<FindMemberDTO> friend = new ArrayList<>();
        for (Long friendId:friendIds
             ) {
            friend.add(checkMemberService.checkMember(friendId));
        }
        return friend;
    }
}
