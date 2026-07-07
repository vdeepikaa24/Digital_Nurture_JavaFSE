package com.cognizant.spring_rest_service.controller;

import org.springframework.web.bind.annotation.*;
import com.cognizant.spring_rest_service.model.Country;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        System.out.println("Start");
        System.out.println(country.toString());
        
        return country;
    }
}