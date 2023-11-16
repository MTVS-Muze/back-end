package com.muze.domain.member.query.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FindMemberDTO {

    @Schema(description = "DB 식별자 번호", defaultValue = "1")
    private Long id;

    @Schema(description = "사용자 이름", defaultValue = "진용민")
    private String name;

    @Schema(description = "플랫폼 식별자 번호", defaultValue = "123456")
    private String sub;

    @Schema(description = "사용자 프로필 url", defaultValue = "http://k.kakao.image")
    private String profileImage;

    @Schema(description = "회원가입 플랫폼", defaultValue = "KAKAO")
    private String platform;

    @Schema(description = "사용자 권한", defaultValue = "MEMBER")
    private String role;

    @Schema(description = "사용자 email", defaultValue = "jym1234@naver.com")
    private String email;
}
