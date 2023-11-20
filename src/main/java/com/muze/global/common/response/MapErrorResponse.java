package com.muze.global.common.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MapErrorResponse {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String error;
    private final String message;

    public MapErrorResponse( String error, String message) {
        this.error = error;
        this.message = message;
    }
}
