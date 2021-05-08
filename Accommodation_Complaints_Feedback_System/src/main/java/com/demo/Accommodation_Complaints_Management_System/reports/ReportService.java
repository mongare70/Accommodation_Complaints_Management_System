package com.demo.Accommodation_Complaints_Management_System.reports;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.demo.Accommodation_Complaints_Management_System.model.Complaint;
import com.demo.Accommodation_Complaints_Management_System.repository.ComplaintRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private ComplaintRepository repository;

	public String exportReport() throws JRException, IOException {
		String path = "C:\\Users\\Hillary Mongare\\OneDrive\\Desktop";
		List<Complaint> complaints = repository.findAll();

		// load file and compile it
		File file = ResourceUtils.getFile("classpath:complaints.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(complaints);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Admin");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\complaints.pdf");

		return "/admin/adminUI.jsp";
	}
}
