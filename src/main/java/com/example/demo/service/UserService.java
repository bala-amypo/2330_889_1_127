package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
   // User registerCustomer(String name, String email, String rawPassword);
    User registerCustomer(String name, String email);
    User findByEmail(String email);
}