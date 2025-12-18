public interface ComplaintService{
    // public void submitComplaint(ComplaintRequest request);
    public Complaint getUserComplaints(Long userId);
    public List getPrioritizedComplaints();
    public void updateComplaintStatus(Lon id, String status);
}