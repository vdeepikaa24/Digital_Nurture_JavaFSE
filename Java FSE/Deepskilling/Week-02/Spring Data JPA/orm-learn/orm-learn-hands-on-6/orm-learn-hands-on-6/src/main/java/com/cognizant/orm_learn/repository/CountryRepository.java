package com.cognizant.orm_learn.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.orm_learn.model.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}
