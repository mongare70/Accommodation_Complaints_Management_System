<%@ include file="/includes/header.jsp" %>
    <div class="container-fluid bg">
		<div class="row">
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
				<!-- Form Start -->
            <form class="form-container" method="post" action="/submitComplaint" id="complaintForm" name="complaintForm" onsubmit="return formValidate()">
                <br>
                <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='StatusUI.jsp'">Complaint Status</button>
                <br>
                <h1>Welcome ${student.fname}</h1>
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
                <input type="hidden" name="fname" value="${student.fname}">
                <input type="hidden" name="lname" value="${student.lname}">
                <input type="hidden" name="regNo" value="${student.regNo}">
                <input type="hidden" name="phoneNumber" value="${student.phoneNumber}">
                <input type="hidden" name="hostel" value="${student.hostel}">
                <input type="hidden" name="block" value="${student.block}">
                <input type="hidden" name="roomNumber" value="${student.roomNumber}">
                
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                  <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='login.jsp'">Log Out</button>
            </form>
				<!-- Form End-->
		</div>
		<div class="col-md-2 col-sm-4 col-xs-12"></div>
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
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>