package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date; 

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        
        displayDate();
        displayCountry();
        displayCountries();
        
        LOGGER.info("END");
    }

    public static void displayDate() {
        LOGGER.info("START");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }
        LOGGER.info("END");
    }

   public static void displayCountry() {
    LOGGER.info("START");
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
        Country country = context.getBean("in", Country.class); 
        LOGGER.debug("Country : {}", country.toString());
    } catch (Exception e) {
        LOGGER.error("Error retrieving country bean", e);
    }
    LOGGER.info("END");
}
    @SuppressWarnings("unchecked") 
    public static void displayCountries() {
        LOGGER.info("START");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");
            LOGGER.debug("Countries : {}", countries);
        } catch (Exception e) {
            LOGGER.error("Error retrieving country list", e);
        }
        LOGGER.info("END");
    }
}