<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">

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
				<td>Complaint Status</td>
				<td>Complaint Category</td>
				<td>Complaint Done By:</td>
				<td>Undo Complaint</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'done' AND complaint_category = 'plumber' AND complaint_done_by = "+ session.getAttribute("USER_ID") +" AND complaint_claimed_by = "+ session.getAttribute("USER_ID") +" ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_id")); %></td>
				<td><%out.println(resultSet.getString("complaint_title")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_done_by")); %></td>
		    	<td><a href='plumberDoneComplaints.jsp/plumber/undo/<%out.println(resultSet.getString("complaint_id")); %>'>Undo</a></td>

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