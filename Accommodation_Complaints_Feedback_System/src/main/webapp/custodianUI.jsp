<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">
	<button type="button" class="btn btn-success btn-block" onClick="window.location.href='/assignedComplaints.jsp'">Click Here To Go To Assigned Complaints</button>
	<br>
	<button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/custodianWorkspace.jsp'">Click Here To Go To Custodian Workspace</button>
	<br>
	<button type="button" class="btn btn-danger btn-block" onClick="window.location.href='/users.jsp'">Report Student</button>
	<br>

     		<%@page import="java.sql.DriverManager"%>
			<%@page import="java.sql.ResultSet"%>
			<%@page import="java.sql.Statement"%>
			<%@page import="java.sql.Connection"%>

			<%

			String driverName = "com.mysql.cj.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost:3306/accommodation_complaints_feedback_system";
			String userId = "root";
			String password = "";

			try {
			Class.forName(driverName);
			}catch (ClassNotFoundException e) {
			e.printStackTrace();
			}

			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			%>
			
			<h1 style="text-align: center;"> List of Complaints</h1>
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint Category</td>
				<td>Complaint Content</td>
				<td>Complaint Author ID</td>
				<td>Complaint Status</td>
				<td>Complaint Approved By: (ID)</td>
				<td>Assign to:</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'approved' AND complaint_assigned_to = 0 ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></td>
		    	<td><div class="dropdown">
					  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
					    Assign To:
					  </a>
					  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					    <li><a href='custodianUI.jsp/mason/<%out.println(resultSet.getString("complaint_id")); %>'>Mason</a></li>
					    <li><a href='custodianUI.jsp/plumber/<%out.println(resultSet.getString("complaint_id")); %>'>Plumber</a></li>
					    <li><a href='custodianUI.jsp/carpenter/<%out.println(resultSet.getString("complaint_id")); %>'>Carpenter</a></li>
					    <li><a href='custodianUI.jsp/security/<%out.println(resultSet.getString("complaint_id")); %>'>Security</a></li>
					    <li><a href='custodianUI.jsp/electrician/<%out.println(resultSet.getString("complaint_id")); %>'>Electrician</a></li>
					    <li><a href='custodianUI.jsp/health/<%out.println(resultSet.getString("complaint_id")); %>'>Health</a></li>
					    <li><a href='custodianUI.jsp/painter/<%out.println(resultSet.getString("complaint_id")); %>'>Painter</a></li>
					    <li><a href='custodianUI.jsp/cleaner/<%out.println(resultSet.getString("complaint_id")); %>'>Cleaner</a></li>
					    <li><a href='custodianUI.jsp/custodian/<%out.println(resultSet.getString("complaint_id")); %>'>Custodian</a></li>
					  </ul>
					</div></td>
			</tr>

			<%
		    }

		    } catch (Exception e) {
		    e.printStackTrace();
		    }
			%>
			</table>
</div>
<%@ include file="/includes/footer.jsp" %>