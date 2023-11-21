package com.muze.global.handler;

import com.muze.global.common.response.MapErrorResponse;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = {"com.muze.domain.map"})
public class MapExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyValueException.class)
    protected ResponseEntity<MapErrorResponse> RuntimeException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MapErrorResponse("BAD_REQUEST","제목, 노래, 가수, 맵 데이터 중 값이 존재하지 않습니다"));
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<MapErrorResponse> NullPointerException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MapErrorResponse("BAD_REQUEST","조회하신 Map이 DB에 존재하지 않습니다."));
    }
}
