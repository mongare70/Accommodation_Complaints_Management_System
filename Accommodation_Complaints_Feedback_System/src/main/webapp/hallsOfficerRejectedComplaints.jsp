<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %> 
<% if(session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("halls_officer")){ %>
<div class="container-fluid bg">
<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='hallsOfficerUI.jsp'">Back</button>
     		
     		<%@ include file="/admin/includes/db.jsp" %>
			
			<h1 style="text-align: center;"> List of Complaints Rejected By <%=session.getAttribute("USER_FIRSTNAME") %> </h1>
			<table class="table table-bordered table-hover">

			<tr>
				<td>Complaint Category</td>
				<td>Complaint Content</td>
				<td>Complaint Author ID</td>
				<td>Complaint Status</td>
				<td>Hostel</td>
				<td>Block</td>
				<td>Room Number</td>
				<td>Complaint Rejected By (ID):</td>
				<td>Created At:</td>
				<td>Approve</td>
				<td>Reject</td>
    		</tr>

			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM complaints WHERE complaint_status = 'rejected' AND complaint_approved_or_rejected_by = "+ session.getAttribute("USER_ID") +" ORDER BY complaint_id DESC";

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
		    	<td><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></td>
		    	<td><%out.println(resultSet.getString("created_at")); %></td>
		    	<td><a href='hallsOfficerUI.jsp/approve/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Approve</a></td>
		    	<td><a href='hallsOfficerUI.jsp/reject/<%out.println(resultSet.getString("complaint_id")); %>/<%=session.getAttribute("USER_ID")%>/'>Reject</a></td>
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
<h1>You need to login as Halls Officer first to access this page</h1>
<% } %>
<%@ include file="/includes/footer.jsp" %>