package com.demo.Accommodation_Complaints_Feedback_System.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Accommodation_Complaints_Feedback_System.dao.ServiceHalls;
import com.demo.Accommodation_Complaints_Feedback_System.model.Admin;
import com.demo.Accommodation_Complaints_Feedback_System.model.Carpenter;
import com.demo.Accommodation_Complaints_Feedback_System.model.CarpentersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Student;
import com.demo.Accommodation_Complaints_Feedback_System.model.User;
import com.demo.Accommodation_Complaints_Feedback_System.model.DoneComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.AcceptedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.RejectedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Security;
import com.demo.Accommodation_Complaints_Feedback_System.model.SecuritysComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.HallsOfficer;
import com.demo.Accommodation_Complaints_Feedback_System.model.Mason;
import com.demo.Accommodation_Complaints_Feedback_System.model.MasonsComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Plumber;
import com.demo.Accommodation_Complaints_Feedback_System.model.PlumbersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Custodian;
import com.demo.Accommodation_Complaints_Feedback_System.model.Electrician;
import com.demo.Accommodation_Complaints_Feedback_System.model.ElectriciansComplaint;

@Controller
public class HallsController {
	
	@Autowired
	ServiceHalls service;
	
	@RequestMapping("/")
	public String getUser() {
		return "login.jsp";
	}
	
	
	@PostMapping("/register_user")
	String addStudent(User user) {
		
		service.saveUser(user);
		return "login.jsp";
	}
	
	@RequestMapping(value="admin/users.jsp/approved/{userId}", method=RequestMethod.GET)
		public String approve(@PathVariable("userId") int userId, Map<String, Object> map) {
		
		User user = service.getUser(userId);
		user.setUser_status("approved");
		service.saveUser(user);
		
		return "redirect:/admin/users.jsp";
		
	}
	
	@RequestMapping(value="admin/users.jsp/unapproved/{userId}", method=RequestMethod.GET)
	public String unapprove(@PathVariable("userId") int userId, Map<String, Object> map) {
	
		User user = service.getUser(userId);
		user.setUser_status("unapproved");
		service.saveUser(user);
		
		return "redirect:/admin/users.jsp";
	
	}
	
	
	@RequestMapping(value="admin/users.jsp/delete/{userId}", method=RequestMethod.GET)
	public String delete(@PathVariable("userId") int userId, Map<String, Object> map) {
		service.deleteUser(userId);
		return "redirect:/admin/users.jsp";
	
	}
	
	
	@PostMapping("/studentRegister")
	String addStudent(Student student) {
		
		service.saveStudent(student);
		return "studentRegistration.jsp";
	}
	
	@PostMapping("/login")
	public String validate(@RequestParam String category, @RequestParam String uname, @RequestParam String password, Model model){	
		   
		 switch (category) {  
		 case "Admin":  
			 Admin admin = service.getAdmin(uname, password);
				
				if(admin!=null) {
					model.addAttribute("admin", admin);
					return "admin/adminUI.jsp";
				}
				else {
					return "login.jsp";
				}
		  case "Student":  
			Student student=service.getStudent(uname, password);
			
			if(student!=null) {
				model.addAttribute("student", student);
				return "studentUI.jsp";
			}
			else {
				return "login.jsp";
			}
		   case "Halls Officer":  
				 HallsOfficer hallsOfficer = service.getHallsOfficer(uname, password);
					
					if(hallsOfficer!=null) {
						model.addAttribute("hallsOfficer", hallsOfficer);
						return "hallsOfficerUI.jsp";
					}
					else {
						return "login.jsp";
					}
		   case "Custodian":  
				 Custodian custodian = service.getCustodian(uname, password);
					
					if(custodian!=null) {
						model.addAttribute("custodian", custodian);
						return "custodianUI.jsp";
					}
					else {
						return "login.jsp";
					}
					
		   case "Carpenter":  
				Carpenter carpenter=service.getCarpenter(uname, password);
				
				if(carpenter!=null) {
					model.addAttribute("carpenter", carpenter);
					return "carpenterUI.jsp";
				}
				else {
					return "login.jsp";
				}
		   case "Security":  
				Security security = service.getSecurity(uname, password);
				
				if(security!=null) {
					model.addAttribute("security", security);
					return "securityUI.jsp";
				}
				else {
					return "login.jsp";
				}
		   case "Plumber":  
				Plumber plumber = service.getPlumber(uname, password);
				
				if(plumber!=null) {
					model.addAttribute("plumber", plumber);
					return "plumberUI.jsp";
				}
				else {
					return "login.jsp";
				}
		   case "Electrician":  
				Electrician electrician = service.getElectrician(uname, password);
				
				if(electrician!=null) {
					model.addAttribute("electrician", electrician);
					return "electricianUI.jsp";
				}
				else {
					return "login.jsp";
				}
		   case "Mason":  
				Mason mason=service.getMason(uname, password);
				
				if(mason!=null) {
					model.addAttribute("mason", mason);
					return "masonUI.jsp";
				}
				else {
					return "login.jsp";
				}
		   default:  
		     return "login.jsp";  
	}
	}
	
