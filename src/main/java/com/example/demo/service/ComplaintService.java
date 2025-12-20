// public interface ComplaintService{
//     // public void submitComplaint(ComplaintRequest request);
//     public Complaint getUserComplaints(Long userId);
//     public List getPrioritizedComplaints();
//     public void updateComplaintStatus(Lon id, String status);
// }
package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint);

    List<Complaint> getUserComplaints(Long userId);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateComplaintStatus(Long id, String status);
}
