package com.demo.Accommodation_Complaints_Feedback_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Accommodation_Complaints_Feedback_System.repository.AcceptedComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.AdminRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.CarpenterRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.CarpentersComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.StudentRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.DoneComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.RejectedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Security;
import com.demo.Accommodation_Complaints_Feedback_System.model.SecuritysComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.CustodianRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.DoneComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.ElectricianRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.ElectriciansComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.Custodian;
import com.demo.Accommodation_Complaints_Feedback_System.model.Electrician;
import com.demo.Accommodation_Complaints_Feedback_System.model.ElectriciansComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.HallsOfficer;
import com.demo.Accommodation_Complaints_Feedback_System.model.Mason;
import com.demo.Accommodation_Complaints_Feedback_System.model.MasonsComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Plumber;
import com.demo.Accommodation_Complaints_Feedback_System.model.PlumbersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.HallsOfficerRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.MasonRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.MasonsComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.PlumberRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.PlumbersComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.RejectedComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.SecurityRepository;
import com.demo.Accommodation_Complaints_Feedback_System.repository.SecuritysComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;
import com.demo.Accommodation_Complaints_Feedback_System.repository.ComplaintRepository;
import com.demo.Accommodation_Complaints_Feedback_System.model.AcceptedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Admin;
import com.demo.Accommodation_Complaints_Feedback_System.model.Carpenter;
import com.demo.Accommodation_Complaints_Feedback_System.model.CarpentersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Student;


@Service
public class ServiceHalls {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	AdminRepository arepo;
	
	@Autowired
	ComplaintRepository crepo;
	
	@Autowired
	HallsOfficerRepository hrepo;
	
	@Autowired
	CustodianRepository curepo;
	
	@Autowired
	CarpenterRepository carepo;
	
	@Autowired
	MasonRepository mrepo;
	
	@Autowired
	PlumberRepository prepo;
	
	@Autowired
	SecurityRepository serepo;
	
	@Autowired
	ElectricianRepository erepo;
	
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
	
	
	
	public void saveStudent(Student student) {
	 	srepo.save(student);
	}
	
	public Student getStudent(String uname, String password) {
		return srepo.findByUnameAndPassword(uname, password);
	}
	
	public Admin getAdmin(String uname, String password) {
		return arepo.findByUnameAndPassword(uname, password);
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
	
	public void saveHallsOfficer(HallsOfficer hallsOfficer) {
	 	hrepo.save(hallsOfficer);
	}
	
	public HallsOfficer getHallsOfficer(String uname, String password) {
		return hrepo.findByUnameAndPassword(uname, password);
	}
	
	public Custodian getCustodian(String uname, String password) {
		return curepo.findByUnameAndPassword(uname, password);
	}
	
	public void saveCustodian(Custodian custodian) {
		curepo.save(custodian);
	}
	
	public void saveCarpenter(Carpenter carpenter) {
		carepo.save(carpenter);
	}
	
	public void saveMason(Mason mason) {
		mrepo.save(mason);
	}
	
	public void savePlumber(Plumber plumber) {
		prepo.save(plumber);
	}
	
	public void saveSecurity(Security security) {
		serepo.save(security);
	}
	
	public void saveElectrician(Electrician electrician) {
		erepo.save(electrician);
	}
	
	public Carpenter getCarpenter(String uname, String password) {
		return carepo.findByUnameAndPassword(uname, password);
	}
	
	public Electrician getElectrician(String uname, String password) {
		return erepo.findByUnameAndPassword(uname, password);
	}
	
	public Security getSecurity(String uname, String password) {
		return serepo.findByUnameAndPassword(uname, password);
	}
	
	public Plumber getPlumber(String uname, String password) {
		return prepo.findByUnameAndPassword(uname, password);
	}
	
	public Mason getMason(String uname, String password) {
		return mrepo.findByUnameAndPassword(uname, password);
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
