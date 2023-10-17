package com.muze.domain.member.command.application.service;

import com.muze.domain.member.command.application.dto.CreateMemberDTO;
import com.muze.domain.member.command.domain.aggregate.entity.enumtype.Role;
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
public class CreateMemberServiceTests {

    @Autowired
    private CreateMemberService createMemberService;

    @Autowired
    private UpdateMemberService updateMemberService;

    private static Stream<Arguments> getMemberInfo() {
        return Stream.of(
                Arguments.of(
                        new CreateMemberDTO(
                                "1112",
                                "user1",
                                Role.MEMBER,
                                "profileImage",
                                "email@test.com",
                                "KAKAO"
                        )
                ),
                Arguments.of(
                        new CreateMemberDTO(
                                "1122",
                                "user2",
                                Role.MEMBER,
                                "profileImage",
                                "email@test.com",
                                "KAKAO"
                        )
                )
        );
    }

    @DisplayName("사용자 생성 DTO를 통해 생성 확인")
    @ParameterizedTest
    @MethodSource("getMemberInfo")
    void createMemberTest(CreateMemberDTO createMemberDTO){
        Assertions.assertDoesNotThrow(
                ()->createMemberService.createMember(createMemberDTO)
        );
    }
}
