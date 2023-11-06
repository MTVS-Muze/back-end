package com.muze.domain.friend.service;

import com.muze.domain.friend.command.application.dto.FriendDTO;
import com.muze.domain.friend.command.application.service.AddFriendService;
import com.muze.domain.friend.command.application.service.DeleteFriendService;
import com.muze.domain.friend.command.domain.repository.FriendRepository;
import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class FriendServiceTests {
    @Autowired
    private AddFriendService addFriendService;
    @Autowired
    private DeleteFriendService deleteFriendService;
    @Autowired
    private FriendRepository friendRepository;

    private static Stream<Arguments> addFriend() {
        return Stream.of(
                Arguments.of(

                        new FriendDTO(1L, 2L)

                )
        );

    }

    @DisplayName("친구 추가 기능 테스트")
    @ParameterizedTest
    @MethodSource("addFriend")
    public void addFriendTest(FriendDTO friendDTO){
        Long id = addFriendService.AddFriend(friendDTO);
        Assertions.assertNotNull(friendRepository.findById(id));
    }

    @DisplayName("친구 삭제 기능 테스트")
    @ParameterizedTest
    @MethodSource("addFriend")
    public void deleteFriend(FriendDTO friendDTO){
        Long id = addFriendService.AddFriend(friendDTO);
        deleteFriendService.deleteFriend(friendDTO);
        Assertions.assertFalse(friendRepository.findById(id).isPresent());
    }
}
