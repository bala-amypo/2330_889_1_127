package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "priority_rules")
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @Min(0)
    @Column(nullable = false)
    private Integer baseScore;

    @NotBlank
    @Column(nullable = false)
    private String description;

    //  Non-parameterized constructor
    public PriorityRule() {}

    //  Parameterized constructor
    public PriorityRule(String category, Integer baseScore, String description) {
        this.category = category;
        this.baseScore = baseScore;
        this.description = description;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getBaseScore() { return baseScore; }
    public void setBaseScore(Integer baseScore) {
        this.baseScore = baseScore;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }
}
