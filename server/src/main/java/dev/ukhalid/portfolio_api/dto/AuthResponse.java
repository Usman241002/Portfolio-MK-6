package dev.ukhalid.portfolio_api.dto;

public class AuthResponse {
    private final String message;
    private final String token;

    public AuthResponse(final String message, final String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
