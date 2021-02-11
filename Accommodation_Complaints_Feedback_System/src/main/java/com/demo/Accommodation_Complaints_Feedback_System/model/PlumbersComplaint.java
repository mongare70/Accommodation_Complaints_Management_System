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
@Table(name="PlumbersComplaints")
@EntityListeners(AuditingEntityListener.class)
public class PlumbersComplaint {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pcid;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	private String regNo;
	
	@NotBlank
	private String hostel;
	
	@NotBlank
	private String block;
	
	@NotBlank
	private String roomNumber;
	
	@NotBlank
	private String complaintTitle;
	
	@NotBlank
	private String complaintDescription;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	@Override
	public String toString() {
		return "PlumbersComplaint [pcid=" + pcid + ", fname=" + fname + ", lname=" + lname + ", regNo=" + regNo
				+ ", hostel=" + hostel + ", block=" + block + ", roomNumber=" + roomNumber + ", complaintTitle="
				+ complaintTitle + ", complaintDescription=" + complaintDescription + "]";
	}
	
}
