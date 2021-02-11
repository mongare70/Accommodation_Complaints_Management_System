package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Plumber;

public interface PlumberRepository extends JpaRepository<Plumber, Integer> {
	public Plumber findByUnameAndPassword(String uname, String password);
}
