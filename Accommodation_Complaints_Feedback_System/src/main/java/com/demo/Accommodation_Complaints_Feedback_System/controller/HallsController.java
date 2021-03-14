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
		return "redirect:/login.jsp";
	}
	
	
	//register new admin
	@PostMapping("/register_admin")
	String addAdmin(User user) {
		
		service.saveUser(user);
		return "redirect:/admin/adminUI.jsp";
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
					
								
					if (user_id == null ||  user_firstname == null) {
						user_id = new ArrayList<>();
						user_firstname = new ArrayList<>();
						
						request.getSession().setAttribute("USER_ID", user_id);
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
						
					}
					
					user_id.add(admin.getUser_id());
					user_firstname.add(admin.getUser_firstname());
					
					request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
					
					return "redirect:/admin/adminUI.jsp";
					
				} else {
					return "redirect:/login.jsp";
				}
				
			 case "student":  
					User student = service.getUser(username, password);
					if(student!=null && student.getUser_status().equals("approved") && student.getUser_role().equals("student")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(student.getUser_id());
						user_firstname.add(student.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/studentUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
				
			 case "halls_officer":  
					User halls_officer = service.getUser(username, password);
					if(halls_officer!=null && halls_officer.getUser_status().equals("approved") && halls_officer.getUser_role().equals("halls_officer")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(halls_officer.getUser_id());
						user_firstname.add(halls_officer.getUser_firstname());
					
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/hallsOfficerUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
				
			 case "custodian":  
					User custodian = service.getUser(username, password);
					if(custodian!=null && custodian.getUser_status().equals("approved") && custodian.getUser_role().equals("custodian")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(custodian.getUser_id());
						user_firstname.add(custodian.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/custodianUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}	
					
					
			 case "plumber":  
					User plumber = service.getUser(username, password);
					if(plumber!=null && plumber.getUser_status().equals("approved") && plumber.getUser_role().equals("plumber")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(plumber.getUser_id());
						user_firstname.add(plumber.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/plumberUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}	
					
			 case "mason":  
					User mason = service.getUser(username, password);
					if(mason!=null && mason.getUser_status().equals("approved") && mason.getUser_role().equals("mason")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(mason.getUser_id());
						user_firstname.add(mason.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/masonUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "carpenter":  
					User carpenter = service.getUser(username, password);
					if(carpenter!=null && carpenter.getUser_status().equals("approved") && carpenter.getUser_role().equals("carpenter")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(carpenter.getUser_id());
						user_firstname.add(carpenter.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/carpenterUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "security":  
					User security = service.getUser(username, password);
					if(security!=null && security.getUser_status().equals("approved") && security.getUser_role().equals("security")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(security.getUser_id());
						user_firstname.add(security.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/securityUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "electrician":  
					User electrician = service.getUser(username, password);
					if(electrician!=null && electrician.getUser_status().equals("approved") && electrician.getUser_role().equals("electrician")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(electrician.getUser_id());
						user_firstname.add(electrician.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/electricianUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "cleaner":  
					User cleaner = service.getUser(username, password);
					if(cleaner!=null && cleaner.getUser_status().equals("approved") && cleaner.getUser_role().equals("cleaner")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(cleaner.getUser_id());
						user_firstname.add(cleaner.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/cleanerUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "health":  
					User health = service.getUser(username, password);
					if(health!=null && health.getUser_status().equals("approved") && health.getUser_role().equals("health")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(health.getUser_id());
						user_firstname.add(health.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/healthUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			 case "painter":  
					User painter = service.getUser(username, password);
					if(painter!=null && painter.getUser_status().equals("approved") && painter.getUser_role().equals("painter")) {
						
						//Save Sessions
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
						@SuppressWarnings("unchecked")
						ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession().getAttribute("USER_FIRSTNAME");
						
						if (user_id == null || user_firstname == null) {
							user_id = new ArrayList<>();
							user_firstname = new ArrayList<>();
							
							request.getSession().setAttribute("USER_ID", user_id);
							request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);
							
						}
						
						user_id.add(painter.getUser_id());
						user_firstname.add(painter.getUser_firstname());
						
						request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
						request.getSession().setAttribute("USER_FIRSTNAME", user_firstname.toString().replace("[", "").replace("]", ""));
						
						return "redirect:/painterUI.jsp";
						
					} else {
						return "redirect:/login.jsp";
					}
					
			   	default:  
			    return "redirect:/login.jsp";  
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
	@RequestMapping(value="hallsOfficerUI.jsp/approve/{complaint_id}/{user_id}", method=RequestMethod.GET)
		public String approveComplaint(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID,  Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("approved");
		complaint.setComplaint_approved_or_rejected_by(userID);
		service.saveComplaint(complaint);
		
		return "redirect:/hallsOfficerUI.jsp";
		
	}
	
	
	//reject complaint
	@RequestMapping(value="hallsOfficerUI.jsp/reject/{complaint_id}/{user_id}", method=RequestMethod.GET)
		public String rejectComplaint(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("rejected");
		complaint.setComplaint_approved_or_rejected_by(userID);
		service.saveComplaint(complaint);
		
		return "redirect:/hallsOfficerUI.jsp";
		
	}
	
	
	//Set complaint category to Mason
	@RequestMapping(value="custodianUI.jsp/mason/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToMason(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("mason");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	
	//Set complaint category to Plumber
	@RequestMapping(value="custodianUI.jsp/plumber/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToPlumber(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("plumber");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	
	//Set complaint category to Carpenter
	@RequestMapping(value="custodianUI.jsp/carpenter/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToCarpenter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("carpenter");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Set complaint category to Security
	@RequestMapping(value="custodianUI.jsp/security/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToSecurity(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("security");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	
	//Set complaint category to Electrician
	@RequestMapping(value="custodianUI.jsp/electrician/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToElectrician(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("electrician");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Set complaint category to Health
	@RequestMapping(value="custodianUI.jsp/health/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToHealth(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("health");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Set complaint category to Painter
	@RequestMapping(value="custodianUI.jsp/painter/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToPainter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("painter");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Set complaint category to Cleaner
	@RequestMapping(value="custodianUI.jsp/cleaner/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToCleaner(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("cleaner");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Set complaint category to Custodian
	@RequestMapping(value="custodianUI.jsp/custodian/{complaint_id}", method=RequestMethod.GET)
		public String setCategoryToCustodian(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_category("custodian");
		service.saveComplaint(complaint);
		
		return "redirect:/categorizedComplaints.jsp";
		
	}
	
	//Claim complaint by Plumber	
		@RequestMapping(value="plumberUI.jsp/plumber/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintPlumber(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberClaimedComplaints.jsp";
			
		}
		
		
	//Claim complaint by Mason	
		@RequestMapping(value="masonUI.jsp/mason/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintMason(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/masonClaimedComplaints.jsp";
			
		}
		
		
	//Claim complaint by Carpenter	
		@RequestMapping(value="carpenterUI.jsp/carpenter/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintCarpenter(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/carpenterClaimedComplaints.jsp";
			
		}
		
	//Claim complaint by Security	
		@RequestMapping(value="securityUI.jsp/security/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintSecurity(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/securityClaimedComplaints.jsp";
			
		}
		
		
	//Claim complaint by Electrician	
		@RequestMapping(value="electricianUI.jsp/electrician/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintElectrician(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/electricianClaimedComplaints.jsp";
			
		}
		
	//Claim complaint by Cleaner	
		@RequestMapping(value="cleanerUI.jsp/cleaner/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintCleaner(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/cleanerClaimedComplaints.jsp";
			
		}
		
	//Claim complaint by Health	
		@RequestMapping(value="healthUI.jsp/health/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintHealth(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/healthClaimedComplaints.jsp";
			
		}
		
		
	//Claim complaint by Painter
		@RequestMapping(value="painterUI.jsp/painter/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintPainter(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/painterClaimedComplaints.jsp";
			
		}
		
	//Claim complaint by Custodian
		@RequestMapping(value="custodianWorkspace.jsp/custodian/claim/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String claimComplaintCustodian(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_claimed_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/custodianClaimedComplaints.jsp";
			
		}
		
	//Unclaim complaint by Plumber	
		@RequestMapping(value="plumberClaimedComplaints.jsp/plumber/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintPlumber(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberUI.jsp";
			
		}
		
		
	//Unclaim complaint by Mason	
		@RequestMapping(value="masonClaimedComplaints.jsp/mason/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintMason(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/masonUI.jsp";
			
		}
		
		
	//Unclaim complaint by Carpenter	
		@RequestMapping(value="carpenterClaimedComplaints.jsp/carpenter/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintCarpenter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/carpenterUI.jsp";
			
		}
		
		
	//Unclaim complaint by Security	
		@RequestMapping(value="securityClaimedComplaints.jsp/security/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintSecurity(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/securityUI.jsp";
			
		}
	
		
	//Unclaim complaint by Electrician	
		@RequestMapping(value="electricianClaimedComplaints.jsp/electrician/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintElectrician(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/electricianUI.jsp";
			
		}
		
	//Unclaim complaint by Cleaner	
		@RequestMapping(value="cleanerClaimedComplaints.jsp/cleaner/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintCleaner(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/cleanerUI.jsp";
			
		}
	
		
	//Unclaim complaint by Health	
		@RequestMapping(value="healthClaimedComplaints.jsp/health/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintHealth(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/healthUI.jsp";
			
		}
		
	//Unclaim complaint by Painter	
		@RequestMapping(value="painterClaimedComplaints.jsp/painter/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintPainter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/painterUI.jsp";
			
		}
		
	//Unclaim complaint by Custodian	
		@RequestMapping(value="custodianClaimedComplaints.jsp/custodian/unclaim/{complaint_id}", method=RequestMethod.GET)
			public String unclaimComplaintCustodian(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("approved");
			complaint.setComplaint_claimed_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/custodianWorkspace.jsp";
			
		}
				
	//Done complaint by Plumber	
		@RequestMapping(value="plumberClaimedComplaints.jsp/plumber/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintPlumber(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberDoneComplaints.jsp";
			
		}
		
	//Done complaint by Mason
		@RequestMapping(value="masonClaimedComplaints.jsp/mason/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintMason(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/masonDoneComplaints.jsp";
			
		}
		
		
	//Done complaint by Carpenter
		@RequestMapping(value="carpenterClaimedComplaints.jsp/carpenter/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintCarpenter(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/carpenterDoneComplaints.jsp";
			
		}
		
		
	//Done complaint by Security
		@RequestMapping(value="securityClaimedComplaints.jsp/security/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintSecurity(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/securityDoneComplaints.jsp";
			
		}
		
	//Done complaint by Electrician
		@RequestMapping(value="electricianClaimedComplaints.jsp/electrician/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintElectrician(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/electricianDoneComplaints.jsp";
			
		}
		
	//Done complaint by Cleaner
		@RequestMapping(value="cleanerClaimedComplaints.jsp/cleaner/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
			public String doneComplaintCleaner(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("done");
			complaint.setComplaint_done_by(userID);
			service.saveComplaint(complaint);
			
			return "redirect:/cleanerDoneComplaints.jsp";
			
		}
		
	//Done complaint by Health
	@RequestMapping(value="healthClaimedComplaints.jsp/health/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
		public String doneComplaintHealth(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);
		
		return "redirect:/healthDoneComplaints.jsp";
		
	}
	
	
	//Done complaint by Painter
	@RequestMapping(value="painterClaimedComplaints.jsp/painter/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
		public String doneComplaintPainter(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);
		
		return "redirect:/painterDoneComplaints.jsp";
		
	}
	
	//Done complaint by Custodian
	@RequestMapping(value="custodianClaimedComplaints.jsp/custodian/done/{complaint_id}/{user_id}", method=RequestMethod.GET)
		public String doneComplaintCustodian(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID, Map<String, Object> map) {
		
		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);
		
		return "redirect:/custodianDoneComplaints.jsp";
		
	}
		
	//Undo complaint by Plumber	
		@RequestMapping(value="plumberDoneComplaints.jsp/plumber/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintPlumber(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/plumberClaimedComplaints.jsp";
			
		}
		
		
	//Undo complaint by Mason	
		@RequestMapping(value="masonDoneComplaints.jsp/mason/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintMason(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/masonClaimedComplaints.jsp";
			
		}
		
		
	//Undo complaint by Carpenter	
		@RequestMapping(value="carpenterDoneComplaints.jsp/carpenter/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintCarpenter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/carpenterClaimedComplaints.jsp";
			
		}
		
	//Undo complaint by Security	
		@RequestMapping(value="securityDoneComplaints.jsp/security/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintSecurity(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/securityClaimedComplaints.jsp";
			
		}
		
		
	//Undo complaint by Electrician	
		@RequestMapping(value="electricianDoneComplaints.jsp/electrician/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintElectrician(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/electricianClaimedComplaints.jsp";
			
		}
		
		
	//Undo complaint by Cleaner	
		@RequestMapping(value="cleanerDoneComplaints.jsp/cleaner/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintCleaner(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/cleanerClaimedComplaints.jsp";
			
		}
		
	//Undo complaint by Health
		@RequestMapping(value="healthDoneComplaints.jsp/health/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintHealth(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/healthClaimedComplaints.jsp";
			
		}
		
	//Undo complaint by Painter
		@RequestMapping(value="painterDoneComplaints.jsp/painter/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintPainter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/painterClaimedComplaints.jsp";
			
		}
		
	//Undo complaint by Custodian
		@RequestMapping(value="custodianDoneComplaints.jsp/custodian/undo/{complaint_id}", method=RequestMethod.GET)
			public String undoComplaintCustodian(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {
			
			Complaint complaint = service.getComplaint(complaintId);
			complaint.setComplaint_status("claimed");
			complaint.setComplaint_done_by(0);
			service.saveComplaint(complaint);
			
			return "redirect:/custodianClaimedComplaints.jsp";
			
		}
		
	//delete complaint by admin
	@RequestMapping(value="admin/complaints.jsp/delete/{complaintId}", method=RequestMethod.GET)
	public String deleteComplaintAdmin(@PathVariable("complaintId") int complaintId, Map<String, Object> map) {
		service.deleteComplaint(complaintId);
		return "redirect:/admin/complaints.jsp";
	
	}
	
	//delete complaint by user
	@RequestMapping(value="statusUI.jsp/delete/{complaintId}", method=RequestMethod.GET)
	public String deleteComplaintUser(@PathVariable("complaintId") int complaintId, Map<String, Object> map) {
		service.deleteComplaint(complaintId);
		return "redirect:/statusUI.jsp";
	
	}
	
}
