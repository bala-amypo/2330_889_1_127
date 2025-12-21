package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepository.findByCustomerId(userId);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        //  THIS FIXES YOUR ENUM ERROR
        complaint.setStatus(Complaint.Status.valueOf(status));

        return complaintRepository.save(complaint);
    }
}
