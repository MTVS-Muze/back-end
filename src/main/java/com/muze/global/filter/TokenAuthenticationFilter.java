package com.muze.global.filter;

import com.muze.global.security.command.application.service.CustomUserDetailService;
import com.muze.global.security.command.domain.service.CustomTokenService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final CustomTokenService customTokenService;

    private final CustomUserDetailService customUserDetailService;

    public TokenAuthenticationFilter(CustomTokenService customTokenService, CustomUserDetailService customUserDetailService) {
        this.customTokenService = customTokenService;
        this.customUserDetailService = customUserDetailService;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
