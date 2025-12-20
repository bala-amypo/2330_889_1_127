// public interface UserService{
//     public void saveUser(User user);
//     public User findByEmail(String email);
// }
package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {

    void saveUser(User user);

    Optional<User> findByEmail(String email);
}
