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
import java.util.HashMap;
import java.util.Map;

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

    @SuppressWarnings("SameParameterValue")
    private String generateJwt(String user) {
        log.info("Generating JWT for user: {}", user);
        // Use the same signing key + algorithm as JwtAuthorizationFilter/JwtService verification
        return jwtService.generateToken(user);
    }

    private String getUser(String authHeader) {
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);
        return credentials.substring(0, credentials.indexOf(':'));
    }

    private String getPassword(String authHeader) {
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);
        return credentials.substring(credentials.indexOf(':') + 1);
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        log.info("AuthenticationController.authenticate() - start");

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Missing Basic Authorization header");
        }

        String username = getUser(authHeader);
        String rawPassword = getPassword(authHeader);

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }

            String token = generateJwt(userDetails.getUsername());

            log.info("JWT generated successfully for user={}", userDetails.getUsername());

            Map<String, String> map = new HashMap<>();
            map.put("token", token);

            return ResponseEntity.ok(map);
        } catch (Exception ex) {
            log.error("Authentication error: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
