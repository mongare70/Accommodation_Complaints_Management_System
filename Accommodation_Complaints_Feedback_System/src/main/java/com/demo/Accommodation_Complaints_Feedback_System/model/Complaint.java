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
@Table(name="Complaints")
@EntityListeners(AuditingEntityListener.class)
public class Complaint {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int complaint_id;
	
	@NotBlank
	private String complaint_title;
	
	@NotBlank
	private String complaint_content;
	
	@NotBlank
	private String complaint_status = "pending";
	
	@NotBlank 
	private String complaint_category = "undefined";
	
	private int complaint_author_id;
	
	private int complaint_done_by = 0;

	public int getComplaint_done_by() {
		return complaint_done_by;
	}

	public void setComplaint_done_by(int complaint_done_by) {
		this.complaint_done_by = complaint_done_by;
	}

	public String getComplaint_category() {
		return complaint_category;
	}

	public void setComplaint_category(String complaint_category) {
		this.complaint_category = complaint_category;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getComplaint_title() {
		return complaint_title;
	}

	public void setComplaint_title(String complaint_title) {
		this.complaint_title = complaint_title;
	}

	public String getComplaint_content() {
		return complaint_content;
	}

	public void setComplaint_content(String complaint_content) {
		this.complaint_content = complaint_content;
	}

	public String getComplaint_status() {
		return complaint_status;
	}

	public void setComplaint_status(String complaint_status) {
		this.complaint_status = complaint_status;
	}

	public int getComplaint_author_id() {
		return complaint_author_id;
	}

	public void setComplaint_author_id(int complaint_author_id) {
		this.complaint_author_id = complaint_author_id;
	}

	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", complaint_title=" + complaint_title
				+ ", complaint_content=" + complaint_content + ", complaint_status=" + complaint_status
				+ ", complaint_category=" + complaint_category + ", complaint_author_id=" + complaint_author_id
				+ ", complaint_done_by=" + complaint_done_by + "]";
	}
	
}
