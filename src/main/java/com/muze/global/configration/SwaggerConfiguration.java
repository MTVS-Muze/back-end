package com.muze.global.configration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Muze",
                description = "API Statement for Muze",
                version = "v1"
        )
)

public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi like(){
        String[] paths = {"/like/**"};

        return GroupedOpenApi
                .builder()
                .group("Muze Swagger v1-like")
                .pathsToMatch(paths)
                .build();
    }
    @Bean
    public GroupedOpenApi friend(){
        String[] paths = {"/friend/**"};

        return GroupedOpenApi
                .builder()
                .group("Muze Swagger v1-friend")
                .pathsToMatch(paths)
                .build();
    }
    @Bean
    public GroupedOpenApi map(){
        String[] paths ={"/map/**"};

        return GroupedOpenApi
                .builder()
                .group("Muze Sawgger v1-map")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi member(){
        String[] paths ={"/member/**"};

        return GroupedOpenApi
                .builder()
                .group("Muze Sawgger v1-member")
                .pathsToMatch(paths)
                .build();
    }
}