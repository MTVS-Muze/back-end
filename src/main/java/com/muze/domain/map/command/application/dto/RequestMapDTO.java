package com.muze.domain.map.command.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Map 요청 객체")
public class RequestMapDTO {
    private Long id;
    private Long memberId;
    private String data;

    public RequestMapDTO(Long memberId, String data) {
        this.memberId = memberId;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestMapDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", data='" + data + '\'' +
                '}';
    }
}
