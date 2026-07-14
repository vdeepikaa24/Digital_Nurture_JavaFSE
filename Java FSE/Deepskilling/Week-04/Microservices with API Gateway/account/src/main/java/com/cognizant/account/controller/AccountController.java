package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController 
public class AccountController {

    @GetMapping("/accounts/{number}")
    public String getAccount(@PathVariable String number) {
        return "{ \"number\": \"" + number + "\", \"type\": \"savings\", \"balance\": 234343 }";
    }
}