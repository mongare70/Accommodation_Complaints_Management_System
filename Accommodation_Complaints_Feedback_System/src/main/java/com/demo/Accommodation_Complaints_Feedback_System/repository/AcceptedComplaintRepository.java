package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.AcceptedComplaint;

public interface AcceptedComplaintRepository extends JpaRepository<AcceptedComplaint, Integer> {
}
