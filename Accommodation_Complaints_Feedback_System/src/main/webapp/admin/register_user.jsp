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
			            <option value="">Select Options</option>
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
                
                <div id="registration_number" style="visibility:hidden; position:absolute;" class="form-group">
                    <label for="reg_no" id="reg_no_label">Registration Number:</label>
                    <input type="text" class="form-control" id="reg_no" name="reg_no" placeholder="Registration Number" pattern="[A-Z][0-9]+/[0-9]+\/[0-9]{2}$" title="Use this format A12/1234567/17">
                </div>
                <div id="staff_number" style="visibility:hidden; position:absolute;" class="form-group">
                    <label for="staff_no" id="staff_no_label">Staff Number:</label>
                    <input type="text" class="form-control" id="staff_no" name="staff_no" placeholder="Staff Number" pattern="[A-Z]+[A-Z]+[0-9]{5,5}" title="2 or 3 capital letters followed by 5 numbers" minlength="7" maxlength="8">
                </div>
                <div class="form-group">
                    <label for="user_firstname">Firstname:</label>
                    <input type="text" class="form-control" id="user_firstname" name="user_firstname" placeholder="Firstname" pattern="[A-Za-z']+" title="alphabets and ' only">
                </div>
                <div class="form-group">
                    <label for="user_lastname">Lastname:</label>
                    <input type="text" class="form-control" id="user_lastname" name="user_lastname" placeholder="Lastname" pattern="[A-Za-z']+" title="alphabets and ' only">
                </div>
                <div class="form-group">
                
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" minlength="5">
                </div>
                <div class="form-group">
                    <label for="user_email">Email:</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Use the correct format -----@-----.---">
                </div>
                 <div id="hostel" style="visibility:hidden; position:absolute;" class="form-group">
                	<label for="user_hostel" id="user_hostel_label">Hostel:</label>
                    <select class="form-control" id="user_hostel" name="user_hostel">
                    	<option value="">Select Hostel:</option>
                        <option value="Nairobi">Nairobi</option>
                        <option value="Mombasa">Mombasa</option>
                        <option value="Eldoret">Eldoret</option>
                        <option value="Maringo">Maringo</option>
                        <option value="Ruwenzori">Ruwenzori</option>
                        <option value="Hollywood">Hollywood</option>
                        <option value="Buruburu">Buruburu</option>
                        <option value="Taifa">Taifa</option>
                        <option value="Uganda">Uganda</option>
                        <option value="Thornton">Thornton</option>
                        <option value="Barret">Barret</option>
                        <option value="Old Hall">Old Hall</option>
                        <option value="Amboseli">Amboseli</option>
                        <option value="Victoria">Victoria</option>
                        <option value="Elementaita">Elementaita</option>
                        <option value="Bogoria">Bogoria</option>
                        <option value="Tana">Tana</option>
                        <option value="Aberdares">Aberdares</option>
                        <option value="Turkana">Turkana</option>
                        <option value="Mau">Mau</option>
                        <option value="Naivasha">Naivasha</option>
                        <option value="Tsavo">Tsavo</option>
                        <option value="Mama Ngina">Mama Ngina</option>
                        <option value="River View">River View</option>
                    </select>
                </div>
                <div id="block" style="visibility:hidden; position:absolute;" class="form-group">
                    <label for="user_block" id="user_block_label">Block:</label>
                    <input type="text" class="form-control" id="user_block" name="user_block" placeholder="Block">
                </div>
                <div id="room_number" style="visibility:hidden; position:absolute;" class="form-group">
                    <label for="user_room_number" id="user_room_number_label">Room Number:</label>
                    <input type="number" class="form-control" id="user_room_number" name="user_room_number" placeholder="Room Number">
                </div>
                <h2>Notice!</h2>
                <p>The system will autogenerate a password that is same as the user Registration Number or Staff Number.</p>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='/admin/adminUI.jsp'">Cancel</button>
            </form>
				<!-- Form End-->
            <script>
            
            	function displayFunction() { 
            		
            		if (document.getElementById("user_role").value == "student"){
            			var registration_number = document.getElementById("registration_number");
            			var staff_number = document.getElementById("staff_number");
            			var hostel = document.getElementById("hostel");
            			var block = document.getElementById("block");
            			var room_number = document.getElementById("room_number");
            			
            			registration_number.style.visibility="visible";
            			registration_number.style.position="relative";
            			staff_number.style.visibility="hidden";
            			staff_number.style.position="absolute";
            			hostel.style.visibility="visible";
            			hostel.style.position="relative";
            			block.style.visibility="visible";
            			block.style.position="relative";
            			room_number.style.visibility="visible";
            			room_number.style.position="relative";
            			
            		}   else if (document.getElementById("user_role").value == "custodian"){
            			var registration_number = document.getElementById("registration_number");
            			var staff_number = document.getElementById("staff_number");
            			var hostel = document.getElementById("hostel");
            			var block = document.getElementById("block");
            			var room_number = document.getElementById("room_number");
            			
            			registration_number.style.visibility="hidden";
            			registration_number.style.position="absolute";
            			staff_number.style.visibility="visible";
            			staff_number.style.position="relative";
            			hostel.style.visibility="visible";
            			hostel.style.position="relative";
            			block.style.visibility="visible";
            			block.style.position="relative";
            			room_number.style.visibility="hidden";
            			room_number.style.position="absolute";
            			
            		} else if (document.getElementById("user_role").value == ""){
            			var registration_number = document.getElementById("registration_number");
            			var staff_number = document.getElementById("staff_number");
            			var hostel = document.getElementById("hostel");
            			var block = document.getElementById("block");
            			var room_number = document.getElementById("room_number");
            			
            			registration_number.style.visibility="hidden";
            			registration_number.style.position="absolute";
            			staff_number.style.visibility="hidden";
            			staff_number.style.position="absolute";
            			hostel.style.visibility="hidden";
            			hostel.style.position="absolute";
            			block.style.visibility="hidden";
            			block.style.position="absolute";
            			room_number.style.visibility="hidden";
            			room_number.style.position="absolute";
            			
            		} else if (document.getElementById("user_role").value != "student" && document.getElementById("user_role").value != "custodian" && document.getElementById("user_role").value != ""){
            			var registration_number = document.getElementById("registration_number");
            			var staff_number = document.getElementById("staff_number");
            			var hostel = document.getElementById("hostel");
            			var block = document.getElementById("block");
            			var room_number = document.getElementById("room_number");
            			
            			registration_number.style.visibility="hidden";
            			registration_number.style.position="absolute";
            			staff_number.style.visibility="visible";
            			staff_number.style.position="relative";
            			hostel.style.visibility="hidden";
            			hostel.style.position="absolute";
            			block.style.visibility="hidden";
            			block.style.position="absolute";
            			room_number.style.visibility="hidden";
            			room_number.style.position="absolute";
            			
            		} 
            			
            	}
            	
                function validateForm()                                    
                    { 
                		var user_role = document.getElementById("user_role");
//                		var reg_no = document.getElementById("reg_no");
//                		var staff_no = document.getElementById("staff_no");
                		var user_firstname = document.getElementById("user_firstname");             
                        var user_lastname = document.getElementById("user_lastname");
                        var username = document.getElementById("username");
                        var user_email = document.getElementById("user_email");
//                        var user_hostel = document.getElementById("user_hostel");
//                        var user_block = document.getElementById("user_block");
//                        var user_room_number = document.getElementById("user_room_number");
                        
                        
                        if (user_role.value == "")                                  
                        { 
                            window.alert("Please enter your User Role."); 
                            user_firstname.focus(); 
                            return false; 
                        } 
                        
//                        if (reg_no.value == "")                                  
//                        { 
//                            window.alert("Please enter your Registration Number."); 
//                            reg_no.focus(); 
//                            return false; 
//                        } 
//                        
//                        if (staff_no.value == "" && staff_no.style.display == "inline")                                  
//                        { 
//                            window.alert("Please enter your Staff Number."); 
//                            staff_no.focus(); 
//                            return false; 
//                        } 
                        
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
                 
//                        if (user_hostel.value == "" && user_hostel.style.display == "inline")                                  
//                        { 
//                            window.alert("Please enter your Hostel."); 
//                            user_hostel.focus(); 
//                            return false; 
//                        } 
//                        
//                        if (user_block.value == "" && user_block.style.display == "inline")                                  
//                        { 
//                            window.alert("Please enter your Block."); 
//                            user_block.focus(); 
//                            return false; 
//                        } 
//                        
//                        if (user_room_number.value == "" && user_room_number.style.display == "inline")                                  
//                        { 
//                            window.alert("Please enter your Room Number."); 
//                            user_room_number.focus(); 
//                            return false; 
//                        } 
                        
                        return true; 
                    }
	       </script>
		</div>
	</div>
<%@ include file="/admin/includes/admin_footer.jsp" %>