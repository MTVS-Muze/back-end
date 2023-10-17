package com.muze.domain.member.command.application.dto;

import com.muze.domain.member.command.domain.aggregate.entity.enumtype.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberDTO {
    private Long id;
    private String sub;
    private String name;
    private Role role;
    private String profileImage;
    private String platform;

    public UpdateMemberDTO(Role role){
        this.role=role;
    }
    public UpdateMemberDTO(String id, String name, String profileImage) {
        this.id= Long.valueOf(id);
        this.name = name;
        this.profileImage = profileImage;
    }

    public UpdateMemberDTO(String sub, String name, Role role, String profileImage, String platform) {
        this.sub = sub;
        this.name = name;
        this.role = role;
        this.profileImage = profileImage;
        this.platform = platform;
    }

}
