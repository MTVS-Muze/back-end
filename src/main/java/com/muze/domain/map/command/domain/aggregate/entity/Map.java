package com.muze.domain.map.command.domain.aggregate.entity;

import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(columnDefinition = "LONGTEXT")
    private String data;

    public Map(MemberVO memberId, String data) {
        this.memberId = memberId;
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
