package com.demo.Accommodation_Complaints_Feedback_System.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Reports")
@EntityListeners(AuditingEntityListener.class)
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int report_id;
	
	private int student_id;
	
	private int report_author_id;
	
	@NotBlank
	private String report_title;
	
	@NotBlank
	private String report_content;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getReport_author_id() {
		return report_author_id;
	}

	public void setReport_author_id(int report_author_id) {
		this.report_author_id = report_author_id;
	}

	public String getReport_title() {
		return report_title;
	}

	public void setReport_title(String report_title) {
		this.report_title = report_title;
	}

	public String getReport_content() {
		return report_content;
	}

	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}

	@Override
	public String toString() {
		return "Report [report_id=" + report_id + ", student_id=" + student_id + ", report_author_id="
				+ report_author_id + ", report_title=" + report_title + ", report_content=" + report_content + "]";
	}
	
}
