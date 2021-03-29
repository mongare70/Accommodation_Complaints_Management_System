package com.demo.Accommodation_Complaints_Feedback_System.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Complaints")
@EntityListeners(AuditingEntityListener.class)
public class Complaint {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int complaint_id;
	
	@NotBlank 
	private String complaint_category;
	
	@NotBlank
	private String complaint_content;
	
	@NotBlank
	private String complaint_status = "pending";
	
	@NotBlank
	private String complaint_hostel;
	
	@NotBlank
	private String complaint_block;
	
	private int complaint_room_number;
	
	private int complaint_approved_or_rejected_by = 0;
	
	private int complaint_author_id;
	
	private int complaint_assigned_to = 0;
	
	private int complaint_assigned_by = 0;
	
	private int complaint_done_by = 0;
	
	@CreatedDate
	private Date createdAt;

	
	public String getComplaint_block() {
		return complaint_block;
	}

	public void setComplaint_block(String complaint_block) {
		this.complaint_block = complaint_block;
	}

	public int getComplaint_room_number() {
		return complaint_room_number;
	}

	public void setComplaint_room_number(int complaint_room_number) {
		this.complaint_room_number = complaint_room_number;
	}

	public String getComplaint_hostel() {
		return complaint_hostel;
	}

	public void setComplaint_hostel(String complaint_hostel) {
		this.complaint_hostel = complaint_hostel;
	}

	public int getComplaint_assigned_by() {
		return complaint_assigned_by;
	}

	public void setComplaint_assigned_by(int complaint_assigned_by) {
		this.complaint_assigned_by = complaint_assigned_by;
	}

	public int getComplaint_assigned_to() {
		return complaint_assigned_to;
	}

	public void setComplaint_assigned_to(int complaint_assigned_to) {
		this.complaint_assigned_to = complaint_assigned_to;
	}

	public int getComplaint_approved_or_rejected_by() {
		return complaint_approved_or_rejected_by;
	}

	public void setComplaint_approved_or_rejected_by(int complaint_approved_or_rejected_by) {
		this.complaint_approved_or_rejected_by = complaint_approved_or_rejected_by;
	}

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
		return "Complaint [complaint_id=" + complaint_id + ", complaint_category=" + complaint_category
				+ ", complaint_content=" + complaint_content + ", complaint_status=" + complaint_status
				+ ", complaint_hostel=" + complaint_hostel + ", complaint_block=" + complaint_block
				+ ", complaint_room_number=" + complaint_room_number + ", complaint_approved_or_rejected_by="
				+ complaint_approved_or_rejected_by + ", complaint_author_id=" + complaint_author_id
				+ ", complaint_assigned_to=" + complaint_assigned_to + ", complaint_assigned_by="
				+ complaint_assigned_by + ", complaint_done_by=" + complaint_done_by + ", createdAt=" + createdAt + "]";
	}
	
}
