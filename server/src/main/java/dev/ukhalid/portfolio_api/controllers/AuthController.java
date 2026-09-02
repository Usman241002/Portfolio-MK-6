package dev.ukhalid.portfolio_api.controllers;

import dev.ukhalid.portfolio_api.dto.LoginRequest;
import dev.ukhalid.portfolio_api.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;


//    @PostMapping("/verify")

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        //TODO: add bcrypt


        boolean isPasswordValid = adminPassword.equals(loginRequest.getPassword());

        if (!adminEmail.equals(loginRequest.getEmail()) || !isPasswordValid) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        return new LoginResponse(HttpStatus.OK, "Login successful", "valid_token");
    }
}
