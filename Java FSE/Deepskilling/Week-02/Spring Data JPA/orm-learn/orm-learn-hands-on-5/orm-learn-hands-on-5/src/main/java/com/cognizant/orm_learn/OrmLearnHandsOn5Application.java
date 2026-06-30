package com.cognizant.orm_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm_learn.model.Country; // Add this import
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnHandsOn5Application implements CommandLineRunner {

    @Autowired
    private CountryService countryService; 

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnHandsOn5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Find
        System.out.println("Country: " + countryService.findCountryByCode("IN").getCoName());

        // 2. Partial Search
        System.out.println("Countries containing 'India': " + countryService.findCountryByNameContaining("India"));

        // 3. Add
        Country newCountry = new Country("ZZ", "New Country");
        countryService.addCountry(newCountry);
        System.out.println("Added: " + countryService.findCountryByCode("ZZ"));

        // 4. Update
        countryService.updateCountry("ZZ", "Updated Country Name");
        System.out.println("Updated: " + countryService.findCountryByCode("ZZ"));

        // 5. Delete
        countryService.deleteCountry("ZZ");
        System.out.println("Deleted ZZ, check: " + countryService.findCountryByCode("ZZ")); 
    }
}