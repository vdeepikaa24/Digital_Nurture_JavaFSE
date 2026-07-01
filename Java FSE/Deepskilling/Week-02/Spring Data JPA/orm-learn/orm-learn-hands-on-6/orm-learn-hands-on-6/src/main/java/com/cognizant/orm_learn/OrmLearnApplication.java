package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        // Call the test method
        testDeleteCountry();
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        
        // Delete the country with code "AL"
        countryService.deleteCountry("AL");
        
        // Verify deletion by trying to find it
        try {
            countryService.findCountryByCode("AL");
            LOGGER.info("Country found (Deletion failed)");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country successfully deleted: {}", e.getMessage());
        }
        
        LOGGER.info("End testDeleteCountry");
    }
}