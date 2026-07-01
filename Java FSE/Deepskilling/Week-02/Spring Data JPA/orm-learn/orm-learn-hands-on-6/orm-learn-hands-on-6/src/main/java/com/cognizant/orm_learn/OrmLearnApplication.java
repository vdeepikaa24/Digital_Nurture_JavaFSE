package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        // Call the new test method
        testAddCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        
        // 1. Create new instance
        Country newCountry = new Country();
        newCountry.setCode("AL");
        newCountry.setName("Albania");
        
        try {
            // 2. Call service to add
            countryService.addCountry(newCountry);
            
            // 3. Find and verify
            Country foundCountry = countryService.findCountryByCode("AL");
            LOGGER.debug("Country: {}", foundCountry);
            
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        
        LOGGER.info("End testAddCountry");
    }
}