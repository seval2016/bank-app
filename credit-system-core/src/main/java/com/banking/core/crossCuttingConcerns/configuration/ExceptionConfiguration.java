package com.banking.core.crossCuttingConcerns.configuration;

import com.banking.core.crossCuttingConcerns.exceptions.handlers.HttpExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfiguration {
    
    @Bean
    public HttpExceptionHandler httpExceptionHandler() {
        return new HttpExceptionHandler();
    }
} 