package com.muze.domain.friend.repository;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.application.service.AddFriendService;
import com.muze.domain.friend.query.domain.repository.FriendMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class FriendRepositoryTests {

    @Autowired
    private AddFriendService addFriendService;
    @Autowired
    private FriendMapper friendMapper;

    private static Stream<Arguments> addFriend() {
        return Stream.of(
                Arguments.of(

                        new FriendDTO(1L, 2L),
                        new FriendDTO(1L, 3L),
                        1L
                )
        );

    }

    @DisplayName("친구목록 조회 테스트")
    @ParameterizedTest
    @MethodSource("addFriend")
    public void findFriendTest(FriendDTO friend1, FriendDTO friend2, Long memberId) {
        addFriendService.addFriend(friend1);
        addFriendService.addFriend(friend2);
        List<Long> friendList =  friendMapper.findAllFriendByMemberId(memberId);
        System.out.println("friendList = " + friendList);
        Assertions.assertTrue(friendList.size()>0);
    }
}
