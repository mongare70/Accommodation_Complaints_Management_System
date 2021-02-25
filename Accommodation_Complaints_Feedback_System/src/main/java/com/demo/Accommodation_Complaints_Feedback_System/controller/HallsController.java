package com.demo.Accommodation_Complaints_Feedback_System.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Accommodation_Complaints_Feedback_System.dao.ServiceHalls;
import com.demo.Accommodation_Complaints_Feedback_System.model.User;
import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;

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
	public String validate(@RequestParam String user_role, @RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request, HttpSession session){	
		   
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
				
								
					if (user_id == null ||  user_firstname == null || user_lastname == null || user_number == null || user_email == null) {
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
				
			 case "halls_officer":  
					User halls_officer = service.getUser(username, password);
					if(halls_officer!=null && halls_officer.getUser_status().equals("approved") && halls_officer.getUser_role().equals("halls_officer")) {
						
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
						
						user_id.add(halls_officer.getUser_id());
						user_firstname.add(halls_officer.getUser_firstname());
						user_lastname.add(halls_officer.getUser_lastname());
						user_number.add(halls_officer.getUser_number());
						user_email.add(halls_officer.getUser_email());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_LASTNAME", user_lastname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_NUMBER", user_number.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_EMAIL", user_email.toString().replace("[", "").replace("]", ""));
						
						return "hallsOfficerUI.jsp";
					} else {
						return "login.jsp";
					}
				
			 case "custodian":  
					User custodian = service.getUser(username, password);
					if(custodian!=null && custodian.getUser_status().equals("approved") && custodian.getUser_role().equals("custodian")) {
						
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
						
						user_id.add(custodian.getUser_id());
						user_firstname.add(custodian.getUser_firstname());
						user_lastname.add(custodian.getUser_lastname());
						user_number.add(custodian.getUser_number());
						user_email.add(custodian.getUser_email());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_LASTNAME", user_lastname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_NUMBER", user_number.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_EMAIL", user_email.toString().replace("[", "").replace("]", ""));
						
						return "custodianUI.jsp";
					} else {
						return "login.jsp";
					}	
					
					
			 case "plumber":  
					User plumber = service.getUser(username, password);
					if(plumber!=null && plumber.getUser_status().equals("approved") && plumber.getUser_role().equals("plumber")) {
						
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
						
						user_id.add(plumber.getUser_id());
						user_firstname.add(plumber.getUser_firstname());
						user_lastname.add(plumber.getUser_lastname());
						user_number.add(plumber.getUser_number());
						user_email.add(plumber.getUser_email());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_LASTNAME", user_lastname.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_NUMBER", user_number.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_EMAIL", user_email.toString().replace("[", "").replace("]", ""));
						
						return "plumberUI.jsp";
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
	public String submitComplaint(@RequestParam String complaint_title, @RequestParam String complaint_content, @RequestParam int complaint_author_id, Model model){
		
		Complaint complaint =new Complaint();
		complaint.setComplaint_title(complaint_title);
		complaint.setComplaint_content(complaint_content);
		complaint.setComplaint_author_id(complaint_author_id);
		
		service.saveComplaint(complaint);
		return "redirect:/studentUI.jsp";
	}
				
	//approve complaint
	@RequestMapping(value="hallsOfficerUI.jsp/approve/{complaint_id}", method=RequestMethod.GET)
		public String approveComplaint(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("approved");
		service.saveComplaint(complaint);
		
		return "redirect:/hallsOfficerUI.jsp";
		
	}
	
	
	//reject complaint
	@RequestMapping(value="hallsOfficerUI.jsp/reject/{complaint_id}", method=RequestMethod.GET)
		public String rejectComplaint(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("rejected");
		service.saveComplaint(complaint);
		
		return "redirect:/hallsOfficerUI.jsp";
		
	}
	
	
	//Set complaint category to Mason
	@RequestMapping(value="custodianUI.jsp/mason/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToMason(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("mason");
		service.saveComplaint(complaint);
		
		return "redirect:/custodianUI.jsp";
		
	}
	
	
	//Set complaint category to Plumber
	@RequestMapping(value="custodianUI.jsp/plumber/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToPlumber(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("plumber");
		service.saveComplaint(complaint);
		
		return "redirect:/custodianUI.jsp";
		
	}
	
	
	//Set complaint category to Carpenter
	@RequestMapping(value="custodianUI.jsp/carpenter/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToCarpenter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("carpenter");
		service.saveComplaint(complaint);
		
		return "redirect:/custodianUI.jsp";
		
	}
	
	//Set complaint category to Security
	@RequestMapping(value="custodianUI.jsp/security/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToSecurity(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("security");
		service.saveComplaint(complaint);
		
		return "redirect:/custodianUI.jsp";
		
	}
	
	
	//Set complaint category to Electrician
	@RequestMapping(value="custodianUI.jsp/electrician/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToElectrician(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("electrician");
		service.saveComplaint(complaint);
		
		return "redirect:/custodianUI.jsp";
		
	}
	
	//Set complaint done by to plumber ID	
		@RequestMapping(value="plumberUI.jsp/plumber/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String setComplaintDoneByToPlumber(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberUI.jsp";
			
		}
		
	//undo complaint done by to 0	
		@RequestMapping(value="plumberUI.jsp/plumber/undo/{complaint_id}", method=RequestMethod.GET)
			public String setComplaintDoneByToZero(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberUI.jsp";
			
		}
	
}
