package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Mason;

public interface MasonRepository extends JpaRepository<Mason, Integer> {
	public Mason findByUnameAndPassword(String uname, String password);
}
