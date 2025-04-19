package com.user.dto;

import java.time.LocalDate;

public class RegisterRequest {
    private String username;
    private String password;
    private String dateOfBirth; // Assuming it's a String. Use LocalDate if needed.

    // Constructor
    public RegisterRequest() {}

    public RegisterRequest(String username, String password, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public String getUsername() {  // This method must exist!
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {  // ✅ Keep it as a String
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {  // ✅ Keep it as a String
        this.dateOfBirth = dateOfBirth;
    }
}
