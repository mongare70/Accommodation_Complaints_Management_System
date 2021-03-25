package com.demo.Accommodation_Complaints_Feedback_System.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Accommodation_Complaints_Feedback_System.dao.ServiceHalls;
import com.demo.Accommodation_Complaints_Feedback_System.model.User;
import com.demo.Accommodation_Complaints_Feedback_System.reports.ReportService;

import net.sf.jasperreports.engine.JRException;

import com.demo.Accommodation_Complaints_Feedback_System.model.Complaint;
import com.demo.Accommodation_Complaints_Feedback_System.model.Report;

@Controller
public class HallsController {

	@Autowired
	ServiceHalls service;

	@Autowired
	private ReportService reportService;

	@RequestMapping("/")
	public String getUser() {
		return "login.jsp";
	}

	@GetMapping("/admin/report")
	public String generateReport() throws JRException, IOException {
		return reportService.exportReport();
	}

	// register new user
	@PostMapping("/register_user")
	public String addUser(@RequestParam String user_number, @RequestParam String user_firstname,
			@RequestParam String user_lastname, @RequestParam String username, @RequestParam String user_email,
			@RequestParam String user_role, @RequestParam String user_hostel, @RequestParam String user_block,
			@RequestParam String user_room_number, @RequestParam String password) {
		User user = new User();
		if (user_hostel == "" && user_block == "" && user_room_number == "") {
			user.setUser_number(user_number);
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_role(user_role);
			user.setUser_hostel("");
			user.setUser_block("");
			user.setUser_room_number(0);
			user.setPassword(password);

			service.saveUser(user);

		} else if (user_room_number == "") {
			user.setUser_number(user_number);
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_role(user_role);
			user.setUser_hostel(user_hostel);
			user.setUser_block(user_block);
			user.setUser_room_number(0);
			user.setPassword(password);

			service.saveUser(user);
		} else {
			user.setUser_number(user_number);
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_role(user_role);
			user.setUser_hostel(user_hostel);
			user.setUser_block(user_block);
			user.setUser_room_number(Integer.parseInt(user_room_number));
			user.setPassword(password);

			service.saveUser(user);
		}

		return "redirect:/admin/register_user.jsp";
	}

	// Update User Details
	@PostMapping("/update_user")
	public String updateUser(@RequestParam String user_firstname, @RequestParam String user_lastname,
			@RequestParam String username, @RequestParam String user_email, @RequestParam String user_hostel,
			@RequestParam String user_block, @RequestParam String user_room_number, @RequestParam String password,
			@RequestParam int user_id) {
		User user = service.getUser(user_id);
		if (user_hostel == "" && user_block == "" && user_room_number == "") {
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_hostel("");
			user.setUser_block("");
			user.setUser_room_number(0);
			user.setPassword(password);

			service.saveUser(user);

		} else if (user_room_number == "") {
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_hostel(user_hostel);
			user.setUser_block(user_block);
			user.setUser_room_number(0);
			user.setPassword(password);

			service.saveUser(user);
		} else {
			user.setUser_firstname(user_firstname);
			user.setUser_lastname(user_lastname);
			user.setUsername(username);
			user.setUser_email(user_email);
			user.setUser_hostel(user_hostel);
			user.setUser_block(user_block);
			user.setUser_room_number(Integer.parseInt(user_room_number));
			user.setPassword(password);

			service.saveUser(user);
		}

		return "redirect:/profile.jsp";
	}

