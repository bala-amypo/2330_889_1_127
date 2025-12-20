package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    // Get User by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);

        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
