<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<div class="container-fluid bg">
	<br>
	<button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/securityClaimedComplaints.jsp'">Click Here To Go To Complaints That <%=session.getAttribute("USER_FIRSTNAME")%> Has 'Claimed'</button>
	<br>
	<button type="button" class="btn btn-success btn-block" onClick="window.location.href='/securityDoneComplaints.jsp'">Click Here To Go To Complaints That <%=session.getAttribute("USER_FIRSTNAME")%> Has 'done'</button>
	<br>
	<h1 style="text-align: center;"> List of Unclaimed Complaints </h1>
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
				<td>Complaint Title</td>
				<td>Complaint Content</td>
				<td>Complaint Author ID</td>
				<td>Complaint Status</td>
				<td>Complaint Category</td>
				<td>Claim Complaint</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'approved' AND complaint_category = 'security' AND complaint_claimed_by = 0 AND complaint_done_by = 0 ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_title")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><a href='securityUI.jsp/security/claim/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>'>Claim</a></td>

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