	@PostMapping("/submitComplaint")
	public String submitComplaint(@RequestParam String complaintTitle,
			@RequestParam String complaintDescription,@RequestParam String fname,
			@RequestParam String lname,
			@RequestParam String regNo, @RequestParam String phoneNumber, @RequestParam String hostel, @RequestParam String block, 
			@RequestParam String roomNumber
			,Model model)
	{
		
		Complaint complaint =new Complaint();
		complaint.setComplaintTitle(complaintTitle);
		complaint.setComplaintDescription(complaintDescription);
		complaint.setFname(fname);
		complaint.setLname(lname);
		complaint.setRegNo(regNo);
		complaint.setPhoneNumber(phoneNumber);
		complaint.setHostel(hostel);
		complaint.setBlock(block);
		complaint.setRoomNumber(roomNumber);
		
		String message=service.saveComplaint(complaint);
		model.addAttribute("message", message);
		model.addAttribute("complaint", complaint);
		return "studentUI.jsp";
	}
	
	@PostMapping("/hallsOfficerRegister")
	String addHallsOfficer(HallsOfficer hallsOfficer) {
		
		service.saveHallsOfficer(hallsOfficer);
		return "hallsOfficerRegistration.jsp";
	}
	
	@PostMapping("/custodianRegister")
	String addCustodian(Custodian custodian) {
		
		service.saveCustodian(custodian);
		return "custodianRegistration.jsp";
	}
	
	@PostMapping("/carpenterRegister")
	String addCarpenter(Carpenter carpenter) {
		
		service.saveCarpenter(carpenter);
		return "carpenterRegistration.jsp";
	}
	
	@PostMapping("/masonRegister")
	String addMason(Mason mason) {
		
		service.saveMason(mason);
		return "masonRegistration.jsp";
	}
	
	@PostMapping("/securityRegister")
	String addSecurity(Security security) {
		
		service.saveSecurity(security);
		return "securityRegistration.jsp";
	}
	
	@PostMapping("/plumberRegister")
	String addPlumber(Plumber plumber) {
		
		service.savePlumber(plumber);
		return "plumberRegistration.jsp";
	}
	
	@PostMapping("/electricianRegister")
	String addElectrician(Electrician electrician) {
		
		service.saveElectrician(electrician);
		return "electricianRegistration.jsp";
	}
	
