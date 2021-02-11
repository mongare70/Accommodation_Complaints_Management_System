package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Carpenter;

public interface CarpenterRepository extends JpaRepository<Carpenter, Integer> {
	public Carpenter findByUnameAndPassword(String uname, String password);
}
