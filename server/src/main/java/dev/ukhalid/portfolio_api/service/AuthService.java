package dev.ukhalid.portfolio_api.service;


import dev.ukhalid.portfolio_api.dto.AuthResponse;
import dev.ukhalid.portfolio_api.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    public AuthService(PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        boolean isEmailValid =
                loginRequest.getEmail().equals(adminEmail);

        boolean isPasswordValid =
                passwordEncoder.matches(
                        loginRequest.getPassword(),
                        adminPassword
                );

        if (!isEmailValid || !isPasswordValid) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid email or password"
            );
        }
        String token = jwtService.generateToken();

        return new AuthResponse("Login Successful", token);

    }
}
