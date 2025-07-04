package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepo.existsByEmail(user.getEmail()) || userRepo.existsByName(user.getName())) {
            return "User already exists. Please login.";
        }
        userRepo.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User foundUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            return "Login successful!";
        } else {
            return "Invalid credentials.";
        }
    }
}