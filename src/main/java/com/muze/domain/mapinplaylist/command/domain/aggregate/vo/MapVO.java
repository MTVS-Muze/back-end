package com.muze.domain.mapinplaylist.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class MapVO {
    @Column(nullable = false, name = "map_id")
    private Long id;

    public MapVO(Long id) {
        this.id = id;
    }
}