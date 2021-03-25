<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/navigation.jsp"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
	
<div class="container-fluid bg">
		<div class="container">
			<!-- Form Start -->
            <form class="form-container" method="post" action="/update_user" name="user_profile" id="user_profile" onsubmit="return validateForm()">
                <h1>User Profile</h1>
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
						String sql ="SELECT * FROM users WHERE user_id = "+session.getAttribute("USER_ID");
					
						resultSet = statement.executeQuery(sql);
						while(resultSet.next()){
				%>
                <div class="form-group">
                	<label for="user_role">User Role:</label><br>
                    <input type="text" class="form-control" id="user_role" name="user_role" value="<%out.println(resultSet.getString("user_role")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="user_number" id="reg_no_label" style="visibility: hidden">Registration Number:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="reg_no" name="user_number" value="<%out.println(resultSet.getString("user_number")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="user_number" id="staff_no_label" style="visibility: hidden">Staff Number:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="staff_no" name="user_number" value="<%out.println(resultSet.getString("user_number")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="user_firstname">Firstname:</label>
                    <input type="text" class="form-control" id="user_firstname" name="user_firstname" placeholder="Firstname" pattern="[A-Za-z']+" title="alphabets and ' only" value="<%out.println(resultSet.getString("user_firstname")); %>" required>
                </div>
                <div class="form-group">
                    <label for="user_lastname">Lastname:</label>
                    <input type="text" class="form-control" id="user_lastname" name="user_lastname" placeholder="Lastname" pattern="[A-Za-z']+" title="alphabets and ' only" value="<%out.println(resultSet.getString("user_lastname")); %>" required>
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" minlength="5" value="<%out.println(resultSet.getString("username")); %>" required>
                </div>
                <div class="form-group">
                    <label for="user_email">Email:</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Use the correct format -----@-----.---" value="<%out.println(resultSet.getString("user_email")); %>" required>
                </div>
                 <div class="form-group">
                	<label for="user_hostel" id="user_hostel_label" style="visibility: hidden">Hostel:</label>
                    <select class="form-control" style="visibility: hidden" id="user_hostel" name="user_hostel">
                    	<option><%out.println(resultSet.getString("user_hostel")); %></option>
                        <option>Nairobi</option>
                        <option>Mombasa</option>
                        <option>Eldoret</option>
                        <option>Maringo</option>
                        <option>Ruwenzori</option>
                        <option>Hollywood</option>
                        <option>Buruburu</option>
                        <option>Taifa</option>
                        <option>Uganda</option>
                        <option>Thornton</option>
                        <option>Barret</option>
                        <option>Old Hall</option>
                        <option>Amboseli</option>
                        <option>Victoria</option>
                        <option>Elementaita</option>
                        <option>Bogoria</option>
                        <option>Tana</option>
                        <option>Aberdares</option>
                        <option>Turkana</option>
                        <option>Mau</option>
                        <option>Naivasha</option>
                        <option>Tsavo</option>
                        <option>Mama Ngina</option>
                        <option>River View</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="user_block" id="user_block_label" style="visibility: hidden">Block:</label>
                    <input type="text" style="visibility: hidden" class="form-control" id="user_block" name="user_block" placeholder="Block" value="<%out.println(resultSet.getString("user_block")); %>">
                </div>
                <div class="form-group">
                    <label for="user_room_number" id="user_room_number_label" style="visibility: hidden">Room Number:</label>
                    <input type="text" style="visibility: hidden" pattern="[0-9]+" title="please enter number only" class="form-control" id="user_room_number" name="user_room_number" placeholder="Room Number" value="<%out.println(resultSet.getInt("user_room_number")); %>">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" minlength="6" value="<%out.println(resultSet.getString("password")); %>">
                </div>
                
                <input type="hidden" id="user_id" name="user_id" value="<%=session.getAttribute("USER_ID")%>">
                
                  <button type="submit" class="btn btn-success btn-block">Update</button>
                <br>
            </form>
				<!-- Form End-->
<%
   }

   } catch (Exception e) {
   e.printStackTrace();
   }
%>
            <script>
            	window.onload = function displayFunction() { 
            		
            		if (document.getElementById("user_role").value == "student"){
            			var reg_no_label = document.getElementById("reg_no_label");
            			var reg_no = document.getElementById("reg_no");
            			var staff_no = document.getElementById("staff_no");
            			var staff_no_label = document.getElementById("staff_no_label");
            			var hostel_label = document.getElementById("user_hostel_label");
                		var hostel = document.getElementById("user_hostel");
                		var block_label = document.getElementById("user_block_label");
                		var block = document.getElementById("user_block");
                		var roomNumberLabel = document.getElementById("user_room_number_label");
                		var roomNumber = document.getElementById("user_room_number");
                		
                		staff_no.style.visibility = "hidden";
                		staff_no_label.style.visibility = "hidden";
                		reg_no.style.visibility = "visible";
                		reg_no_label.style.visibility = "visible";
                		hostel_label.style.visibility = "visible";
                		hostel.style.visibility = "visible";
                		block_label.style.visibility = "visible";
                		block.style.visibility = "visible";
                		roomNumberLabel.style.visibility = "visible";
                		roomNumber.style.visibility = "visible";
                		
                	} else if (document.getElementById("user_role").value != "student" && document.getElementById("user_role").value != "custodian") {
                		var reg_no_label = document.getElementById("reg_no_label");
                		var reg_no = document.getElementById("reg_no");
                		var staff_no = document.getElementById("staff_no");
                		var staff_no_label = document.getElementById("staff_no_label");
                		var hostel_label = document.getElementById("user_hostel_label");
                		var hostel = document.getElementById("user_hostel");
                		var block_label = document.getElementById("user_block_label");
                		var block = document.getElementById("user_block");
                		var roomNumberLabel = document.getElementById("user_room_number_label");
                		var roomNumber = document.getElementById("user_room_number");
                		
                		reg_no_label.style.visibility = "hidden";
                		reg_no.style.visibility = "hidden";
                		staff_no_label.style.visibility = "visible";
                		staff_no.style.visibility = "visible";
                		hostel_label.style.visibility = "hidden";
                		hostel.style.visibility = "hidden";
                		block_label.style.visibility = "hidden";
                		block.style.visibility = "hidden";
                		roomNumberLabel.style.visibility = "hidden";
                		roomNumber.style.visibility = "hidden";
                		
                	} else if (document.getElementById("user_role").value == "custodian") {
                		var reg_no = document.getElementById("reg_no");
                		var reg_no_label = document.getElementById("reg_no_label");
                		var staff_no = document.getElementById("staff_no");
                		var staff_no_label = document.getElementById("staff_no_label");
                		var hostel_label = document.getElementById("user_hostel_label");
                		var hostel = document.getElementById("user_hostel");
                		var block_label = document.getElementById("user_block_label");
                		var block = document.getElementById("user_block");
                		var roomNumberLabel = document.getElementById("user_room_number_label");
                		var roomNumber = document.getElementById("user_room_number");
                		
                		reg_no_label.style.visibility = "hidden";
                		reg_no.style.visibility = "hidden";
                		staff_no_label.style.visibility = "visible";
                		staff_no.style.visibility = "visible";
                		hostel_label.style.visibility = "visible";
                		hostel.style.visibility = "visible";
                		block_label.style.visibility = "visible";
                		block.style.visibility = "visible";
                		roomNumberLabel.style.visibility = "hidden";
                		roomNumber.style.visibility = "hidden";
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
	       </script>
		</div>
	</div>
<%@ include file="/includes/footer.jsp"%>