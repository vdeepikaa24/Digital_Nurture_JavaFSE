package com.cognizant.orm_learn.repository;

import java.util.List; // Make sure this import is here
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // Feature 5: Find list of countries matching a partial country name
    List<Country> findByCoNameContaining(String name);
}