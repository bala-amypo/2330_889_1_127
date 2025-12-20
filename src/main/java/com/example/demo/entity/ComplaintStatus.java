// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// public class ComplaintStatus {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String status;
//     private LocalDateTime updatedOn;
//     public ComplaintStatus(Long id, String status, LocalDateTime updatedOn) {
//         this.id = id;
//         this.status = status;
//         this.updatedOn = updatedOn;
//     }
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public String getStatus() {
//         return status;
//     }
//     public void setStatus(String status) {
//         this.status = status;
//     }
//     public LocalDateTime getUpdatedOn() {
//         return updatedOn;
//     }
//     public void setUpdatedOn(LocalDateTime updatedOn) {
//         this.updatedOn = updatedOn;
//     }
    
// }
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
    private String ruleName;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @Min(0)
    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Boolean active = true;

    //  Non-parameterized constructor
    public PriorityRule() {}

    //  Parameterized constructor
    public PriorityRule(String ruleName, String description, Integer weight) {
        this.ruleName = ruleName;
        this.description = description;
        this.weight = weight;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
