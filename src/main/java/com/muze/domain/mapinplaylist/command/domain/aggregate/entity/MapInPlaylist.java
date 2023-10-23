package com.muze.domain.mapinplaylist.command.domain.aggregate.entity;


import com.muze.domain.mapinplaylist.command.domain.aggregate.vo.MapVO;
import com.muze.domain.mapinplaylist.command.domain.aggregate.vo.PlaylistVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MAPINPLAYLIST_TB")
@Getter
@NoArgsConstructor
public class MapInPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MapVO mapId;

    @Embedded
    private PlaylistVO playlistId;

}
