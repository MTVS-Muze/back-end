package com.muze.domain.like.command.domain.aggregate.originenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Origin {
    MAP("MAP","Map"),
    PLAYLIST("PLAYLIST","Playlist");

    private final String key;
    private final String title;
}
