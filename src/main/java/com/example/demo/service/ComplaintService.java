package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    List<Complaint> getComplaintsForUser(User user);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateComplaintStatus(Long complaintId, String status);
}
