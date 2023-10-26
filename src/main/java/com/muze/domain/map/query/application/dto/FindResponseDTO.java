package com.muze.domain.map.query.application.dto;


import lombok.Getter;
import org.springframework.core.io.InputStreamResource;

@Getter
public class FindResponseDTO {

    FindMapDTO text;

    InputStreamResource file;

    public FindResponseDTO(FindMapDTO text, InputStreamResource file) {
        this.text = text;
        this.file = file;
    }

    @Override
    public String toString() {
        return "FindResponseDTO{" +
                "text=" + text +
                ", file=" + file +
                '}';
    }
}
