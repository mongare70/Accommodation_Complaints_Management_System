<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/navigation.jsp"%>

	
<div class="container-fluid bg">
		<div class="forms">
			<!-- Form Start -->
            <form class="form-container" method="post" action="/update_user" name="user_profile" id="user_profile" onsubmit="return validateForm()">
                <h1>User Profile</h1>
                
                <%@ include file="/admin/includes/db.jsp" %>
                
                <%
					
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
                <div id="registration_number" class="form-group">
                    <label for="user_number" id="reg_no_label">Registration Number:</label>
                    <input type="text" class="form-control" id="reg_no" name="user_number" value="<%out.println(resultSet.getString("user_number")); %>" readonly>
                </div>
                <div id="staff_number" class="form-group">
                    <label for="user_number" id="staff_no_label">Staff Number:</label>
                    <input type="text" class="form-control" id="staff_no" name="user_number" value="<%out.println(resultSet.getString("user_number")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="user_firstname">Firstname:</label>
                    <input type="text" class="form-control" id="user_firstname" name="user_firstname" placeholder="Firstname" pattern="[A-Za-z']+" title="alphabets and ' only" value="<%out.println(resultSet.getString("user_firstname")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="user_lastname">Lastname:</label>
                    <input type="text" class="form-control" id="user_lastname" name="user_lastname" placeholder="Lastname" pattern="[A-Za-z']+" title="alphabets and ' only" value="<%out.println(resultSet.getString("user_lastname")); %>" readonly>
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" minlength="5" value="<%out.println(resultSet.getString("username")); %>">
                </div>
                <div class="form-group">
                    <label for="user_email">Email:</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Use the correct format -----@-----.---" value="<%out.println(resultSet.getString("user_email")); %>">
                </div>
                 <div id="hostel" class="form-group">
                	<label for="user_hostel" id="user_hostel_label">Hostel:</label>
                    <select class="form-control" id="user_hostel" name="user_hostel">
                    	<option><%out.println(resultSet.getString("user_hostel")); %></option>
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
                <div id="block" class="form-group">
                    <label for="user_block" id="user_block_label">Block:</label>
                    <input type="text" class="form-control" id="user_block" name="user_block" placeholder="Block" value="<%out.println(resultSet.getString("user_block")); %>">
                </div>
                <div id="room_number" class="form-group">
                    <label for="user_room_number" id="user_room_number_label">Room Number:</label>
                    <input type="text" pattern="[0-9]+" title="please enter number only" class="form-control" id="user_room_number" name="user_room_number" placeholder="Room Number" value="<%out.println(resultSet.getInt("user_room_number")); %>">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" minlength="6" value="<%out.println(resultSet.getString("password")); %>">
                </div>
                
                <input type="hidden" id="user_id" name="user_id" value="<%=session.getAttribute("USER_ID")%>">
                
                  <button type="submit" class="btn btn-success btn-block">Update</button>
                <br>
                <% String user_role = resultSet.getString("user_role");
                if( user_role.equals("student")){
                	%>
                	 <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/studentUI.jsp'">Go to the Student Homepage</button>
                	<%
                } else if (user_role.equals("halls_officer")){
                	 %>
                <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/hallsOfficerUI.jsp'">Go to the Halls Officer Homepage</button>
                <%
                } else if (user_role.equals("custodian")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/custodianUI.jsp'">Go to the Custodian Homepage</button>
                <%
                } else if (user_role.equals("plumber")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/plumberUI.jsp'">Go to the Plumber Homepage</button>
                <%
                } else if (user_role.equals("mason")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/masonUI.jsp'">Go to the Mason Homepage</button>
                <%
                } else if (user_role.equals("carpenter")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/carpenterUI.jsp'">Go to the Carpenter Homepage</button>
                <%
                } else if (user_role.equals("electrician")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/electricianUI.jsp'">Go to the Electrician Homepage</button>
                <%
                } else if (user_role.equals("security")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/securityUI.jsp'">Go to the Security Homepage</button>
                <%
                } else if (user_role.equals("cleaner")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/cleanerUI.jsp'">Go to the Cleaner Homepage</button>
                <%
                } else if (user_role.equals("health")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/healthUI.jsp'">Go to the Health Officer Homepage</button>
                <%
                } else if (user_role.equals("painter")){
               	 %>
               <button type="button" class="btn btn-primary btn-block" onClick="window.location.href='/painterUI.jsp'">Go to the Painter Homepage</button>
                <%
                }
                %>
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
//            		var reg_no = document.getElementById("reg_no");
//            		var staff_no = document.getElementById("staff_no");
            		var user_firstname = document.getElementById("user_firstname");             
                    var user_lastname = document.getElementById("user_lastname");
                    var username = document.getElementById("username");
                    var user_email = document.getElementById("user_email");
//                    var user_hostel = document.getElementById("user_hostel");
//                    var user_block = document.getElementById("user_block");
//                    var user_room_number = document.getElementById("user_room_number");
                    
                    
                    if (user_role.value == "")                                  
                    { 
                        window.alert("Please enter your User Role."); 
                        user_firstname.focus(); 
                        return false; 
                    } 
                    
//                    if (reg_no.value == "")                                  
//                    { 
//                        window.alert("Please enter your Registration Number."); 
//                        reg_no.focus(); 
//                        return false; 
//                    } 
//                    
//                    if (staff_no.value == "" && staff_no.style.display == "inline")                                  
//                    { 
//                        window.alert("Please enter your Staff Number."); 
//                        staff_no.focus(); 
//                        return false; 
//                    } 
                    
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
             
//                    if (user_hostel.value == "" && user_hostel.style.display == "inline")                                  
//                    { 
//                        window.alert("Please enter your Hostel."); 
//                        user_hostel.focus(); 
//                        return false; 
//                    } 
//                    
//                    if (user_block.value == "" && user_block.style.display == "inline")                                  
//                    { 
//                        window.alert("Please enter your Block."); 
//                        user_block.focus(); 
//                        return false; 
//                    } 
//                    
//                    if (user_room_number.value == "" && user_room_number.style.display == "inline")                                  
//                    { 
//                        window.alert("Please enter your Room Number."); 
//                        user_room_number.focus(); 
//                        return false; 
//                    } 
                    
                    return true; 
                }
	       </script>
		</div>
	</div>
<%@ include file="/includes/footer.jsp"%>