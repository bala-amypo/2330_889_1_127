package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.service.ComplaintService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService com;
    @PostMapping("/submit")
    public ComplaintService submitComplaint(@RequestBody ComplaintService complaint){
        return com.saveComplaintData(complaint);
    }
}
