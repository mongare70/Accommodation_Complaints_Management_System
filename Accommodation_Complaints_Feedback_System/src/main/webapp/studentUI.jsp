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
                
                	<div class="forms">
                	
                	<br>              
                
					<!-- Form Start -->
					<form class="form-container" method="post" action="/submitComplaint" id="complaintForm" name="complaintForm" onsubmit="return formValidate()">
						
						<h1 style="text-align: center; color: green;">Complaint Form</h1>
					
						<div class="form-group">
							<label for="complaint_category">Complaint Category:</label> <select
								name="complaint_category" id="complaint_category">
								<!-- Default -->
								<option value="None">Select Options</option>
			
								<option value="others">Other</option>
								<option value="mason">Masonry</option>
								<option value="plumber">Plumbing</option>
								<option value="carpenter">Carpentry</option>
								<option value="security">Security</option>
								<option value="electrician">Electrical</option>
								<option value="health">Health</option>
								<option value="painter">Painting</option>
								<option value="cleaner">Cleaning</option>
								<option value="custodian">Custodian Related</option>
							</select>
						</div>
						<div class="form-group">
							<label for="complaint_content">Complaint Content:</label>
							<textarea rows="5" cols="50" class="form-control"
								id="complaint_content" name="complaint_content" maxlength="150"
								placeholder="Complaint Content"></textarea>
						</div>
			
			
						<input type="hidden" id="complaint_author_id"
							name="complaint_author_id"
							value="<%=session.getAttribute("USER_ID")%>">
			
						<%@ include file="/admin/includes/db.jsp"%>
			
						<%
						try {
							connection = DriverManager.getConnection(connectionUrl, userId, password);
							statement = connection.createStatement();
							String sql = "SELECT * FROM users WHERE user_id = " + session.getAttribute("USER_ID");
			
							resultSet = statement.executeQuery(sql);
							while (resultSet.next()) {
						%>
			
						<input type="hidden" id="complaint_hostel" name="complaint_hostel"
							value="<%out.println(resultSet.getString("user_hostel"));%>">
						<input type="hidden" id="complaint_block" name="complaint_block"
							value="<%out.println(resultSet.getString("user_block"));%>">
						<input type="hidden" id="complaint_room_number"
							name="complaint_room_number"
							value="<%out.println(resultSet.getInt("user_room_number"));%>">
			
						<%
						}
			
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>
			
						<button type="submit" class="btn btn-success btn-block">Submit</button>
					</form>
					<!-- Form End-->
					</div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
			function formValidate() {
				var complaint_content = document.forms["complaintForm"]["complaint_content"];
		
				if (complaint_content.value == "") {
					window.alert("Please enter the Complaint Description.");
					complaint_content.focus();
					return false;
				}
		
				return true;
			}
		</script>
		<%
		} else {
		%>
		<h1>You need to login as Student first to access this page</h1>
		<%
		}
		%>
        
<%@ include file="/includes/footer.jsp"%>