package com.cognizant.spring_learn.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Key signingKey;

    // The secret must be at least 32 bytes (256 bits) for HS256
    public JwtService(@Value("${jwt.secret:dev-secret-dev-secret-dev-secret-1234567890123456}") String secret) {
        this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiry = new Date(nowMillis + 24 * 60 * 60 * 1000); // 24h

        return Jwts.builder()
                .subject(username)           
                .issuedAt(now)               
                .expiration(expiry)          
                .signWith(signingKey)        
                .compact();
    }
}