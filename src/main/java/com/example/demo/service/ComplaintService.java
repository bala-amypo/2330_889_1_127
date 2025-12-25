package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;

public interface ComplaintService {

    // REQUIRED by tests
    Complaint submitComplaint(ComplaintRequest request, User customer);

    // REQUIRED by tests
    List<Complaint> getComplaintsForUser(User user);

    // REQUIRED by tests
    List<Complaint> getPrioritizedComplaints();
}
