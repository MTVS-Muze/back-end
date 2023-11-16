package com.muze.domain.character.command.domain.aggregate.entity;


import com.muze.domain.character.command.domain.aggregate.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER_TB")
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberVO memberId;

    @Column(nullable = false)
    private Integer color;
    @Column
    private Integer hat;
    @Column
    private Integer face;

    public Character(Long memberId, Integer color, Integer hat, Integer face) {
        this.memberId = new MemberVO(memberId);
        this.color = color;
        this.hat = hat;
        this.face = face;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public void setHat(Integer hat) {
        this.hat = hat;
    }

    public void setFace(Integer face) {
        this.face = face;
    }
}
