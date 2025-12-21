// package com.example.demo.service;

// import com.example.demo.entity.Complaint;

// import java.util.List;

// public interface ComplaintService {

//     Complaint submitComplaint(Complaint complaint);

//     List<Complaint> getUserComplaints(Long userId);

//     List<Complaint> getPrioritizedComplaints();

//     Complaint updateComplaintStatus(Long id, String status);
// }
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
