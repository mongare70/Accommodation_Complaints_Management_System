package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Security;

public interface SecurityRepository extends JpaRepository<Security, Integer> {
	public Security findByUnameAndPassword(String uname, String password);
}
