<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">
	<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='custodianUI.jsp'">Back</button>
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
			
			<h1 style="text-align: center;"> List of Categorized Complaints</h1>
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint Title</td>
				<td>Complaint Content</td>
				<td>Complaint Author ID</td>
				<td>Complaint Status</td>
				<td>Complaint Approved By:</td>
				<td>Complaint Claimed By:</td>
				<td>Complaint Category</td>
				<td>Complaint Done By:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
				<td>Set Category to:</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE NOT complaint_category = 'undefined' ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_title")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_claimed_by")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_done_by")); %></td>
		    	<td><a href='custodianUI.jsp/mason/<%out.println(resultSet.getString("complaint_id")); %>'>Mason</a></td>
		    	<td><a href='custodianUI.jsp/plumber/<%out.println(resultSet.getString("complaint_id")); %>'>Plumber</a></td>
		    	<td><a href='custodianUI.jsp/carpenter/<%out.println(resultSet.getString("complaint_id")); %>'>Carpenter</a></td>
		    	<td><a href='custodianUI.jsp/security/<%out.println(resultSet.getString("complaint_id")); %>'>Security</a></td>
		    	<td><a href='custodianUI.jsp/electrician/<%out.println(resultSet.getString("complaint_id")); %>'>Electrician</a></td>
				<td><a href='custodianUI.jsp/health/<%out.println(resultSet.getString("complaint_id")); %>'>Health</a></td>
		    	<td><a href='custodianUI.jsp/painter/<%out.println(resultSet.getString("complaint_id")); %>'>Painter</a></td>
		    	<td><a href='custodianUI.jsp/cleaner/<%out.println(resultSet.getString("complaint_id")); %>'>Cleaner</a></td>
		    	<td><a href='custodianUI.jsp/custodian/<%out.println(resultSet.getString("complaint_id")); %>'>Custodian</a></td>
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