<%@ include file="/admin/includes/admin_header.jsp" %>
<%@ include file="/admin/includes/admin_navigation.jsp" %>
<div class="container-fluid bg">
		<div class="container">
			<!-- Form Start -->
            <form class="form-container" method="post" action="/register_user" name="user_registration_form" id="user_registration_form" onsubmit="return validateForm()">
                <h1>User Registration Form</h1>
                <div class="form-group">
                	<label for="user_role">User Role:</label><br>
                    <select onchange = "displayFunction()" name="user_role" id="user_role">
			            <!-- Default -->
			            <option value="student">Select Options</option>
			            
			            <option value="student">Student</option>
			            <option value="admin">Admin</option>
			            <option value="halls_officer">Halls Officer</option>
			            <option value="custodian">Custodian</option>
			            <option value="carpenter">Carpenter</option>
			            <option value="electrician">Electrician</option>
			            <option value="plumber">Plumber</option>
			            <option value="mason">Mason</option>
			            <option value="security">Security</option>
			            <option value="cleaner">Cleaner</option>
			            <option value="health">Health</option>
			            <option value="painter">Painter</option>
		        	</select>
                </div>
                <div class="form-group">
                    <label for="user_number">Registration Number:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="reg_no" name="user_number" placeholder="Registration Number" pattern="[A-Z][0-9]+/[0-9]+\/[0-9]{2}$" title="Use this format A12/1234567/17">
                </div>
                <div class="form-group">
                    <label for="user_number">Staff Number:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="staff_no" name="user_number" placeholder="Staff Number" pattern="[A-Z]+[A-Z]+[0-9]{5,5}" title="2 or 3 capital letters followed by 5 numbers" minlength="7" maxlength="8">
                </div>
                <div class="form-group">
                    <label for="user_firstname">Firstname:</label>
                    <input type="text" class="form-control" id="user_firstname" name="user_firstname" placeholder="Firstname" pattern="[A-Za-z']+" title="alphabets and ' only" required>
                </div>
                <div class="form-group">
                    <label for="user_lastname">Lastname:</label>
                    <input type="text" class="form-control" id="user_lastname" name="user_lastname" placeholder="Lastname" pattern="[A-Za-z']+" title="alphabets and ' only" required>
                </div>
                <div class="form-group">
                
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" minlength="5" required>
                </div>
                <div class="form-group">
                    <label for="user_email">Email:</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Use the correct format -----@-----.---" required>
                </div>
                <div class="form-group">
                    <label for="user_hostel">Hostel:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="user_hostel" name="user_hostel" placeholder="Hostel">
                </div>
                <div class="form-group">
                    <label for="user_block">Block:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="user_block" name="user_block" placeholder="Block">
                </div>
                <div class="form-group">
                    <label for="user_room_number">Room Number:</label>
                    <input type="number" style="visibility: hidden" class="form-control" id="user_room_number" name="user_room_number" placeholder="Room Number">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" minlength="6">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" onkeyup='check();'> <span id='message'></span>
                </div>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='/admin/adminUI.jsp'">Cancel</button>
            </form>
				<!-- Form End-->
            <script>
            
            	function displayFunction() { 
            		
            		if (document.getElementById("user_role").value == "student"){
            			var reg_no = document.getElementById("reg_no");
            			var staff_no = document.getElementById("staff_no");
            			var hostel = document.getElementById("user_hostel");
                		var hostel = document.getElementById("user_hostel");
                		var block = document.getElementById("user_block");
                		var roomNumber = document.getElementById("user_room_number");
                		
                		staff_no.style.visibility = "hidden";
                		reg_no.style.visibility = "visible";
                		hostel.style.visibility = "visible";
                		block.style.visibility = "visible";
                		roomNumber.style.visibility = "visible";
                		
                	} else if (document.getElementById("user_role").value != "student" && document.getElementById("user_role").value != "custodian") {
                		var reg_no = document.getElementById("reg_no");
                		var staff_no = document.getElementById("staff_no");
                		var hostel = document.getElementById("user_hostel");
                		var block = document.getElementById("user_block");
                		var roomNumber = document.getElementById("user_room_number");
                		
                		reg_no.style.visibility = "hidden";
                		staff_no.style.visibility = "visible";
                		hostel.style.visibility = "hidden";
                		block.style.visibility = "hidden";
                		roomNumber.style.visibility = "hidden";
                		
                	} else if (document.getElementById("user_role").value == "custodian") {
                		var reg_no = document.getElementById("reg_no");
                		var staff_no = document.getElementById("staff_no");
                		var hostel = document.getElementById("user_hostel");
                		var block = document.getElementById("user_block");
                		
                		reg_no.style.visibility = "hidden";
                		staff_no.style.visibility = "visible";
                		hostel.style.visibility = "visible";
                		block.style.visibility = "visible";
                	}
            	}
            	
                function validateForm()                                    
                    { 
                		var user_firstname = document.forms["user_registration_form"]["user_firstname"];               
                        var user_lastname = document.forms["user_registration_form"]["user_lastname"];
                        var username = document.forms["user_registration_form"]["username"];
                        var user_email = document.forms["user_registration_form"]["user_email"];
                        var password = document.forms["user_registration_form"]["password"];
                        var confirmPassword = document.forms["user_registration_form"]["confirmPassword"];
                        
                        
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
<%@ include file="/admin/includes/admin_footer.jsp" %>