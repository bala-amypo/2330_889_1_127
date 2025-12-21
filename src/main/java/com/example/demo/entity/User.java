// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;

// @Entity
// @Table(
//     name = "users",
//     uniqueConstraints = @UniqueConstraint(columnNames = "email")
// )
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank
//     @Column(nullable = false)
//     private String name;

//     @NotBlank
//     @Email
//     @Column(nullable = false, unique = true)
//     private String email;

//     @NotBlank
//     @Column(nullable = false)
//     private String password;

//     //  Non-parameterized constructor (JPA)
//     public User() {}

//     //  Parameterized constructor
//     public User(String name, String email, String password) {
//         this.name = name;
//         this.email = email;
//         this.password = password;
//     }

//     // Getters & Setters
//     public Long getId() { return id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        CUSTOMER, AGENT, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(Long id, String fullName, String email, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public void setId(Long id) {
    this.id = id;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

}
