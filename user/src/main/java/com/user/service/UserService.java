package com.user.service;

import com.user.dto.RegisterRequest;
import com.user.dto.LoginRequest;
import com.user.entity.User;
import com.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // ✅ Convert String to LocalDate before saving
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust format if needed
            LocalDate dob = LocalDate.parse(request.getDateOfBirth(), formatter);
            user.setDateOfBirth(dob);
        } catch (DateTimeParseException e) {
            return "Invalid date format. Please use YYYY-MM-DD";
        }

        userRepository.save(user);
        return "User registered successfully";
    }

    public String loginUser(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

        if (userOptional.isPresent() && passwordEncoder.matches(request.getPassword(), userOptional.get().getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
