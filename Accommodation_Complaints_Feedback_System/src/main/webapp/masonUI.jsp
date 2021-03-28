<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">
	<br>
	<button type="button" class="btn btn-success btn-block" onClick="window.location.href='/masonDoneComplaints.jsp'">Click Here To Go To Complaints That <%=session.getAttribute("USER_FIRSTNAME")%> Has 'done'</button>
	<br>
	<h1 style="text-align: center;"> List of <%=session.getAttribute("USER_FIRSTNAME")%>'s Complaints </h1>
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
				<td>Complaint Category</td>
				<td>Complaint Content</td>
				<td>Complaint Author: (ID)</td>
				<td>Complaint Status</td>
				<td>Complaint Assigned By: (ID)</td>
				<td>Complaint Assigned To: (ID)</td>
				<td>Done Complaint?</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'assigned' AND complaint_category = 'mason' AND complaint_assigned_to = "+session.getAttribute("USER_ID")+" AND complaint_done_by = 0 ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_author_id")); %>'><%out.println(resultSet.getString("complaint_author_id")); %></a></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_assigned_by")); %>'><%out.println(resultSet.getString("complaint_assigned_by")); %></a></td>
		    	<td><%out.println(resultSet.getString("complaint_assigned_to")); %></td>
		    	<td><a href='masonUI.jsp/mason/done/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>'>Done</a></td>

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