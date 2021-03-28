<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">
<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='hallsOfficerUI.jsp'">Back</button>
 
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
			<h1 style="text-align: center;"> List of Complaints Approved By <%=session.getAttribute("USER_FIRSTNAME") %> </h1>
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint Category</td>
				<td>Complaint Content</td>
				<td>Complaint Author: (ID)</td>
				<td>Complaint Status</td>
				<td>Complaint Approved By (ID):</td>
				<td>Complaint Assigned To (ID):</td>
				<td>Complaint Done By (ID):</td>
				<td>Created At:</td>
				<td>Approve</td>
				<td>Reject</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'approved' OR complaint_status = 'assigned' OR complaint_status = 'done' AND complaint_approved_or_rejected_by = "+ session.getAttribute("USER_ID") +" ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_author_id")); %>'><%out.println(resultSet.getString("complaint_author_id")); %></a></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_assigned_to")); %>'><%out.println(resultSet.getString("complaint_assigned_to")); %></a></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_done_by")); %>'><%out.println(resultSet.getString("complaint_done_by")); %></a></td>
		    	<td><%out.println(resultSet.getString("created_at")); %></td>
		    	<% if(resultSet.getInt("complaint_assigned_to") == 0){ %>
		    	<td><a href='hallsOfficerUI.jsp/approve/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Approve</a></td>
		    	<td><a href='hallsOfficerUI.jsp/reject/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Reject</a></td>
				<% } else { %>
				<td><a style="pointer-events: none;" href='hallsOfficerUI.jsp/approve/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Approve (Disabled)</a></td>
		    	<td><a style="pointer-events: none;" href='hallsOfficerUI.jsp/reject/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Reject (Disabled)</a></td>
				<%} %>
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