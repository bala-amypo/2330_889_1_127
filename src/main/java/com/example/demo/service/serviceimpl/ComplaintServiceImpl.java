package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;
    private final PriorityRuleService priorityRuleService;
    private final ComplaintStatusRepository complaintStatusRepository;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            UserRepository userRepository,
            PriorityRuleService priorityRuleService,
            ComplaintStatusRepository complaintStatusRepository) {

        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
        this.priorityRuleService = priorityRuleService;
        this.complaintStatusRepository = complaintStatusRepository;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint) {
        int score = priorityRuleService.calculatePriority(complaint.getCategory());
        complaint.setPriorityScore(score);
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getUserComplaints(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return complaintRepository.findByUser(user);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllPrioritized();
    }

    @Override
    public Complaint updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        ComplaintStatus complaintStatus =
                new ComplaintStatus(complaint, status);

        complaintStatusRepository.save(complaintStatus);

        return complaint;
    }
}
