package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Custodian;

public interface CustodianRepository extends JpaRepository<Custodian, Integer>{
	public Custodian findByUnameAndPassword(String uname, String password);
}