	@PostMapping("/acceptComplaint")
	public String accept(@RequestParam String cid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		AcceptedComplaint acceptedComplaint = new AcceptedComplaint();
		acceptedComplaint.setFname(fname);
		acceptedComplaint.setLname(lname);
		acceptedComplaint.setRegNo(regNo);
		acceptedComplaint.setHostel(hostel);
		acceptedComplaint.setBlock(block);
		acceptedComplaint.setRoomNumber(roomNumber);
		acceptedComplaint.setComplaintTitle(complaintTitle);
		acceptedComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveAcceptedComplaint(acceptedComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("acceptedComplaint", acceptedComplaint);
		
		service.deleteComplaint(Integer.valueOf(cid));
		return "hallsOfficerUI.jsp";
	}
	
	@PostMapping("/rejectComplaint")
	public String reject(@RequestParam String cid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		RejectedComplaint rejectedComplaint = new RejectedComplaint();
		rejectedComplaint.setFname(fname);
		rejectedComplaint.setLname(lname);
		rejectedComplaint.setRegNo(regNo);
		rejectedComplaint.setHostel(hostel);
		rejectedComplaint.setBlock(block);
		rejectedComplaint.setRoomNumber(roomNumber);
		rejectedComplaint.setComplaintTitle(complaintTitle);
		rejectedComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveRejectedComplaint(rejectedComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("rejectedComplaint", rejectedComplaint);
		
		
		service.deleteComplaint(Integer.valueOf(cid));
		return "hallsOfficerUI.jsp";
	}
	
	@PostMapping("/forwardToPlumber")
	public String forwardToPlumber(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		PlumbersComplaint plumbersComplaint = new PlumbersComplaint();
		plumbersComplaint.setFname(fname);
		plumbersComplaint.setLname(lname);
		plumbersComplaint.setRegNo(regNo);
		plumbersComplaint.setHostel(hostel);
		plumbersComplaint.setBlock(block);
		plumbersComplaint.setRoomNumber(roomNumber);
		plumbersComplaint.setComplaintTitle(complaintTitle);
		plumbersComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.savePlumbersComplaint(plumbersComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("plumbersComplaint", plumbersComplaint);
		
		service.deleteCustodianComplaint(Integer.valueOf(acid));
		return "custodianUI.jsp";
	}
	
	@PostMapping("/forwardToCarpenter")
	public String forwardToCarpenter(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		CarpentersComplaint carpentersComplaint = new CarpentersComplaint();
		carpentersComplaint.setFname(fname);
		carpentersComplaint.setLname(lname);
		carpentersComplaint.setRegNo(regNo);
		carpentersComplaint.setHostel(hostel);
		carpentersComplaint.setBlock(block);
		carpentersComplaint.setRoomNumber(roomNumber);
		carpentersComplaint.setComplaintTitle(complaintTitle);
		carpentersComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveCarpentersComplaint(carpentersComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("carpentersComplaint", carpentersComplaint);
		
		service.deleteCustodianComplaint(Integer.valueOf(acid));
		return "custodianUI.jsp";
	}
	
	@PostMapping("/forwardToSecurity")
	public String forwardToSecurity(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		SecuritysComplaint securitysComplaint = new SecuritysComplaint();
		securitysComplaint.setFname(fname);
		securitysComplaint.setLname(lname);
		securitysComplaint.setRegNo(regNo);
		securitysComplaint.setHostel(hostel);
		securitysComplaint.setBlock(block);
		securitysComplaint.setRoomNumber(roomNumber);
		securitysComplaint.setComplaintTitle(complaintTitle);
		securitysComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveSecuritysComplaint(securitysComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("securitysComplaint", securitysComplaint);
		
		service.deleteCustodianComplaint(Integer.valueOf(acid));
		return "custodianUI.jsp";
	}
	
	@PostMapping("/forwardToElectrician")
	public String forwardToElectrician(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		ElectriciansComplaint electriciansComplaint = new ElectriciansComplaint();
		electriciansComplaint.setFname(fname);
		electriciansComplaint.setLname(lname);
		electriciansComplaint.setRegNo(regNo);
		electriciansComplaint.setHostel(hostel);
		electriciansComplaint.setBlock(block);
		electriciansComplaint.setRoomNumber(roomNumber);
		electriciansComplaint.setComplaintTitle(complaintTitle);
		electriciansComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveElectriciansComplaint(electriciansComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("electriciansComplaint", electriciansComplaint);
		
		service.deleteCustodianComplaint(Integer.valueOf(acid));
		return "custodianUI.jsp";
	}
	
	@PostMapping("/forwardToMason")
	public String forwardToMason(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		MasonsComplaint masonsComplaint = new MasonsComplaint();
		masonsComplaint.setFname(fname);
		masonsComplaint.setLname(lname);
		masonsComplaint.setRegNo(regNo);
		masonsComplaint.setHostel(hostel);
		masonsComplaint.setBlock(block);
		masonsComplaint.setRoomNumber(roomNumber);
		masonsComplaint.setComplaintTitle(complaintTitle);
		masonsComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveMasonsComplaint(masonsComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("masonsComplaint", masonsComplaint);
		
		service.deleteCustodianComplaint(Integer.valueOf(acid));
		return "custodianUI.jsp";
	}
	
	@PostMapping("/plumbersDoneComplaint")
	public String plumbersDoneComplaint(@RequestParam String pcid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deletePlumbersDoneComplaint(Integer.valueOf(pcid));
		return "plumberUI.jsp";
	}
	
	@PostMapping("/carpentersDoneComplaint")
	public String carpentersDoneComplaint(@RequestParam String ccid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deleteCarpentersDoneComplaint(Integer.valueOf(ccid));
		return "carpenterUI.jsp";
	}
	
	@PostMapping("/electriciansDoneComplaint")
	public String electriciansDoneComplaint(@RequestParam String ecid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deleteElectriciansDoneComplaint(Integer.valueOf(ecid));
		return "carpenterUI.jsp";
	}
	
	@PostMapping("/securitysDoneComplaint")
	public String securitysDoneComplaint(@RequestParam String scid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deleteSecuritysDoneComplaint(Integer.valueOf(scid));
		return "securityUI.jsp";
	}
	
	@PostMapping("/masonsDoneComplaint")
	public String masonsDoneComplaint(@RequestParam String mcid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deleteMasonsDoneComplaint(Integer.valueOf(mcid));
		return "masonUI.jsp";
	}
}
