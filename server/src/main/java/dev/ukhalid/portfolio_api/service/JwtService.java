package dev.ukhalid.portfolio_api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import javax.crypto.SecretKey;

@Service
public class JwtService {
    private static final Long EXPIRATION_TIME = new Date().getTime() + 1000 * 60 * 60;
    @Value("${jwt.secret}")
    private String jwtSecret;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                jwtSecret.getBytes()
        );
    }

    public String generateToken() {
        return Jwts.builder()
                .signWith(getSigningKey())
                .expiration(
                        new Date(
                                 EXPIRATION_TIME
                        )
                )
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {

            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
