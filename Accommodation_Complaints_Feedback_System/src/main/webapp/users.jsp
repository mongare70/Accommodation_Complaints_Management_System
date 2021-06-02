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
                	
                	<h1 style="text-align: center;"> List of Students</h1>
                	
                	<%@ include file="/admin/includes/db.jsp" %>

					<table class="table table-bordered table-hover">
		
					<tr>
						<td>User ID</td>
						<td>Registration Number</td>
						<td>Firstname</td>
						<td>Lastname</td>
						<td>Username</td>
						<td>Email</td>
						<td>User Role</td>
						<td>Report Student</td>
		    		</tr>
		
		
					<%
					try{
					connection = DriverManager.getConnection(connectionUrl, userId, password);
					statement=connection.createStatement();
					String sql ="SELECT * FROM users WHERE user_role = 'student' ORDER BY user_id DESC";
		
					resultSet = statement.executeQuery(sql);
					while(resultSet.next()){
					%>
					<tr>
						<td><%out.println(resultSet.getString("user_id")); %></td>
						<td><%out.println(resultSet.getString("user_number")); %></td>
				    	<td><%out.println(resultSet.getString("user_firstname")); %></td>
				    	<td><%out.println(resultSet.getString("user_lastname")); %></td>
				    	<td><%out.println(resultSet.getString("username")); %></td>
				    	<td><%out.println(resultSet.getString("user_email")); %></td>
				    	<td><%out.println(resultSet.getString("user_role")); %></td>
				    	<td><a href='users.jsp/report/<%out.println(resultSet.getString("user_id")); %>'>Report</a></td>
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