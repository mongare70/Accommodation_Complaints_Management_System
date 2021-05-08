package com.demo.Accommodation_Complaints_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Accommodation_Complaints_Management_System.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int user_id);
}
