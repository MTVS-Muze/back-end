package com.muze.global.security.command.application.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.muze.global.common.annotation.CustomApiResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({ "status", "message", "timestamp", "body.*" })
public class AuthResponse {

    @JsonUnwrapped // 래핑 해제/평면화 되어야 하는 값을 정의
    private CustomApiResponse apiResponse;
    private AuthResponseBody body;

    public AuthResponse() {}


    public AuthResponse setApiResponse(CustomApiResponse apiResponse) {
        this.apiResponse = apiResponse;
        return this;
    }

    public AuthResponse setBody(AuthResponseBody body) {
        this.body = body;
        return this;
    }
}