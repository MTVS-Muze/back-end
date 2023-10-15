package com.muze;

import com.muze.configration.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class MuzeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuzeApplication.class, args);
    }

}
