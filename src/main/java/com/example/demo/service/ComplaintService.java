package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Complaint;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint);

    List<Complaint> getUserComplaints(Long userId);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateComplaintStatus(Long id, String status);
}
