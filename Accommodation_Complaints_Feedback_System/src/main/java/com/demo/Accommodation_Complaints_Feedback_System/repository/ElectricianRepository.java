package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Electrician;

public interface ElectricianRepository extends JpaRepository<Electrician, Integer> {
	public Electrician findByUnameAndPassword(String uname, String password);
}
