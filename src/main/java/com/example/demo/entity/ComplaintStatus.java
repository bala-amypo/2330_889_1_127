package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaint_status")
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "complaint_id", nullable = false)
    private Complaint complaint;

    @NotBlank
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    //  Non-parameterized constructor
    public ComplaintStatus() {}

    //  Parameterized constructor
    public ComplaintStatus(Complaint complaint, String status) {
        this.complaint = complaint;
        this.status = status;
    }

    @PrePersist
    public void onUpdate() {
        this.updatedOn = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Complaint getComplaint() { return complaint; }
    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getUpdatedOn() { return updatedOn; }
}
