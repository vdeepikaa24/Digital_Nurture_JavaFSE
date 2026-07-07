package com.cognizant.spring_rest_service.controller;

import org.springframework.web.bind.annotation.*;
import com.cognizant.spring_rest_service.model.Country;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries") 
public class CountryController {

    // 1. GET All
    @GetMapping
    public List<Country> getAllCountries() {
        return null; 
    }

    // 2. GET Specific
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return null;
    }

    // 3. POST (Create)
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        System.out.println("Start");
        System.out.println(country.getName());
        return country;
    }

    // 4. PUT (Update)
    @PutMapping
    public Country updateCountry(@RequestBody @Valid Country country) {
        // Implementation needed later
        return country;
    }

    // 5. DELETE
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
    }
}