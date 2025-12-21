// package com.example.demo.service;

// import com.example.demo.entity.User;

// public interface UserService {

//     User saveUser(User user);

//     User findByEmail(String email);
// }
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User saveUser(User user);
    User findByEmail(String email);

    // test-required stub
    User registerCustomer(String name, String email, String password);
}
