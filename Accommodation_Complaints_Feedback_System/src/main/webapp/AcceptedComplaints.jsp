<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Accepted Complaints</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

		<button type="button" class="btn btn-success btn-block" onClick="window.location.href='StatusUI.jsp'">Back</button>
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
			String password = "1234";

			try {
			Class.forName(driverName);
			}catch (ClassNotFoundException e) {
			e.printStackTrace();
			}

			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			%>

			<h2 align="center"><font><strong>Welcome Here are the Accepted Complaints:</strong></font></h2>
			<table id="donecomplaints" align="center" cellpadding="5" cellspacing="5" border="1">

			<tr>
			<td><b>Accepted Complaint Id</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Registration Number</b></td>
			<td><b>Hostel</b></td>
			<td><b>Block</b></td>
			<td><b>Room Number</b></td>
			<td><b>Complaint Title</b></td>
			<td><b>Complaint Description</b></td>
    </tr>


			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM accepted_complaints";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>

			<td><%out.println(resultSet.getString("acid")); %></td>
			<td><%out.println(resultSet.getString("fname")); %></td>
		    <td><%out.println(resultSet.getString("lname")); %></td>
		    <td><%out.println(resultSet.getString("reg_no")); %></td>
		    <td><%out.println(resultSet.getString("hostel")); %></td>
		    <td><%out.println(resultSet.getString("block")); %></td>
		    <td><%out.println(resultSet.getString("room_number")); %></td>
		    <td><%out.println(resultSet.getString("complaint_title")); %></td>
		    <td><%out.println(resultSet.getString("complaint_description")); %></td>

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
