package com.muze.like.repository;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.application.service.EnrollLikeService;
import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import com.muze.domain.like.query.domain.repository.LikeMapper;
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
public class LikeRepositoryTests {
    @Autowired
    private EnrollLikeService enrollLikeService;
    @Autowired
    private LikeMapper likeMapper;

    private static Stream<Arguments> enrollLike() {
        return Stream.of(
                Arguments.of(

                        new LikeDTO(0L, Origin.MAP,0L),
                        new LikeDTO(1L, Origin.MAP,0L)

                )
        );

    }

    @DisplayName("좋아요 repository 테스트")
    @ParameterizedTest
    @MethodSource("enrollLike")
    public void isLikedTest(LikeDTO likeDTO){
        enrollLikeService.enrollLike(likeDTO);
        Assertions.assertTrue(likeMapper.isLiked(likeDTO.getMemberId(),likeDTO.getOrigin(),likeDTO.getOriginId()));

    }

    @DisplayName("좋아요 수 카운트 테트트")
    @ParameterizedTest
    @MethodSource("enrollLike")
    public void isLikedTest(LikeDTO likeDTO1, LikeDTO likeDTO2){
        enrollLikeService.enrollLike(likeDTO1);
        enrollLikeService.enrollLike(likeDTO2);

        Assertions.assertEquals(2, (int) likeMapper.getCount(likeDTO1.getOrigin(), likeDTO1.getOriginId()));

    }
}
