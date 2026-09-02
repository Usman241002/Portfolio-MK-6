package dev.ukhalid.portfolio_api.dto;

public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
