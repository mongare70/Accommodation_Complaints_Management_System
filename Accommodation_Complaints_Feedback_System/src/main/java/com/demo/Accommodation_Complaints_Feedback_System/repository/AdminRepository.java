package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByUnameAndPassword(String uname, String password);
}
