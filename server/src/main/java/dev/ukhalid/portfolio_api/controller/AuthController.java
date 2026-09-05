package dev.ukhalid.portfolio_api.controller;

import dev.ukhalid.portfolio_api.dto.AuthResponse;
import dev.ukhalid.portfolio_api.dto.LoginRequest;
import dev.ukhalid.portfolio_api.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    public HttpStatus verifyToken() {
        return this.authService.verifyToken();
    }
}
