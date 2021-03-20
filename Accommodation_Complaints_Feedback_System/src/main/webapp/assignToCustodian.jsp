<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

    <div class="container-fluid bg">
    <button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='/custodianUI.jsp'">Back</button>
    <br>
		<div class="container">
				<!-- Form Start -->
            <form class="form-container" method="post" action="/assignToWorker" id="assigningForm" name="assigningForm" onsubmit="return formValidate()">
                <br>
                <h1>Complaint Assigning Form</h1>
               	<div class="form-group">
                   	<label for="complaint_id">Complaint ID:</label>
                  		<input type="number" class="form-control" value="${complaintId}" id="complaint_id" name="complaint_id" readonly>
                	 </div>
                  <div class="form-group">
                	<label for="complaint_assigned_to">Assign To:</label><br>
                    <select name="complaint_assigned_to" id="complaint_assigned_to">
			            <!-- Default -->
			            <option value="">Select Custodian</option>
			            
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
							
							try{
								connection = DriverManager.getConnection(connectionUrl, userId, password);
								statement=connection.createStatement();
								String sql ="SELECT * FROM users WHERE user_role = 'custodian' ORDER BY user_id DESC";

								resultSet = statement.executeQuery(sql);
								while(resultSet.next()){
						%>
						
						<option value="<%out.println(resultSet.getString("user_id")); %>"><%out.println(resultSet.getString("user_firstname")); %></option>
			           <%
					    }
			
					    } catch (Exception e) {
					    e.printStackTrace();
					    }
						%>
		        	</select>
                </div>
                  
  		          <input type="hidden" id="complaint_assigned_by" name="complaint_assigned_by" value="<%=session.getAttribute("USER_ID")%>">
               
                  <button type="submit" class="btn btn-success btn-block">Assign</button>
            </form>
            <!-- Form End-->
		</div>
	</div>
	<script type="text/javascript">
	 function formValidate()                                    
     { 	
		 var complaint_id = document.forms["assigningForm"]["complaint_id"];  
		 var complaint_assigned_to = document.forms["assigningForm"]["complaint_assigned_to"];  
        
         if (complaint_id.value == "")                                  
         { 
             window.alert("Please enter the Complaint ID."); 
             complaint_id.focus(); 
             return false; 
         } 
         
         if (complaint_assigned_to.value == "")                                  
         { 
             window.alert("Please Assign a Custodian."); 
             complaint_assigned_to.focus(); 
             return false; 
         } 

         return true; 
     }	
	</script>
