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
					
					<h1 style="text-align: center;"> List of Reported Students</h1>
					
					<table class="table table-bordered table-hover">
		
					<tr>
						<td>Report ID</td>
						<td>Report Author: (ID)</td>
						<td>Report Title</td>
						<td>Report Content</td>
						<td>Reported Student: (ID)</td>
						<td>Delete</td>
		    		</tr>
		
		
					<%
					try{
					connection = DriverManager.getConnection(connectionUrl, userId, password);
					statement=connection.createStatement();
					String sql ="SELECT * FROM reports WHERE report_author_id = "+ session.getAttribute("USER_ID") +" ORDER BY report_id DESC";
		
					resultSet = statement.executeQuery(sql);
					while(resultSet.next()){
					%>
					<tr>
						<td><%out.println(resultSet.getString("report_id")); %></td>
						<td><%out.println(resultSet.getString("report_author_id")); %></td>
				    	<td><%out.println(resultSet.getString("report_title")); %></td>
				    	<td><%out.println(resultSet.getString("report_content")); %></td>
				    	<td><%out.println(resultSet.getString("student_id")); %></td>
				    	<td><a href='reports.jsp/delete/<%out.println(resultSet.getString("report_id")); %>'>Delete</a></td>
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