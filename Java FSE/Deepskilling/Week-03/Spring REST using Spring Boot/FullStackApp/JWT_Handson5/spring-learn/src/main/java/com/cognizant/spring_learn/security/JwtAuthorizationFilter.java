package com.cognizant.spring_learn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Added import
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections; // Added import

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        if (req.getRequestURI().equals("/authenticate")) {
            chain.doFilter(req, res);
            return;
        }

        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("Authentication set for user: {}", authentication.getPrincipal());
        }
        
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            try {
                String jwt = token.substring(7);

                Claims claims = Jwts.parser()
                        .verifyWith(JwtService.getSigningKey()) 
                        .build()
                        .parseSignedClaims(jwt)
                        .getPayload();

                String user = claims.getSubject();
                if (user != null) {
                    // Providing a default role (ROLE_USER) ensures Spring Security 
                    // recognizes this user as authorized for standard endpoints.
                    return new UsernamePasswordAuthenticationToken(
                            user, 
                            null, 
                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                    );
                }
            } catch (Exception ex) {
                LOGGER.error("JWT validation failed: {}", ex.getMessage());
            }
        }
        return null;
    }
}