package com.example.demo.dto;

public class ComplaintResponse {
    private Long id;
    private String status;
    private Integer score;
    private boolean success;
    private String message;
    
    public ComplaintResponse() {}
    
    public ComplaintResponse(Long id, String status, Integer score, boolean success, String message) {
        this.id = id;
        this.status = status;
        this.score = score;
        this.success = success;
        this.message = message;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}