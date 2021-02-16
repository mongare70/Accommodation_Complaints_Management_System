package com.demo.Accommodation_Complaints_Feedback_System.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Accommodation_Complaints_Feedback_System.dao.ServiceHalls;
import com.demo.Accommodation_Complaints_Feedback_System.model.CarpentersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.User;
import com.demo.Accommodation_Complaints_Feedback_System.model.DoneComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.AcceptedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.RejectedComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.SecuritysComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.MasonsComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.PlumbersComplaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.ElectriciansComplaint;

@Controller
public class HallsController {
	
	@Autowired
	ServiceHalls service;
	
	@RequestMapping("/")
	public String getUser() {
		return "login.jsp";
	}
	
	//register new user
	@PostMapping("/register_user")
	String addStudent(User user) {
		
		service.saveUser(user);
		return "login.jsp";
	}
	
	
	//register new admin
	@PostMapping("/register_admin")
	String addAdmin(User user) {
		
		service.saveUser(user);
		return "/admin/adminUI.jsp";
	}
	
	//approve user
	@RequestMapping(value="admin/users.jsp/approved/{userId}", method=RequestMethod.GET)
		public String approve(@PathVariable("userId") int userId, Map<String, Object> map) {
		
		User user = service.getUser(userId);
		user.setUser_status("approved");
		service.saveUser(user);
		
		return "redirect:/admin/users.jsp";
		
	}
	
	//unapprove user
	@RequestMapping(value="admin/users.jsp/unapproved/{userId}", method=RequestMethod.GET)
	public String unapprove(@PathVariable("userId") int userId, Map<String, Object> map) {
	
		User user = service.getUser(userId);
		user.setUser_status("unapproved");
		service.saveUser(user);
		
		return "redirect:/admin/users.jsp";
	
	}
	
	//delete user
	@RequestMapping(value="admin/users.jsp/delete/{userId}", method=RequestMethod.GET)
	public String delete(@PathVariable("userId") int userId, Map<String, Object> map) {
		service.deleteUser(userId);
		return "redirect:/admin/users.jsp";
	
	}
	
	//login into platform
	@PostMapping("/login")
	public String validate(@RequestParam String user_role, @RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpSession session){	
		   
		 switch (user_role) {  
			 case "admin":  
				User admin = service.getUser(username, password);
				if(admin!=null && admin.getUser_status().equals("approved") && admin.getUser_role().equals("admin")) {
					
					//Save Sessions
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_lastname = (ArrayList<Object>) request.getSession().getAttribute("USER_LASTNAME");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_number = (ArrayList<Object>) request.getSession().getAttribute("USER_NUMBER");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_email = (ArrayList<Object>) request.getSession().getAttribute("USER_EMAIL");
					
					if (user_id == null || user_firstname == null || user_lastname == null || user_number == null || user_email == null) {
						user_id = new ArrayList<>();
						user_firstname = new ArrayList<>();
						user_lastname = new ArrayList<>();
						user_number = new ArrayList<>();
						user_email = new ArrayList<>();
						request.getSession().setAttribute("USER_ID", user_id);
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
						request.getSession().setAttribute("USER_LASTNAME", user_lastname);
						request.getSession().setAttribute("USER_NUMBER", user_number);
						request.getSession().setAttribute("USER_EMAIL", user_email);
						
					}
					
					user_id.add(admin.getUser_id());
					user_firstname.add(admin.getUser_firstname());
					user_lastname.add(admin.getUser_lastname());
					user_number.add(admin.getUser_number());
					user_email.add(admin.getUser_email());
					
					request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_LASTNAME", user_lastname.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_NUMBER", user_number.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_EMAIL", user_email.toString().replace("[", "").replace("]", ""));
					
					return "admin/adminUI.jsp";
				} else {
					return "login.jsp";
				}
			 case "student":  
				User student = service.getUser(username, password);
				if(student!=null && student.getUser_status().equals("approved") && student.getUser_role().equals("student")) {
					
					//Save Sessions
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_lastname = (ArrayList<Object>) request.getSession().getAttribute("USER_LASTNAME");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_number = (ArrayList<Object>) request.getSession().getAttribute("USER_NUMBER");
					@SuppressWarnings("unchecked")
					ArrayList<Object> user_email = (ArrayList<Object>) request.getSession().getAttribute("USER_EMAIL");
					
					if (user_id == null || user_firstname == null || user_lastname == null || user_number == null || user_email == null) {
						user_id = new ArrayList<>();
						user_firstname = new ArrayList<>();
						user_lastname = new ArrayList<>();
						user_number = new ArrayList<>();
						user_email = new ArrayList<>();
						request.getSession().setAttribute("USER_ID", user_id);
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
						request.getSession().setAttribute("USER_LASTNAME", user_lastname);
						request.getSession().setAttribute("USER_NUMBER", user_number);
						request.getSession().setAttribute("USER_EMAIL", user_email);
						
					}
					
					user_id.add(student.getUser_id());
					user_firstname.add(student.getUser_firstname());
					user_lastname.add(student.getUser_lastname());
					user_number.add(student.getUser_number());
					user_email.add(student.getUser_email());
					
					request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_LASTNAME", user_lastname.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_NUMBER", user_number.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_EMAIL", user_email.toString().replace("[", "").replace("]", ""));
					
					return "studentUI.jsp";
				} else {
					return "login.jsp";
				}
			   	default:  
			    return "login.jsp";  
		 }
	}
	
	
	//kill session
	@RequestMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
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
