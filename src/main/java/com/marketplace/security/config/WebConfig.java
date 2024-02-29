package com.marketplace.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth")
                .allowedOrigins("http://localhost:5173") // Reemplaza con la dirección IP del equipo de frontend
                .allowedMethods("GET", "POST", "PUT","PATCH", "DELETE")
                .allowedHeaders("*");
    }
}