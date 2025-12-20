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
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @NotBlank
    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private Integer priorityScore = 0;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String severity;

    @Column(nullable = false)
    private String urgency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /* Relation */
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    // ✅ Non-parameterized constructor (required by JPA)
    public Complaint() {}

    // ✅ Parameterized constructor
    public Complaint(String title,
                     String description,
                     String category,
                     String channel,
                     String severity,
                     String urgency,
                     User customer) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.channel = channel;
        this.severity = severity;
        this.urgency = urgency;
        this.customer = customer;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "NEW";
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getUrgency() { return urgency; }
    public void setUrgency(String urgency) { this.urgency = urgency; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }
}
