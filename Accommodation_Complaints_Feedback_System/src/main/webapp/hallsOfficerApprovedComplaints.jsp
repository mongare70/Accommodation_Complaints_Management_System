<%@ include file="/includes/header.jsp"%>
<div class="d-flex" id="wrapper">
		
            <!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="sidebar-heading border-bottom bg-light">ACMS</div>
			    <div class="list-group list-group-flush">
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/hallsOfficerDashboard.jsp">Dashboard</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/hallsOfficerUI.jsp">Approve/Reject Complaints</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/hallsOfficerApprovedComplaints.jsp">Approved Complaints</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/hallsOfficerRejectedComplaints.jsp">Rejected Complaints</a>
			    </div>
			</div>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
            	<!-- Navbar -->
               	<%@ include file="/includes/navigation.jsp"%>
               
               	<%
					if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("halls_officer")) {
				%>
               
                <!-- Page content-->
                <div class="container-fluid bg">
                	<br>
                	<%@ include file="/admin/includes/db.jsp" %>
     		
					<h1 style="text-align: center;"> List of Complaints Approved By <%=session.getAttribute("USER_FIRSTNAME") %> </h1>
					<table class="table table-bordered table-hover">
		
					<tr>
						<td>Complaint Category</td>
						<td>Complaint Content</td>
						<td>Complaint Author: (ID)</td>
						<td>Complaint Status</td>
						<td>Hostel</td>
						<td>Block</td>
						<td>Room Number</td>
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
				    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_block")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_room_number")); %></td>
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
            </div>
        </div>
        
		<% } else { %>
			<h1>You need to login as Halls Officer first to access this page</h1>
		<% } %>
        
<%@ include file="/includes/footer.jsp"%>