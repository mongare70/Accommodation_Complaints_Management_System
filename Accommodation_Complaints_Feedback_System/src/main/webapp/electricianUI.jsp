<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Electrician UI</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
 <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='login.jsp'">Log Out</button>
 <br>

<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
            <div class="col-md-2 col-sm-4 col-xs-12"></div>

            <%@page import="java.sql.DriverManager"%>
			<%@page import="java.sql.ResultSet"%>
			<%@page import="java.sql.Statement"%>
			<%@page import="java.sql.Connection"%>

			<%

			String driverName = "com.mysql.cj.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost:3306/accommodation_complaints_feedback_system";
			String userId = "root";
			String password = "";

			try {
			Class.forName(driverName);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}

			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			%>

			<h2 align="center"><font><strong>Welcome ${electrician.fname} Here are the Complaints:</strong></font></h2>
			<table id="complaints" align="center" cellpadding="5" cellspacing="5" border="1">

			<tr>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Registration Number</b></td>
			<td><b>Hostel</b></td>
			<td><b>Block</b></td>
			<td><b>Room Number</b></td>
			<td><b>Complaint Title</b></td>
			<td><b>Complaint Description</b></td>
			<td><b>Done</b></td>
			
			</tr>
			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM electricians_complaints";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>

			<td><%out.println(resultSet.getString("fname")); %></td>
		    <td><%out.println(resultSet.getString("lname")); %></td>
		    <td><%out.println(resultSet.getString("reg_no")); %></td>
		    <td><%out.println(resultSet.getString("hostel")); %></td>
		    <td><%out.println(resultSet.getString("block")); %></td>
		    <td><%out.println(resultSet.getString("room_number")); %></td>
		    <td><%out.println(resultSet.getString("complaint_title")); %></td>
		    <td><%out.println(resultSet.getString("complaint_description")); %></td>
		    <td>
		    <form id="done_complaint_form" name="done_complaint_form" method="post" enctype="form-data" action="/electriciansDoneComplaint">

		    <button type="submit" class="btn btn-success">Done</button>

		    <input type="hidden" id="ecid" name="ecid" value="<%=resultSet.getString("ecid")%>">
		    <input type="hidden" id="fname" name="fname" value="<%=resultSet.getString("fname")%>">
            <input type="hidden" id="lname" name="lname" value="<%=resultSet.getString("lname")%>">
            <input type="hidden" id="regNo" name="regNo" value="<%=resultSet.getString("reg_no")%>">
            <input type="hidden" id="hostel" name="hostel" value="<%=resultSet.getString("hostel")%>">
            <input type="hidden" id="block" name="block" value="<%=resultSet.getString("block")%>">
            <input type="hidden" id="roomNumber" name="roomNumber" value="<%=resultSet.getString("room_number")%>">
            <input type="hidden" id="complaintTitle" name="complaintTitle" value="<%=resultSet.getString("complaint_title")%>">
            <input type="hidden" id="complaintDescription" name="complaintDescription" value="<%=resultSet.getString("complaint_description")%>">

			
		</form>
		    
	</td>
	</tr>
			<%
			}

			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
			</table>

            <div class="lead" onmessage="${message}"></div>

		</div>
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
	</div>
</body>
</html>
