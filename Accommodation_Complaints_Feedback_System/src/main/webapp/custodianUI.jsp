<%@ include file="/includes/header.jsp"%>
<div class="d-flex" id="wrapper">
		
            <!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="sidebar-heading border-bottom bg-light">ACMS</div>
			    <div class="list-group list-group-flush">
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/custodianDashboard.jsp">Dashboard</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/custodianWorkspace.jsp">Custodian Workspace</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/custodianUI.jsp">Assign Complaints</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/assignedComplaints.jsp">Assigned Complaints</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/users.jsp">Report Student</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/reportedStudents.jsp">Reported Students</a>
			    </div>
			</div>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
            	<!-- Navbar -->
               	<%@ include file="/includes/navigation.jsp"%>
               
               	<%
					if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("custodian")) {
				%>
               
                <!-- Page content-->
                <div class="container-fluid bg">
                	
                	<br>
                	
                	<%@ include file="/admin/includes/db.jsp" %>
			
					<h1 style="text-align: center;"> List of Approved Complaints</h1>
					<table class="table table-bordered table-hover">
		
					<tr>
						<td>Complaint Category</td>
						<td>Complaint Content</td>
						<td>Complaint Hostel</td>
						<td>Complaint Author: (ID)</td>
						<td>Complaint Status</td>
						<td>Hostel</td>
						<td>Block</td>
						<td>Room Number</td>
						<td>Complaint Approved By: (ID)</td>
						<td>Assign to:</td>
		    		</tr>
		
					<%
					try{
					connection = DriverManager.getConnection(connectionUrl, userId, password);
					statement=connection.createStatement();
					String sql ="SELECT * FROM complaints WHERE complaint_status = 'approved' AND complaint_assigned_to = 0 ORDER BY complaint_id DESC";
		
					resultSet = statement.executeQuery(sql);
					while(resultSet.next()){
					%>
					<tr>
						<td><%out.println(resultSet.getString("complaint_category")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
				    	<td><a href='user/<%out.println(resultSet.getString("complaint_author_id")); %>'><%out.println(resultSet.getString("complaint_author_id")); %></a></td>
				    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_block")); %></td>
				    	<td><%out.println(resultSet.getString("complaint_room_number")); %></td>
				    	<td><a href='user/<%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %>'><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></a></td>
				    	<%if(resultSet.getString("complaint_category").equals("plumber")){ %>
				    	<td><a href='custodianUI.jsp/plumber/<%out.println(resultSet.getString("complaint_id")); %>'>Plumber</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("mason")){ %>
				    	<td><a href='custodianUI.jsp/mason/<%out.println(resultSet.getString("complaint_id")); %>'>Mason</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("carpenter")){ %>
				    	<td><a href='custodianUI.jsp/carpenter/<%out.println(resultSet.getString("complaint_id")); %>'>Carpenter</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("security")){ %>
				    	<td><a href='custodianUI.jsp/security/<%out.println(resultSet.getString("complaint_id")); %>'>Security</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("electrician")){ %>
				    	<td><a href='custodianUI.jsp/electrician/<%out.println(resultSet.getString("complaint_id")); %>'>Electrician</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("health")){ %>
				    	<td><a href='custodianUI.jsp/health/<%out.println(resultSet.getString("complaint_id")); %>'>Health</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("painter")){ %>
				    	<td><a href='custodianUI.jsp/painter/<%out.println(resultSet.getString("complaint_id")); %>'>Painter</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("cleaner")){ %>
				    	<td><a href='custodianUI.jsp/cleaner/<%out.println(resultSet.getString("complaint_id")); %>'>Cleaner</a></td>
				    	<% } else if(resultSet.getString("complaint_category").equals("custodian") || resultSet.getString("complaint_category").equals("others") ){ %>
				    	<td><a href='custodianUI.jsp/custodian/<%out.println(resultSet.getString("complaint_id")); %>'>Custodian</a></td>
				    	<% } %>
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
			<h1>You need to login as Custodian first to access this page</h1>
		<% } %>
        
<%@ include file="/includes/footer.jsp"%>