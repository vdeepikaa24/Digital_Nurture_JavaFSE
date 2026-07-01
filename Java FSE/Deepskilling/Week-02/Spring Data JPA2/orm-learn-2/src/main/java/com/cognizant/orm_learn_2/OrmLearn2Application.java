package com.cognizant.orm_learn_2;

import com.cognizant.orm_learn_2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearn2Application implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearn2Application.class, args);
    }

   @Override
public void run(String... args) throws Exception {
    System.out.println("--- All matching 'ou' ---");
    countryRepository.findByNameContaining("ou").forEach(System.out::println);

    System.out.println("--- Sorted 'ou' ---");
    countryRepository.findByNameContainingOrderByNameAsc("ou").forEach(System.out::println);

    System.out.println("--- Starts with 'Z' ---");
    countryRepository.findByNameStartingWith("Z").forEach(System.out::println);
}
}