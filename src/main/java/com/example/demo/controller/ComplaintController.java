package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public Complaint submit(@RequestBody ComplaintRequest request, @RequestAttribute User user) {
        return complaintService.submitComplaint(request, user);
    }

    @GetMapping
    public List<Complaint> myComplaints(@RequestAttribute User user) {
        return complaintService.getComplaintsForUser(user);
    }
}
