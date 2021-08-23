package com.example.carrentalprocessor.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.util.Random;

@Configuration
public class Config {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessorBean() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
