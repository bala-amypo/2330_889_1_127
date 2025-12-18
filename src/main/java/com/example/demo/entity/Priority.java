package com.example.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private int priorityScore;
    private LocalDateTime submittedOn;
    private String user;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPriorityScore() {
        return priorityScore;
    }
    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }
    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }
    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Complaint(Long id, String title, String description, String category, int priorityScore,
            LocalDateTime submittedOn, String user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priorityScore = priorityScore;
        this.submittedOn = submittedOn;
        this.user = user;
    }
    

}
