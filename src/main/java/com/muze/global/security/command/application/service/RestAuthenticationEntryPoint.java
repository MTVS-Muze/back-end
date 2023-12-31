package com.muze.global.security.command.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("RestAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /*
    Spring Security Exception
            (예시, runtime exception에 속하는 AuthenticationException과 AccessDeniedException)들은 핸들링 할 수 없다.
    DispatcherServlet과 컨트롤러 메소드들이 불러지기 전에 authentication filter에 의해 exception이 던져지기 때문이다.
    이 같은 exception들을 @ExceptionHandler와 @ControllerAdvice로 핸들링하기 위해서는 AuthenticationEntryPoint를 커스텀해야 한다.
    */
    private final HandlerExceptionResolver resolver;

    @Autowired
    public RestAuthenticationEntryPoint(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        resolver.resolveException(request,response,null,authException);
    }
}
