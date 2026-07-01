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
        
        // Call the update test
        testUpdateCountry();
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        
        try {
            // Update Albania (AL) to a new name
            countryService.updateCountry("AL", "Albania Updated");
            
            // Verify by fetching again
            Country country = countryService.findCountryByCode("AL");
            LOGGER.debug("Updated Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        
        LOGGER.info("End testUpdateCountry");
    }

    // You can keep testAddCountry here to use whenever you need to add a fresh record
    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country();
        newCountry.setCode("AL");
        newCountry.setName("Albania");
        countryService.addCountry(newCountry);
        LOGGER.info("End testAddCountry");
    }
}