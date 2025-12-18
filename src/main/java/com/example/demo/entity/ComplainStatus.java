package com.example.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ComplaintStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime updatedOn;
    public ComplaintStatus(Long id, String status, LocalDateTime updatedOn) {
        this.id = id;
        this.status = status;
        this.updatedOn = updatedOn;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
    
}
