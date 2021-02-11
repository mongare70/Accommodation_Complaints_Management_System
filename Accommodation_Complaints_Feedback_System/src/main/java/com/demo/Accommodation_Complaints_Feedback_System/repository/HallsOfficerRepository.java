package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.HallsOfficer;

public interface HallsOfficerRepository extends JpaRepository<HallsOfficer, Integer> {
	public HallsOfficer findByUnameAndPassword(String uname, String password);
}
