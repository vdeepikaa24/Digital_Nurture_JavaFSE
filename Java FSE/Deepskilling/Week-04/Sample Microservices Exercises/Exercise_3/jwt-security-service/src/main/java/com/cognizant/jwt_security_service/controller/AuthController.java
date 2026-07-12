package com.cognizant.jwt_security_service.controller;

import com.cognizant.jwt_security_service.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Public endpoint to generate a token for a user
    @GetMapping("/auth/login")
    public String login(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    // Secured endpoint requiring a valid JWT
    @GetMapping("/secure/hello")
    public String secureHello() {
        return "Hello! You have securely accessed this endpoint using a valid custom JWT.";
    }
}