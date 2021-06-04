<%@ include file="/includes/header.jsp"%>
<div class="d-flex" id="wrapper">
		
            <!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="sidebar-heading border-bottom bg-light">ACMS</div>
			    <div class="list-group list-group-flush">
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/masonDashboard.jsp">Dashboard</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/masonUI.jsp">Mason Workspace</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/masonDoneComplaints.jsp">Done Complaints</a>
			    </div>
			</div>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
            	<!-- Navbar -->
               	<%@ include file="/includes/navigation.jsp"%>
               
               	<%
					if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("mason")) {
				%>
               
                <!-- Page content-->
                <div class="container-fluid bg">
                	
                	<br>
        
					<h1 style="text-align: center;"> List of <%=session.getAttribute("USER_FIRSTNAME")%>'s Complaints </h1>
                	
                	<%@ include file="/admin/includes/db.jsp" %>

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
				    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_block")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_room_number")); %></td>
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
            </div>
        </div>
        
		<% } else { %>
			<h1>You need to login as Mason first to access this page</h1>
		<% } %>
        
<%@ include file="/includes/footer.jsp"%>