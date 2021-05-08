package com.demo.Accommodation_Complaints_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccommodationComplaintsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationComplaintsManagementSystemApplication.class, args);
	}

}
