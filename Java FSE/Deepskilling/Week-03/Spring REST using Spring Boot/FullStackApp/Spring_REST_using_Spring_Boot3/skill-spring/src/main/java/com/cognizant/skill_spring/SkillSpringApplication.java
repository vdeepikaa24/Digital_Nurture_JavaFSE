package com.cognizant.skill_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath:employee.xml") 
public class SkillSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillSpringApplication.class, args);
    }
}