package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint);

    List<Complaint> getUserComplaints(Long userId);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateComplaintStatus(Long id, String status);
}
