package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
	public Complaint findById(int complaint_id);
}
