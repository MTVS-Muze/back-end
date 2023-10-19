package com.muze.like;

import com.muze.domain.like.command.application.dto.LikeDTO;
import com.muze.domain.like.command.application.service.CancelLikeService;
import com.muze.domain.like.command.application.service.EnrollLikeService;
import com.muze.domain.like.command.domain.aggregate.entity.Like;
import com.muze.domain.like.command.domain.aggregate.originenum.Origin;
import com.muze.domain.like.command.domain.repository.LikeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class LikeServiceTests {
    @Autowired
    private CancelLikeService cancelLikeService;
    @Autowired
    private EnrollLikeService enrollLikeService;
    @Autowired
    private LikeRepository likeRepository;


    private static Stream<Arguments> enrollLike() {
        return Stream.of(
                Arguments.of(

                                new LikeDTO(0L, Origin.MAP,0L)

                )
        );

    }

    @DisplayName("좋아요 등록기능 테스트")
    @ParameterizedTest
    @MethodSource("enrollLike")
    public void enrollLikeTest(LikeDTO likeDTO){
        Long id = enrollLikeService.enrollLike(likeDTO);
        Assertions.assertNotNull(id,"id가 null임");
    }

    @DisplayName("좋아요 삭제 테스트")
    @ParameterizedTest
    @MethodSource("enrollLike")
    public void  cancelLikeTest(LikeDTO likeDTO){
        Long id = enrollLikeService.enrollLike(likeDTO);
        cancelLikeService.CancelLike(id);
        Assertions.assertFalse(likeRepository.findById(id).isPresent(),"정상적으로 삭제되지 않음");
    }
}
