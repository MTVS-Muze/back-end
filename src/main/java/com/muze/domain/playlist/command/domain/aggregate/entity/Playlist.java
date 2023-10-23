package com.muze.domain.playlist.command.domain.aggregate.entity;

import com.muze.domain.playlist.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "PLAYLIST_TB")
@Getter
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberVO memberId;

    @Column
    private String title;
    public Playlist(MemberVO memberId, String title) {
        this.memberId = memberId;
        this.title = title;
    }
}