	// delete user
	@RequestMapping(value = "admin/users.jsp/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") int userId, Map<String, Object> map) {
		service.deleteUser(userId);
		return "redirect:/admin/users.jsp";

	}

	// login into platform
	@PostMapping("/login")
	public String validate(@RequestParam String user_role, @RequestParam String username, @RequestParam String password,
			Model model, HttpServletRequest request, HttpSession session) {

		switch (user_role) {
		case "admin":
			User admin = service.getUser(username, password);
			if (admin != null && admin.getUser_role().equals("admin")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(admin.getUser_id());
				user_firstname.add(admin.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/admin/adminUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "student":
			User student = service.getUser(username, password);
			if (student != null && student.getUser_role().equals("student")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(student.getUser_id());
				user_firstname.add(student.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/studentUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "halls_officer":
			User halls_officer = service.getUser(username, password);
			if (halls_officer != null && halls_officer.getUser_role().equals("halls_officer")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(halls_officer.getUser_id());
				user_firstname.add(halls_officer.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/hallsOfficerUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "custodian":
			User custodian = service.getUser(username, password);
			if (custodian != null && custodian.getUser_role().equals("custodian")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(custodian.getUser_id());
				user_firstname.add(custodian.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/custodianUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "plumber":
			User plumber = service.getUser(username, password);
			if (plumber != null && plumber.getUser_role().equals("plumber")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(plumber.getUser_id());
				user_firstname.add(plumber.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/plumberUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "mason":
			User mason = service.getUser(username, password);
			if (mason != null && mason.getUser_role().equals("mason")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(mason.getUser_id());
				user_firstname.add(mason.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/masonUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "carpenter":
			User carpenter = service.getUser(username, password);
			if (carpenter != null && carpenter.getUser_role().equals("carpenter")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(carpenter.getUser_id());
				user_firstname.add(carpenter.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/carpenterUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "security":
			User security = service.getUser(username, password);
			if (security != null && security.getUser_role().equals("security")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(security.getUser_id());
				user_firstname.add(security.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/securityUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "electrician":
			User electrician = service.getUser(username, password);
			if (electrician != null && electrician.getUser_role().equals("electrician")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(electrician.getUser_id());
				user_firstname.add(electrician.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/electricianUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "cleaner":
			User cleaner = service.getUser(username, password);
			if (cleaner != null && cleaner.getUser_role().equals("cleaner")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(cleaner.getUser_id());
				user_firstname.add(cleaner.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/cleanerUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "health":
			User health = service.getUser(username, password);
			if (health != null && health.getUser_role().equals("health")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(health.getUser_id());
				user_firstname.add(health.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/healthUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		case "painter":
			User painter = service.getUser(username, password);
			if (painter != null && painter.getUser_role().equals("painter")) {

				// Save Sessions
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_id = (ArrayList<Object>) request.getSession().getAttribute("USER_ID");
				@SuppressWarnings("unchecked")
				ArrayList<Object> user_firstname = (ArrayList<Object>) request.getSession()
						.getAttribute("USER_FIRSTNAME");

				if (user_id == null || user_firstname == null) {
					user_id = new ArrayList<>();
					user_firstname = new ArrayList<>();

					request.getSession().setAttribute("USER_ID", user_id);
					request.getSession().setAttribute("USER_FIRSTNAME", user_firstname);

				}

				user_id.add(painter.getUser_id());
				user_firstname.add(painter.getUser_firstname());

				request.getSession().setAttribute("USER_ID", user_id.toString().replace("[", "").replace("]", ""));
				request.getSession().setAttribute("USER_FIRSTNAME",
						user_firstname.toString().replace("[", "").replace("]", ""));

				return "redirect:/painterUI.jsp";

			} else {
				return "redirect:/login.jsp";
			}

		default:
			return "redirect:/login.jsp";
		}
	}

	// kill session
	@RequestMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	@PostMapping("/submitComplaint")
	public String submitComplaint(@RequestParam String complaint_category, @RequestParam String complaint_content,
			@RequestParam int complaint_author_id) {

		Complaint complaint = new Complaint();
		complaint.setComplaint_category(complaint_category);
		complaint.setComplaint_content(complaint_content);
		complaint.setComplaint_author_id(complaint_author_id);

		service.saveComplaint(complaint);
		return "redirect:/studentUI.jsp";
	}

	@PostMapping("/submitReport")
	public String submitReport(@RequestParam String report_title, @RequestParam String report_content,
			@RequestParam int report_author_id, @RequestParam int student_id) {
		Report report = new Report();
		report.setStudent_id(student_id);
		report.setReport_title(report_title);
		report.setReport_content(report_content);
		report.setReport_author_id(report_author_id);

		service.saveReport(report);
		return "redirect:/reports.jsp";
	}

	// approve complaint
	@RequestMapping(value = "hallsOfficerUI.jsp/approve/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String approveComplaint(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID,
			Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("approved");
		complaint.setComplaint_approved_or_rejected_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/hallsOfficerUI.jsp";

	}

	// reject complaint
	@RequestMapping(value = "hallsOfficerUI.jsp/reject/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String rejectComplaint(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID,
			Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("rejected");
		complaint.setComplaint_approved_or_rejected_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/hallsOfficerUI.jsp";

	}

	// Assign Complaint To Plumber Link
	@RequestMapping(value = "custodianUI.jsp/plumber/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintToPlumberLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToPlumber.jsp";

	}

	// Assign Complaint To Mason Link
	@RequestMapping(value = "custodianUI.jsp/mason/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintToMasonLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToMason.jsp";

	}

	// Assign Complaint To Carpenter Link
	@RequestMapping(value = "custodianUI.jsp/carpenter/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintCarpenterLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToCarpenter.jsp";

	}

	// Assign Complaint To Security Link
	@RequestMapping(value = "custodianUI.jsp/security/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintSecurityLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToSecurity.jsp";

	}

	// Assign Complaint To Electrician Link
	@RequestMapping(value = "custodianUI.jsp/electrician/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintElectricianLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToElectrician.jsp";

	}

	// Assign Complaint To Cleaner Link
	@RequestMapping(value = "custodianUI.jsp/cleaner/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintCleanerLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToCleaner.jsp";

	}

	// Assign Complaint To Health Link
	@RequestMapping(value = "custodianUI.jsp/health/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintHealthLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToHealth.jsp";

	}

	// Assign Complaint To Painter Link
	@RequestMapping(value = "custodianUI.jsp/painter/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintPainterLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToPainter.jsp";

	}

	// Assign Complaint To Custodian Link
	@RequestMapping(value = "custodianUI.jsp/custodian/{complaint_id}", method = RequestMethod.GET)
	public String assignComplaintCustodianLink(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		model.addAttribute("complaintId", complaintId);
		return "/assignToCustodian.jsp";

	}

	// Assign complaint To Worker Request
	@PostMapping("/assignToWorker")
	public String assignComplaintToWorker(@RequestParam int complaint_id, @RequestParam int complaint_assigned_to,
			@RequestParam int complaint_assigned_by) {

		Complaint complaint = service.getComplaint(complaint_id);
		complaint.setComplaint_assigned_to(complaint_assigned_to);
		complaint.setComplaint_assigned_by(complaint_assigned_by);
		complaint.setComplaint_status("assigned");
		service.saveComplaint(complaint);

		return "redirect:/assignedComplaints.jsp";
	}

	// Unassign Complaint
	@RequestMapping(value = "assignedComplaints.jsp/unassign/{complaint_id}", method = RequestMethod.GET)
	public String unassignComplaint(@PathVariable("complaint_id") int complaintId, Map<String, Object> map,
			Model model) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_assigned_to(0);
		complaint.setComplaint_assigned_by(0);
		complaint.setComplaint_status("approved");
		service.saveComplaint(complaint);

		return "redirect:/assignedComplaints.jsp";

	}

	// Done complaint by Plumber
	@RequestMapping(value = "plumberUI.jsp/plumber/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintPlumber(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/plumberDoneComplaints.jsp";

	}

	// Done complaint by Mason
	@RequestMapping(value = "masonUI.jsp/mason/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintMason(@PathVariable("complaint_id") int complaintId, @PathVariable("user_id") int userID,
			Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/masonDoneComplaints.jsp";

	}

	// Done complaint by Carpenter
	@RequestMapping(value = "carpenterUI.jsp/carpenter/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintCarpenter(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/carpenterDoneComplaints.jsp";

	}

	// Done complaint by Security
	@RequestMapping(value = "securityUI.jsp/security/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintSecurity(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/securityDoneComplaints.jsp";

	}

	// Done complaint by Electrician
	@RequestMapping(value = "electricianUI.jsp/electrician/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintElectrician(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/electricianDoneComplaints.jsp";

	}

	// Done complaint by Cleaner
	@RequestMapping(value = "cleanerUI.jsp/cleaner/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintCleaner(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/cleanerDoneComplaints.jsp";

	}

	// Done complaint by Health
	@RequestMapping(value = "healthUI.jsp/health/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintHealth(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/healthDoneComplaints.jsp";

	}

	// Done complaint by Painter
	@RequestMapping(value = "painterUI.jsp/painter/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintPainter(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/painterDoneComplaints.jsp";

	}

	// Done complaint by Custodian
	@RequestMapping(value = "custodianWorkspace.jsp/custodian/done/{complaint_id}/{user_id}", method = RequestMethod.GET)
	public String doneComplaintCustodian(@PathVariable("complaint_id") int complaintId,
			@PathVariable("user_id") int userID, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("done");
		complaint.setComplaint_done_by(userID);
		service.saveComplaint(complaint);

		return "redirect:/custodianDoneComplaints.jsp";

	}

	// Undo complaint by Plumber
	@RequestMapping(value = "plumberDoneComplaints.jsp/plumber/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintPlumber(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/plumberUI.jsp";

	}

	// Undo complaint by Mason
	@RequestMapping(value = "masonDoneComplaints.jsp/mason/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintMason(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/masonUI.jsp";

	}

	// Undo complaint by Carpenter
	@RequestMapping(value = "carpenterDoneComplaints.jsp/carpenter/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintCarpenter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/carpenterUI.jsp";

	}

	// Undo complaint by Security
	@RequestMapping(value = "securityDoneComplaints.jsp/security/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintSecurity(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/securityUI.jsp";

	}

	// Undo complaint by Electrician
	@RequestMapping(value = "electricianDoneComplaints.jsp/electrician/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintElectrician(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/electricianUI.jsp";

	}

	// Undo complaint by Cleaner
	@RequestMapping(value = "cleanerDoneComplaints.jsp/cleaner/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintCleaner(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/cleanerUI.jsp";

	}

	// Undo complaint by Health
	@RequestMapping(value = "healthDoneComplaints.jsp/health/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintHealth(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/healthUI.jsp";

	}

	// Undo complaint by Painter
	@RequestMapping(value = "painterDoneComplaints.jsp/painter/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintPainter(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/painterUI.jsp";

	}

	// Undo complaint by Custodian
	@RequestMapping(value = "custodianDoneComplaints.jsp/custodian/undo/{complaint_id}", method = RequestMethod.GET)
	public String undoComplaintCustodian(@PathVariable("complaint_id") int complaintId, Map<String, Object> map) {

		Complaint complaint = service.getComplaint(complaintId);
		complaint.setComplaint_status("assigned");
		complaint.setComplaint_done_by(0);
		service.saveComplaint(complaint);

		return "redirect:/custodianWorkspace.jsp";

	}

	// delete complaint by admin
	@RequestMapping(value = "admin/complaints.jsp/delete/{complaintId}", method = RequestMethod.GET)
	public String deleteComplaintAdmin(@PathVariable("complaintId") int complaintId, Map<String, Object> map) {
		service.deleteComplaint(complaintId);
		return "redirect:/admin/complaints.jsp";

	}

	// delete complaint by user
	@RequestMapping(value = "statusUI.jsp/delete/{complaintId}", method = RequestMethod.GET)
	public String deleteComplaintUser(@PathVariable("complaintId") int complaintId, Map<String, Object> map) {
		service.deleteComplaint(complaintId);
		return "redirect:/statusUI.jsp";

	}

	// Report Student
	@RequestMapping(value = "users.jsp/report/{userId}", method = RequestMethod.GET)
	public String reportUser(@PathVariable("userId") int userId, Map<String, Object> map, Model model) {
		model.addAttribute("userId", userId);
		return "/reportStudentUI.jsp";

	}

	// delete report by Custodian
	@RequestMapping(value = "reports.jsp/delete/{reportId}", method = RequestMethod.GET)
	public String deleteReportCustodian(@PathVariable("reportId") int reportId, Map<String, Object> map) {
		service.deleteReport(reportId);
		;
		return "redirect:/reports.jsp";

	}

	// delete report by Admin
	@RequestMapping(value = "/reports.jsp/admindelete/{reportId}", method = RequestMethod.GET)
	public String deleteReportAdmin(@PathVariable("reportId") int reportId, Map<String, Object> map) {
		service.deleteReport(reportId);
		;
		return "redirect:/admin/reports.jsp";

	}

}
