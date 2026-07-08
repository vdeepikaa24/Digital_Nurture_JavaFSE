package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationController(UserDetailsService userDetailsService,
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        // curl -u user:pwd uses Basic Auth header.
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing Basic Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);

        int separatorIndex = credentials.indexOf(':');
        if (separatorIndex < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Basic credentials format");
        }

        String username = credentials.substring(0, separatorIndex);
        String rawPassword = credentials.substring(separatorIndex + 1);

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        String token = jwtService.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(java.util.Map.of("token", token));
    }
}

