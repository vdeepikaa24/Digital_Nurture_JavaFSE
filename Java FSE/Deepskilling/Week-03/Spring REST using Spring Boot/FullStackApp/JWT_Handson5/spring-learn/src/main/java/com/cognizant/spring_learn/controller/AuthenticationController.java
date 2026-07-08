package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

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

    /**
     * Exercise helper: decode Basic Authorization header and return username.
     */
    private String getUser(String authHeader) {
        log.debug("getUser() - authHeader={} ", authHeader);
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            log.debug("getUser() - Missing/invalid Basic Authorization header");
            return "";
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);

        int separatorIndex = credentials.indexOf(':');
        if (separatorIndex < 0) {
            log.debug("getUser() - Invalid Basic credentials format");
            return "";
        }

        String user = credentials.substring(0, separatorIndex);
        log.debug("getUser() - decoded user={}", user);
        return user;
    }

    private String getPassword(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return "";
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);

        int separatorIndex = credentials.indexOf(':');
        if (separatorIndex < 0) {
            return "";
        }

        return credentials.substring(separatorIndex + 1);
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        log.info("AuthenticationController.authenticate() - start");

        String authHeader = request.getHeader("Authorization");
        log.debug("authenticate() received authHeader={}", authHeader);

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            log.info("AuthenticationController.authenticate() - end (unauthorized: missing Basic Authorization)");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing Basic Authorization header");
        }

        String username = getUser(authHeader);
        String rawPassword = getPassword(authHeader);

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (Exception ex) {
            log.info("AuthenticationController.authenticate() - end (unauthorized: invalid username or password)");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
            log.info("AuthenticationController.authenticate() - end (unauthorized: invalid username or password)");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        String token = jwtService.generateToken(userDetails.getUsername());
        log.info("AuthenticationController.authenticate() - end");
        return ResponseEntity.ok(java.util.Map.of("token", token));
    }
}

