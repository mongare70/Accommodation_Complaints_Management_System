<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
    <div class="container-fluid bg">
		<div class="container">
				<!-- Form Start -->
            <form class="form-container" method="post" action="/submitComplaint" id="complaintForm" name="complaintForm" onsubmit="return formValidate()">
                <br>
                <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='statusUI.jsp'">Click Here To See <%=session.getAttribute("USER_FIRSTNAME") %>'s Complaint Status</button>
                <br>
                <h1>Welcome <%=session.getAttribute("USER_FIRSTNAME")%></h1>
                <br>
                <h1>Complaint Form</h1>
                  <div class="form-group">
                    <label for="complaint_title">Complaint Title:</label>
                    <input type="text" class="form-control" id="complaint_title" name="complaint_title" placeholder="Complaint Title">
                  </div>
                  <div class="form-group">
                    <label for="complaint_content">Complaint Content:</label>
                    <textarea rows="5" cols="50" class="form-control" id="complaint_content" name="complaint_content" placeholder="Complaint Content"></textarea>
                  </div>
                  
                  
  		          <input type="hidden" id="complaint_author_id" name="complaint_author_id" value="<%=session.getAttribute("USER_ID")%>">
               
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
            </form>
            <!-- Form End-->
		</div>
	</div>
	<script type="text/javascript">
	 function formValidate()                                    
     { 
         var complaint_title = document.forms["complaintForm"]["complaint_title"];               
         var complaint_content = document.forms["complaintForm"]["complaint_content"];
        
         if (complaint_title.value == "")                                  
         { 
             window.alert("Please enter the Complaint Title."); 
             complaint_title.focus(); 
             return false; 
         } 

         if (complaint_content.value == "")                                  
         { 
             window.alert("Please enter the Complaint Description."); 
             complaint_content.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>
<%@ include file="/includes/footer.jsp" %>