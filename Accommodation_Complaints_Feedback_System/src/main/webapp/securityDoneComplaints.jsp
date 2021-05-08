<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<% if(session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("security")){ %>  
<div class="container-fluid bg">
<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='securityUI.jsp'">Back</button>
     		
     		<%@ include file="/admin/includes/db.jsp" %>
			
			<h1 style="text-align: center;"> List of Complaints Done By <%=session.getAttribute("USER_FIRSTNAME") %> </h1>
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint Category</td>
				<td>Complaint Content</td>
				<td>Complaint Author: (ID)</td>
				<td>Complaint Status</td>
				<td>Hostel</td>
				<td>Block</td>
				<td>Room Number</td>
				<td>Complaint Assigned By: (ID)</td>
				<td>Complaint Assigned To: (ID)</td>
				<td>Complaint Done By: (ID)</td>
				<td>Undo Complaint</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'done' AND complaint_category = 'security' AND complaint_done_by = "+ session.getAttribute("USER_ID") +" AND complaint_assigned_to = "+ session.getAttribute("USER_ID") +" ORDER BY complaint_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("complaint_category")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_author_id")); %>'><%out.println(resultSet.getString("complaint_author_id")); %></a></td>
		    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_block")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_room_number")); %></td>
		    	<td><a href='user/<%out.println(resultSet.getString("complaint_assigned_by")); %>'><%out.println(resultSet.getString("complaint_assigned_by")); %></a></td>
		    	<td><%out.println(resultSet.getString("complaint_assigned_to")); %></td>
		    	<td><%out.println(resultSet.getString("complaint_done_by")); %></td>
		    	<td><a href='securityDoneComplaints.jsp/security/undo/<%out.println(resultSet.getString("complaint_id")); %>'>Undo</a></td>
			</tr>

			<%
		    }

		    } catch (Exception e) {
		    e.printStackTrace();
		    }
			%>
			</table>
</div>
<% } else { %>
<h1>You need to login as a Security Officer first to access this page</h1>
<% } %>
<%@ include file="/includes/footer.jsp" %>