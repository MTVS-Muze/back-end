package com.muze.global.security.command.application.service;

import com.muze.domain.member.command.application.dto.CreateMemberDTO;
import com.muze.domain.member.command.application.dto.UpdateMemberDTO;
import com.muze.domain.member.command.application.service.CreateMemberService;
import com.muze.domain.member.command.application.service.UpdateMemberService;
import com.muze.domain.member.command.domain.aggregate.entity.Member;
import com.muze.domain.member.command.domain.aggregate.entity.enumtype.Role;
import com.muze.domain.member.query.application.dto.FindMemberDTO;
import com.muze.domain.member.query.application.service.FindMemberService;
import com.muze.global.security.command.domain.provider.OAuth2UserInfo;
import com.muze.global.security.command.domain.provider.OAuth2UserInfoFactory;
import com.muze.global.security.principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final CreateMemberService createMemberService;

    private final UpdateMemberService updateMemberService;
    private final FindMemberService findMemberService;

    @Autowired
    public CustomOAuth2UserService(CreateMemberService createMemberService, UpdateMemberService updateMemberService, FindMemberService findMemberService) {
        this.createMemberService = createMemberService;
        this.updateMemberService = updateMemberService;
        this.findMemberService = findMemberService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        System.out.println("oAuth2User = " + oAuth2User);

        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        System.out.println("registrationId = " + registrationId);

        OAuth2UserInfo attributes = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, oAuth2User.getAttributes());
        System.out.println("attributes = " + attributes);
        System.out.println("attributes.getAttributes() = " + attributes.getAttributes());

        UserPrincipal socialUser = saveOrUpdate(attributes, registrationId);

        return socialUser;
    }

    private UserPrincipal saveOrUpdate(OAuth2UserInfo attributes, String provider) {
        FindMemberDTO member = findMemberService.findMemberBySub(attributes.getId());
        UserPrincipal oauthMember;
        if (member == null) {
            CreateMemberDTO createMemberDTO = new CreateMemberDTO(attributes.getId(), attributes.getName(), Role.MEMBER, attributes.getImageUrl(), attributes.getEmail(), provider.toUpperCase());
            Member newMember = createMemberService.createMember(createMemberDTO);
            oauthMember = UserPrincipal.create(newMember, attributes.getAttributes());
        } else {
            UpdateMemberDTO updateMemberDTO = new UpdateMemberDTO( attributes.getId(),attributes.getName(),attributes.getImageUrl());
            boolean updateMemberResult = updateMemberService.updateMember(updateMemberDTO);
            oauthMember = UserPrincipal.create(member, attributes.getAttributes());
        }
        return oauthMember;
    }

}
