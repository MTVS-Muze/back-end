package com.muze.domain.map.command.domain.aggregate.entity;
import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity(name = "Map")
@Table(name = "MAP_TB")
@NoArgsConstructor
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberVO memberId;

    @Column
    private String title;

    @Column
    private String song;

    @Column
    private String singer;

    @Column
    private String info;

    @Column(columnDefinition = "LONGTEXT")
    private String data;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Map(MemberVO memberId, String title, String song, String singer, String info, String data) {
        this.memberId = memberId;
        this.title = title;
        this.song = song;
        this.singer=singer;
        this.info=info;
        this.data = data;
        this.createdDate=LocalDateTime.now();

    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSong(String song) {
        this.song = song;
    }


    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", song='" + song + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}