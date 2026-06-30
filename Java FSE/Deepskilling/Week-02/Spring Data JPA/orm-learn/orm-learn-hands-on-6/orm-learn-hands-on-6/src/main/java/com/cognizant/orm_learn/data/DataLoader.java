package com.cognizant.orm_learn.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;

    public DataLoader(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) {
        countryRepository.save(new Country("IN", "India"));
    }
}
