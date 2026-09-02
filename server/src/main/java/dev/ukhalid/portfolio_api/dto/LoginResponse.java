package dev.ukhalid.portfolio_api.dto;

import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;

public class LoginResponse {
    private final String message;
    private final String token;
    private final HttpStatus httpStatus;

    public LoginResponse(HttpStatus httpStatus, String message, String token) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
