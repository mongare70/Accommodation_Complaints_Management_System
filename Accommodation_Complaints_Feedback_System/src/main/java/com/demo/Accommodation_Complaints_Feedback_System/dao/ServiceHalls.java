package com.demo.Accommodation_Complaints_Feedback_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Accommodation_Complaints_Feedback_System.repository.AcceptedComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.CarpentersComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.Accommodation_Complaints_Feedback_System.model.DoneComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.RejectedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.SecuritysComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.DoneComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.ElectriciansComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.ElectriciansComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.MasonsComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.PlumbersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.MasonsComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.PlumbersComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.RejectedComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.SecuritysComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.ComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.AcceptedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.CarpentersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.User;


@Service
public class ServiceHalls {
	
	@Autowired
	UserRepository user_repository;
	
	@Autowired
	ComplaintRepository crepo;
	
	@Autowired
	RejectedComplaintRepository rcrepo;
	
	@Autowired
	AcceptedComplaintRepository acrepo;
	
	@Autowired
	PlumbersComplaintRepository pcrepo;
	
	@Autowired
	CarpentersComplaintRepository ccrepo;
	
	@Autowired
	SecuritysComplaintRepository screpo;
	
	@Autowired
	ElectriciansComplaintRepository ecrepo;
	
	@Autowired
	MasonsComplaintRepository mcrepo;
	
	@Autowired
	DoneComplaintRepository dcrepo;
	 
	@Autowired
	ObjectMapper objectMapper;
	
	public void saveUser(User user) {
	 	user_repository.save(user);
	}
	
	public User getUser(String username, String password) {
		return user_repository.findByUsernameAndPassword(username, password);
	}
	
	public User getUser(int user_id) {
		return user_repository.findById(user_id);
	}
	
	
	public void deleteUser(int user_id) {
		user_repository.deleteById(user_id);
	}
	
	public String saveComplaint(Complaint complaint) {
		String message="";
		
		crepo.save(complaint);
		
		if(crepo.save(complaint)!=null) {
		message="Complaint Submitted Successfully";	
		}
		else {
			message="Please Try Again!";
		}
		return message;
	}
	
	public String saveAcceptedComplaint(AcceptedComplaint acceptedComplaint) {
		String message="";
		acrepo.save(acceptedComplaint);
		if(acrepo.save(acceptedComplaint)!=null) {
		message="Accepted Successfully";
		}
		else {
		message="Failed to accept complaint";
		}
		return message;
	}
	
	public String saveRejectedComplaint(RejectedComplaint rejectedComplaint) {
		String message="";
		rcrepo.save(rejectedComplaint);
		if(rcrepo.save(rejectedComplaint)!=null) {
		message="Rejected Successfully";
		}
		else {
		message="Failed to reject complaint";
		}
		return message;
	}
	
	public String savePlumbersComplaint(PlumbersComplaint plumbersComplaint) {
		String message="";
		pcrepo.save(plumbersComplaint);
		if(pcrepo.save(plumbersComplaint)!=null) {
		message="Submitted to Plumber";
		}
		else {
		message="Failed to pass the complaint";
		}
		return message;
	}
	
	public String saveCarpentersComplaint(CarpentersComplaint carpentersComplaint) {
		String message="";
		ccrepo.save(carpentersComplaint);
		if(ccrepo.save(carpentersComplaint)!=null) {
		message="Submitted to Carpenter";
		}
		else {
		message="Failed to pass the complaint";
		}
		return message;
	}
	
	public String saveSecuritysComplaint(SecuritysComplaint securitysComplaint) {
		String message="";
		screpo.save(securitysComplaint);
		if(screpo.save(securitysComplaint)!=null) {
		message="Submitted to Security";
		}
		else {
		message="Failed to pass the complaint";
		}
		return message;
	}
	
	public String saveElectriciansComplaint(ElectriciansComplaint electriciansComplaint) {
		String message="";
		ecrepo.save(electriciansComplaint);
		if(ecrepo.save(electriciansComplaint)!=null) {
		message="Submitted to Electrician";
		}
		else {
		message="Failed to pass the complaint";
		}
		return message;
	}
	
	public String saveMasonsComplaint(MasonsComplaint masonsComplaint) {
		String message="";
		mcrepo.save(masonsComplaint);
		if(mcrepo.save(masonsComplaint)!=null) {
		message="Submitted to Mason";
		}
		else {
		message="Failed to pass the complaint";
		}
		return message;
	}
	
	public String saveDoneComplaint(DoneComplaint doneComplaint) {
		String message="";
		dcrepo.save(doneComplaint);
		if(dcrepo.save(doneComplaint)!=null) {
		message="Complaint Done";
		}
		else {
		message="Failed to complete complaint";
		}
		return message;
	}
	
	public void deleteComplaint(int cid) {
		crepo.deleteById(cid);
	}
	
	public void deleteCustodianComplaint(int acid) {
		acrepo.deleteById(acid);
		
	}
	
	public void deletePlumbersDoneComplaint(int pcid) {
		pcrepo.deleteById(pcid);
		
	}
	
	public void deleteCarpentersDoneComplaint(int ccid) {
		ccrepo.deleteById(ccid);
		
	}
	
	public void deleteElectriciansDoneComplaint(int ecid) {
		ecrepo.deleteById(ecid);
		
	}
	
	public void deleteSecuritysDoneComplaint(int scid) {
		screpo.deleteById(scid);
		
	}
	
	public void deleteMasonsDoneComplaint(int mcid) {
		mcrepo.deleteById(mcid);
		
	}
}
