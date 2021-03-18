package com.demo.Accommodation_Complaints_Feedback_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccommodationComplaintsFeedbackSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationComplaintsFeedbackSystemApplication.class, args);
	}

}
