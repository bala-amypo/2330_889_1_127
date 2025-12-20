// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;


// public class Complaint {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String description;
//     private String category;
//     private int priorityScore;
//     private LocalDateTime submittedOn;
//     private String user;
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public String getTitle() {
//         return title;
//     }
//     public void setTitle(String title) {
//         this.title = title;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
//     public String getCategory() {
//         return category;
//     }
//     public void setCategory(String category) {
//         this.category = category;
//     }
//     public int getPriorityScore() {
//         return priorityScore;
//     }
//     public void setPriorityScore(int priorityScore) {
//         this.priorityScore = priorityScore;
//     }
//     public LocalDateTime getSubmittedOn() {
//         return submittedOn;
//     }
//     public void setSubmittedOn(LocalDateTime submittedOn) {
//         this.submittedOn = submittedOn;
//     }
//     public String getUser() {
//         return user;
//     }
//     public void setUser(String user) {
//         this.user = user;
//     }
//     public Complaint(Long id, String title, String description, String category, int priorityScore,
//             LocalDateTime submittedOn, String user) {
//         this.id = id;
//         this.title = title;
//         this.description = description;
//         this.category = category;
//         this.priorityScore = priorityScore;
//         this.submittedOn = submittedOn;
//         this.user = user;
//     }
    
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer priorityScore;

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedOn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //  Non-parameterized constructor
    public Complaint() {}

    //  Parameterized constructor
    public Complaint(String title, String description, String category, User user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    // Auto-generate submittedOn
    @PrePersist
    public void onSubmit() {
        this.submittedOn = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public LocalDateTime getSubmittedOn() { return submittedOn; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
