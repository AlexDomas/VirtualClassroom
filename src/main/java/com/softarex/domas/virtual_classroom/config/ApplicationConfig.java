package com.softarex.domas.virtual_classroom.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Setter
@ConfigurationProperties(prefix = "app")
@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

    private String allowed;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins(allowed)
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(3600);
    }

}
