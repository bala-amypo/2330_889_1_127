// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.service.ComplaintService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

// @RestController
// @RequestMapping("/complaints")
// public class ComplaintController {
//     @Autowired
//     ComplaintService com;
//     @PostMapping("/submit")
//     public ComplaintService submitComplaint(@RequestBody ComplaintService complaint){
//         return com.saveComplaintData(complaint);
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // POST /complaints/submit
    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody Complaint complaint) {
        return complaintService.submitComplaint(complaint);
    }

    // GET /complaints/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        return complaintService.getComplaintsByUser(userId);
    }

    // GET /complaints/prioritized
    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    // PUT /complaints/status/{id}
    @PutMapping("/status/{id}")
    public Complaint updateComplaintStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return complaintService.updateComplaintStatus(id, status);
    }
}
