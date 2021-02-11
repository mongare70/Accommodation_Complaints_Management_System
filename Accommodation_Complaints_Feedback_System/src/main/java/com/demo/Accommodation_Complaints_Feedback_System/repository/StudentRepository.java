package com.demo.Accommodation_Complaints_Feedback_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Feedback_System.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findByUnameAndPassword(String uname, String password);
}
