<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
	
<div class="container-fluid bg">
<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='studentUI.jsp'">Back</button>
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
			
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint ID</td>
				<td>Complaint Title</td>
				<td>Complaint Content</td>
				<td>Complaint Author ID</td>
				<td>Complaint Category</td>
				<td>Complaint Status</td>
				<td>Complaint Approved/Rejected By:</td>
				<td>Complaint Claimed By:</td>
				<td>Complaint Done By:</td>
				<td>Delete</td>
    		</tr>


			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_author_id = '"+session.getAttribute("USER_ID")+"' ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_id")); %></td>
				<td><%out.println(resultSet.getString("complaint_title")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_claimed_by")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_done_by")); %></td>
		    	<td><a href='statusUI.jsp/delete/<%out.println(resultSet.getString("complaint_id")); %>'>Delete</a></td>
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