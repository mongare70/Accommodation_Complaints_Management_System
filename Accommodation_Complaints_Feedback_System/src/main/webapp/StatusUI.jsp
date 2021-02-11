<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Status UI</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>


</head>
<body>
	<h2 align="center"><font><strong>Welcome Here is the Complaints Status:</strong></font></h2>

  <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='login.jsp'">Log Out</button>
  <br>
   <button type="button" class="btn btn-success btn-block" onClick="window.location.href='studentUI.jsp'">Back</button>
  <br>

<div>
   <ul>
     <li><a href="DoneComplaints.jsp" target="_parent">Done Complaints</a></li>
     <li><a href="AcceptedComplaints.jsp" target="_parent">Accepted Complaints</a></li>
     <li><a href="RejectedComplaints.jsp" target="_parent">Rejected Complaints</a></li>
   </ul>
</div>
 </body>
 </html>
