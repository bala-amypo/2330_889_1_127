package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PriorityRule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Integer baseScore;
    private String description;
    public PriorityRule(Long id, String category, Integer baseScore, String description) {
        this.id = id;
        this.category = category;
        this.baseScore = baseScore;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getBaseScore() {
        return baseScore;
    }
    public void setBaseScore(Integer baseScore) {
        this.baseScore = baseScore;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
