package com.muze.domain.friend.command.domain.repository;

import com.muze.domain.friend.command.domain.aggregate.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
    void deleteByMemberId_IdAndFriendId_Id(Long memberId, Long FriendId);
}
