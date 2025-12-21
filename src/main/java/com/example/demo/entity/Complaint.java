package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Complaint {

    public enum Status { NEW, IN_PROGRESS, RESOLVED }
    public enum Severity { LOW, MEDIUM, HIGH }
    public enum Urgency { LOW, MEDIUM, HIGH }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    private int priorityScore;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User customer;

    @ManyToMany
    private List<PriorityRule> priorityRules;

    public Complaint() {}

    // getters & setters (ONLY what tests require)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }

    public Status getStatus() { return status; }

    public void setChannel(String channel) { this.channel = channel; }
    public List<PriorityRule> getPriorityRules() { return priorityRules; }

    public String getCategory() {
    return category;
}

public void setPriorityScore(int priorityScore) {
    this.priorityScore = priorityScore;
}

public void setStatus(Status status) {
    this.status = status;
}

}
