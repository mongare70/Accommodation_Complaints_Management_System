<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
    <div class="container-fluid bg">
		<div class="container">
				<!-- Form Start -->
            <form class="form-container" method="post" action="/submitComplaint" id="complaintForm" name="complaintForm" onsubmit="return formValidate()">
                <br>
                <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='StatusUI.jsp'">Complaint Status</button>
                <br>
                <h1>Welcome <%=session.getAttribute("USER_FIRSTNAME")%></h1>
                <br>
                <h1>Complaint Form</h1>
                  <div class="form-group">
                    <label for="complaintTitle">Complaint Title:</label>
                    <input type="text" class="form-control" id="complaintTitle" name="complaintTitle" placeholder="Complaint Title">
                  </div>
                  <div class="form-group">
                    <label for="complaintDescription">Complaint Description:</label>
                    <textarea rows="5" cols="50" class="form-control" id="complaintDescription" name="complaintDescription" placeholder="Complaint Description"></textarea>
                  </div>
                
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
            </form>
            <br>
            <form action="/logout" method="post">
            	<button type="submit" class="btn btn-danger btn-block">Log Out</button>
            </form>
				<!-- Form End-->
		</div>
	</div>
	<script type="text/javascript">
	 function formValidate()                                    
     { 
         var complaintTitle = document.forms["complaintForm"]["complaintTitle"];               
         var complaintDescription = document.forms["complaintForm"]["complaintDescription"];
        
         if (complaintTitle.value == "")                                  
         { 
             window.alert("Please enter the Complaint Title."); 
             complaintTitle.focus(); 
             return false; 
         } 

         if (complaintDescription.value == "")                                  
         { 
             window.alert("Please enter the Complaint Description."); 
             complaintDescription.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>
<%@ include file="/includes/footer.jsp" %>