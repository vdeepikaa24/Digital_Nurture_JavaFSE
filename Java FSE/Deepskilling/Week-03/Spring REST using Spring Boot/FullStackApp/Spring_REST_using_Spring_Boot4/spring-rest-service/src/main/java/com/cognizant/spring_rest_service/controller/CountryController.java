package com.cognizant.spring_rest_service.controller;

import org.springframework.web.bind.annotation.*;
import com.cognizant.spring_rest_service.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        System.out.println("Start");
        System.out.println(country.toString());

        // Create validator factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Validation is done against the annotations defined in country bean
        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        List<String> errors = new ArrayList<String>();

        // Accumulate all errors in an ArrayList of type String
        for (ConstraintViolation<Country> violation : violations) {
            errors.add(violation.getMessage());
        }

        // Throw exception so that the user receives an appropriate error message
        if (violations.size() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }

        return country;
    }
}