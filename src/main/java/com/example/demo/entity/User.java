package com.example.demo.entity;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(unique = true)
    private String email;
    private String password;
    
    // Constructors, getters, and setters
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Default constructor
    public User() {
    }

    // Getters and Setters
    //Id
    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
   
    //Name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    //Email
    public String getEmail() {
        return email;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }
   
    //Password
    public String getPassword() {
        return password;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }

}
