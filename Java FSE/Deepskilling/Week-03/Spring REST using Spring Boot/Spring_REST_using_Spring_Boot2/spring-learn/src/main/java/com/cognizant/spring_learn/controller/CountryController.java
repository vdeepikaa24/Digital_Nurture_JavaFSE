package com.cognizant.spring_learn.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.model.Country;

@RestController
public class CountryController {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @RequestMapping("/country")
    public Country getCountryIndia() {
        return (Country) context.getBean("in");
    }

    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        return (List<Country>) context.getBean("countryList");
    }

    @GetMapping("/countries/{code}")
    @SuppressWarnings("unchecked")
    public Country getCountry(@PathVariable String code) {
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}