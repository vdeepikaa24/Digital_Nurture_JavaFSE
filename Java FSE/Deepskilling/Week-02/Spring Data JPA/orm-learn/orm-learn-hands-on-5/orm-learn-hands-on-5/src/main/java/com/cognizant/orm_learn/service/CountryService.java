package com.cognizant.orm_learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Added import
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Feature 1: Find a country based on country code
    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) {
        return countryRepository.findById(countryCode).orElse(null);
    }

    // Feature 2: Add new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Feature 3: Update country
    @Transactional
    public void updateCountry(String countryCode, String newName) {
        Country country = countryRepository.findById(countryCode).orElse(null);
        if (country != null) {
            country.setCoName(newName);
            countryRepository.save(country);
        }
    }

    // Feature 4: Delete country
    @Transactional
    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

    // Feature 5: Find list of countries matching a partial country name
    @Transactional(readOnly = true)
    public List<Country> findCountryByNameContaining(String name) {
        return countryRepository.findByCoNameContaining(name);
    }
}