package com.banking.webapi.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Credit System API")
                        .version("1.0")
                        .description("Banking Credit System API Documentation")
                        .contact(new Contact()
                                .name("Banking Team")
                                .email("contact@banking.com")));
    }
} 