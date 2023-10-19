package com.muze.domain.map.command.domain.aggregate.entity;

import com.muze.domain.map.command.domain.aggregate.vo.MemberVO;

import javax.persistence.*;

@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberVO memberId;

    @Column(columnDefinition = "LONGTEXT")
    private String data;
}
