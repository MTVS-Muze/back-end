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
        String[] paths = {"/like"};

        return GroupedOpenApi
                .builder()
                .group("Muze Swagger v1-like")
                .pathsToMatch(paths)
                .build();
    }
}