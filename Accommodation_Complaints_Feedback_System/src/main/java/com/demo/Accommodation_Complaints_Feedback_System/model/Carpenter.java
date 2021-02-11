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
@Table(name="Carpenters")
@EntityListeners(AuditingEntityListener.class)
public class Carpenter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@NotBlank
	private String staffNo;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	private String uname;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String password;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Carpenter [cid=" + cid + ", staffNo=" + staffNo + ", fname=" + fname + ", lname=" + lname
				+ ", phoneNumber=" + phoneNumber + ", uname=" + uname + ", password=" + password + "]";
	}
}
