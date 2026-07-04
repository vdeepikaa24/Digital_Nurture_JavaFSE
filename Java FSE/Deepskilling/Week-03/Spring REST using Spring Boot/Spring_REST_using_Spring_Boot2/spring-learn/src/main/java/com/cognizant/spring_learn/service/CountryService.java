package com.cognizant.spring_learn.service;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {
    
    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); 
    }
}