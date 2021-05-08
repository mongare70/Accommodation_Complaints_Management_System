<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/navigation.jsp" %>
<% if(session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("custodian")){ %>		
<div class="container-fluid bg">
	<button type="button" class="btn btn-primary btn-lg" onClick="window.location.href='/users.jsp'">Back</button>
    <br>
     		<%@ include file="/admin/includes/db.jsp" %>

			<table class="table table-bordered table-hover">

			<tr>
				<td>Report ID</td>
				<td>Report Author: (ID)</td>
				<td>Report Title</td>
				<td>Report Content</td>
				<td>Reported Student: (ID)</td>
				<td>Delete</td>
    		</tr>


			<%
			try{
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM reports WHERE report_author_id = "+ session.getAttribute("USER_ID") +" ORDER BY report_id DESC";

			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
			%>
			<tr>
				<td><%out.println(resultSet.getString("report_id")); %></td>
				<td><%out.println(resultSet.getString("report_author_id")); %></td>
		    	<td><%out.println(resultSet.getString("report_title")); %></td>
		    	<td><%out.println(resultSet.getString("report_content")); %></td>
		    	<td><%out.println(resultSet.getString("student_id")); %></td>
		    	<td><a href='reports.jsp/delete/<%out.println(resultSet.getString("report_id")); %>'>Delete</a></td>
			</tr>

			<%
		    }

		    } catch (Exception e) {
		    e.printStackTrace();
		    }
			%>
			</table>
</div>
<% } else { %>
<h1>You need to login as Custodian first to access this page</h1>
<% } %>
<%@ include file="/includes/footer.jsp" %>