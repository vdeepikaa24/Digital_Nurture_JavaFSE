package com.cognizant.oauth2_client_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cognizant.oauth2_client_exercise")
public class Oauth2ClientExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientExerciseApplication.class, args);
    }
}