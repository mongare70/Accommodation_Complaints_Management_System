<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
<div class="container-fluid bg">
		<div class="container">
			<!-- Form Start -->
            <form class="form-container" method="post" action="/register_user" name="user_registration_form" id="user_registration_form" onsubmit="return validateForm()">
                <h1>User Registration Form</h1>
                <div class="form-group">
                    <label for="user_number">Staff Number/Registration Number:</label>
                    <input type="text" class="form-control" id="user_number" name="user_number" placeholder="Staff Number/Registration Number">
                </div>
                <div class="form-group">
                    <label for="user_firstname">Firstname:</label>
                    <input type="text" class="form-control" id="user_firstname" name="user_firstname" placeholder="Firstname">
                </div>
                <div class="form-group">
                    <label for="user_lastname">Lastname:</label>
                    <input type="text" class="form-control" id="user_lastname" name="user_lastname" placeholder="Lastname">
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="user_email">Email:</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Email">
                </div>
                <div class="form-group">
                	<label for="user_role">User Role:</label><br>
                    <select name="user_role" id="user_role">
			            <!-- Default -->
			            <option value="student">Select Options</option>
			            
			            <option value="student">Student</option>
			            <option value="halls_officer">Halls Officer</option>
			            <option value="custodian">Custodian</option>
			            <option value="carpenter">Carpenter</option>
			            <option value="electrician">Electrician</option>
			            <option value="plumber">Plumber</option>
			            <option value="mason">Mason</option>
			            <option value="security">Security</option>
		        	</select>
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" onkeyup='check();'> <span id='message'></span>
                </div>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='login.jsp'">Cancel</button>
            </form>
				<!-- Form End-->
            <script>
                function validateForm()                                    
                    { 
                		var user_number = document.forms["user_registration_form"]["user_number"];
                        var user_firstname = document.forms["user_registration_form"]["user_firstname"];               
                        var user_lastname = document.forms["user_registration_form"]["user_lastname"];
                        var username = document.forms["user_registration_form"]["username"];
                        var user_email = document.forms["user_registration_form"]["user_email"];
                        var password = document.forms["user_registration_form"]["password"];
                        var confirmPassword = document.forms["user_registration_form"]["confirmPassword"];
                        
                        if (user_number.value == "")                                  
                        { 
                            window.alert("Please enter your Staff Number/Registration Number."); 
                            user_number.focus(); 
                            return false; 
                        } 

                        if (user_firstname.value == "")                                  
                        { 
                            window.alert("Please enter your Firstname."); 
                            user_firstname.focus(); 
                            return false; 
                        } 

                        if (user_lastname.value == "")                                  
                        { 
                            window.alert("Please enter your Lastname."); 
                            user_lastname.focus(); 
                            return false; 
                        } 

                        if (username.value == "")                                  
                        { 
                            window.alert("Please enter your Username."); 
                            username.focus(); 
                            return false; 
                        } 
                        
                        if (user_email.value == "")                                  
                        { 
                            window.alert("Please enter your Email."); 
                            user_email.focus(); 
                            return false; 
                        } 
                        
                        
                        if (password.value == "")                        
                        { 
                            window.alert("Please enter your Password."); 
                            password.focus(); 
                            return false; 
                        } 
                        
                        if (confirmPassword.value == "")                        
                        { 
                            window.alert("Please confirm your Password."); 
                            confirmPassword.focus(); 
                            return false; 
                        } 
                        
                        if (confirmPassword.value == password)                        
                        { 
                            window.alert("Your current password does not match with your current password."); 
                            confirmPassword.focus(); 
                            return false; 
                        } 


                        return true; 
                    }

                var check = function() {
                      if (document.getElementById('password').value ==
                        document.getElementById('confirmPassword').value) {
                        document.getElementById('message').style.color = 'green';
                        document.getElementById('message').innerHTML = 'matching';
                      } else {
                        document.getElementById('message').style.color = 'red';
                        document.getElementById('message').innerHTML = 'not matching';
                      }
                    }
	       </script>
		</div>
	</div>
<%@ include file="/includes/footer.jsp" %>