<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
      
    <div class="container-fluid bg">
		<div class="container">
				<!-- Form Start -->
	            <form class="form-container" method="post" action="/login" name="login_form" id="login_form" onsubmit="return validateForm()">
	                <h1>Login Form</h1>
	                <div class="form-group">
	                    <label for="category">Category:</label>
	                    <select class="form-control" id="category" name="category">
	                        <option>Admin</option>
	                        <option>Student</option>
	                        <option>Halls Officer</option>
	                        <option>Custodian</option>
	                        <option>Mason</option>
	                        <option>Carpenter</option>
	                        <option>Security</option>
	                        <option>Plumber</option>
	                        <option>Electrician</option>
	                    </select>
	                </div>
	                  <div class="form-group">
	                    <label for="username">Username:</label>
	                    <input type="text" class="form-control" name="uname" id="uname" placeholder="Username">
	                  </div>
	                  <div class="form-group">
	                    <label for="password">Password:</label>
	                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
	                  </div>
	                  <button type="submit" class="btn btn-success btn-block">Submit</button>
	                  <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='register_user.jsp'">Register Here</button>
	            </form>
				<!-- Form End-->
			</div>
		</div>
	
	<script type="text/javascript">
	 function validateForm()                                    
     { 
         var uname = document.forms["login_form"]["uname"];               
         var password = document.forms["login_form"]["password"];
        
         if (uname.value == "")                                  
         { 
             window.alert("Please enter your Username."); 
             uname.focus(); 
             return false; 
         } 

         if (password.value == "")                                  
         { 
             window.alert("Please enter your Password."); 
             password.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>
<%@ include file="/includes/footer.jsp" %>