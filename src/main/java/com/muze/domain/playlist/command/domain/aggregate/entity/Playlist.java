package com.muze.domain.playlist.command.domain.aggregate.entity;

import com.muze.domain.playlist.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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


    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;
  
    public Playlist(Long memberId, String title) {
        this.memberId = new MemberVO(memberId);
        this.title = title;
        this.createdDate = LocalDateTime.now();
    }
}

