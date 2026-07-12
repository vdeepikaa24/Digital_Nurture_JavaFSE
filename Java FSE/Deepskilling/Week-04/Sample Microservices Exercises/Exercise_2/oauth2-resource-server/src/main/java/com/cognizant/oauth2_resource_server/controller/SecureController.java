package com.cognizant.oauth2_resource_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint!";
    }
}