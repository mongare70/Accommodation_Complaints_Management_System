<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Welcome Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/welcome.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
            <br>
                <h1>Welcome ${admin.fname}</h1>    
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='studentRegistration.jsp'">Register Student</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='hallsOfficerRegistration.jsp'">Register Halls Officer</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='custodianRegistration.jsp'">Register Custodian</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='masonRegistration.jsp'">Register Mason</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='carpenterRegistration.jsp'">Register Carpenter</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='securityRegistration.jsp'">Register Security</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='plumberRegistration.jsp'">Register Plumber</button>
            <br>
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='electricianRegistration.jsp'">Register Electrician</button>
                
                  <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='login.jsp'">Log Out</button>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-12"></div>
	</div>
</body>
</html>