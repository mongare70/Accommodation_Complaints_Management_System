<%@ include file="/includes/header.jsp"%>
<div class="d-flex" id="wrapper">

            <!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="sidebar-heading border-bottom bg-light">ACMS</div>
			    <div class="list-group list-group-flush">
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/studentDashboard.jsp">Dashboard</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/studentUI.jsp"> Submit Complaint</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="statusUI.jsp"> Complaint Status</a>
			    </div>
			</div>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
            	<!-- Navbar -->
               	<%@ include file="/includes/navigation.jsp"%>
               
               	<%
					if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("student")) {
				%>
               
                <!-- Page content-->
                <div class="container-fluid bg">
                	
                	<br>
                	
                	<%@ include file="/admin/includes/db.jsp" %>
			
					<table class="table table-bordered table-hover">
						
						<tr>
							<td>Complaint Category</td>
							<td>Complaint Content</td>
							<td>Complaint Author: (ID)</td>
							<td>Hostel</td>
							<td>Block</td>
							<td>Room Number</td>
							<td>Complaint Status</td>
							<td>Complaint Approved/Rejected By: (ID)</td>
							<td>Complaint Assigned To: (ID)</td>
							<td>Complaint Done By: (ID)</td>
							<td>Created At:</td>
							<td>Delete</td>
			    		</tr>
			
			
						<%
						try{
						connection = DriverManager.getConnection(connectionUrl, userId, password);
						statement=connection.createStatement();
						String sql ="SELECT * FROM complaints WHERE complaint_author_id = '"+session.getAttribute("USER_ID")+"' ORDER BY complaint_id DESC";
			
						resultSet = statement.executeQuery(sql);
						while(resultSet.next()){
						%>
						<tr>
							<td><%out.println(resultSet.getString("complaint_category")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_content")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_author_id")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_hostel")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_block")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_room_number")); %></td>
					    	<td><%out.println(resultSet.getString("complaint_status")); %></td>
					    	<td><a href='user/<%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %>'><%out.println(resultSet.getString("complaint_approved_or_rejected_by")); %></a></td>
					    	<td><a href='user/<%out.println(resultSet.getString("complaint_assigned_to")); %>'><%out.println(resultSet.getString("complaint_assigned_to")); %></a></td>
					    	<td><a href='user/<%out.println(resultSet.getString("complaint_done_by")); %>'><%out.println(resultSet.getString("complaint_done_by")); %></a></td>
					    	<td><%out.println(resultSet.getString("created_at")); %></td>
					    	<td><a href='statusUI.jsp/delete/<%out.println(resultSet.getString("complaint_id")); %>'>Delete</a></td>
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
		<%
		} else {
		%>
		<h1>You need to login as Student first to access this page</h1>
		<%
		}
		%>
        
<%@ include file="/includes/footer.jsp"%>