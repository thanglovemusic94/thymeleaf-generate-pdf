package com.example.thymeleafgeneratepdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.context.Context;

@SpringBootApplication
public class ThymeleafGeneratePdfApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafGeneratePdfApplication.class, args);
    }
}
