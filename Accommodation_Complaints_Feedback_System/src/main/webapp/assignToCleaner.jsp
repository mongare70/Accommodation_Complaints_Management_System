<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>

<% if(session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("custodian")){ %> 

    <div class="container-fluid bg">
    <button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='/custodianUI.jsp'">Back</button>
    <br>
		<div class="container">
			<div class="forms">
			<!-- Form Start -->
            <form class="form-container" method="post" action="/assignToWorker" id="assigningForm" name="assigningForm" onsubmit="return formValidate()">
                <h1>Complaint Assigning Form</h1>
               	<div class="form-group">
                   	<label for="complaint_id">Complaint ID:</label>
                  		<input type="number" class="form-control" value="${complaintId}" id="complaint_id" name="complaint_id" readonly>
                	 </div>
                  <div class="form-group">
                	<label for="complaint_assigned_to">Assign To:</label><br>
                    <select name="complaint_assigned_to" id="complaint_assigned_to">
			            <!-- Default -->
			            <option value="">Select Cleaner</option>
			            
			            <%@ include file="/admin/includes/db.jsp" %>
			            
			            <%
							
							try{
								connection = DriverManager.getConnection(connectionUrl, userId, password);
								statement=connection.createStatement();
								String sql ="SELECT * FROM users WHERE user_role = 'cleaner' ORDER BY user_id DESC";

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
             window.alert("Please Assign a Cleaner."); 
             complaint_assigned_to.focus(); 
             return false; 
         } 

         return true; 
     }	
	</script>
	
	<% } else { %>
<h1>You need to login as Custodian first to access this page</h1>
<% } %>
<%@ include file="/includes/footer.jsp" %>
