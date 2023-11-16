package com.muze.global.configration;

import com.muze.domain.member.command.domain.aggregate.entity.enumtype.Role;
import com.muze.global.filter.AuthenticationExceptionFilter;
import com.muze.global.filter.NullPointExceptionFilter;
import com.muze.global.filter.TokenAuthenticationFilter;
import com.muze.global.security.command.application.service.CustomOAuth2UserService;
import com.muze.global.security.command.application.service.CustomUserDetailService;
import com.muze.global.security.command.domain.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import com.muze.global.handler.CustomAccessDeniedHandler;
import com.muze.global.handler.CustomOAuth2FailureHandler;
import com.muze.global.handler.CustomOAuth2SucessHandler;
import com.muze.global.security.command.domain.service.CustomTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomOAuth2SucessHandler customOAuth2SucessHandler;
    private final CustomOAuth2FailureHandler customOAuth2FailureHandler;

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    private final NullPointExceptionFilter nullPointExceptionFilter;

    @Autowired
    private CustomTokenService customTokenService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    @Qualifier("RestAuthenticationEntryPoint")
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;
    public HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository(){
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    AuthenticationExceptionFilter authenticationExceptionFilter(HandlerExceptionResolver resolver) {
        return new AuthenticationExceptionFilter(resolver);
    }
    TokenAuthenticationFilter tokenAuthenticationFilter(CustomTokenService customTokenService,
                                                        CustomUserDetailService customUserDetailService){
        return new TokenAuthenticationFilter(customTokenService,customUserDetailService);
    }
    @Bean
    @Order(0)
    public SecurityFilterChain exceptionSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .requestCache().disable()
                .securityContext().disable()
                .sessionManagement().disable()
                .requestMatchers((matchers) ->
                        matchers
                                .antMatchers(
                                        "/", "/error","/favicon.ico", "/**/*.png",
                                        "/**/*.gif", "/**/*.svg", "/**/*.jpg",
                                        "/**/*.html", "/**/*.css", "/**/*.js"
                                )
                                .antMatchers(
                                        "/swagger", "/swagger-ui.html", "/swagger-ui/**",
                                        "/api-docs", "/api-docs/**", "/v3/api-docs/**"
                                )
                                .antMatchers(
                                        "/login/**","/auth/**","/map/**", "/like/**", "/friend/**", "/character/**"
                                )
                )
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll());

        return http.build();
    }


    @Bean
    @Order(1)
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
                .httpBasic().disable()
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .formLogin()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)

                .and()

                .authorizeRequests()
                    .antMatchers("/**").permitAll() // 요청 url로 수정해야함
                    .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
//                .anyRequest()
//                .authenticated()  어떤걸 의미하는지
                .and()

                .oauth2Login()
                    .authorizationEndpoint()
                        .baseUri("/oauth2/authorize")
                    .authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository())
                .and()
                    .redirectionEndpoint()
                        .baseUri("/oauth2/callback/*")
                .and()

                .userInfoEndpoint()
                    .userService(customOAuth2UserService)
                .and()
                .successHandler(customOAuth2SucessHandler)
                .failureHandler(customOAuth2FailureHandler);

        http
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler);

        http
                .addFilterBefore(tokenAuthenticationFilter(customTokenService,customUserDetailService), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationExceptionFilter(resolver), TokenAuthenticationFilter.class)
                .addFilterBefore(nullPointExceptionFilter, AuthenticationExceptionFilter.class);

        return http.build();
    }
}
