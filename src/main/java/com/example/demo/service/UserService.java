package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User saveUser(User user);

    User findByEmail(String email);

    User registerCustomer(String fullName, String email, String password);

    User login(String email, String password);
}
