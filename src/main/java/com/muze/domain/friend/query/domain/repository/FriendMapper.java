package com.muze.domain.friend.query.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMapper {
    List<Long> findAllFriendByMemberId(Long memberId);
 }
