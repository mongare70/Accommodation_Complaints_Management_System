<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/navigation.jsp"%>
<%
if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("student")) {
%>
<div class="container-fluid bg">
	<div class="studentUI">
		<br>
		<h1 style="text-align: center;">
			Welcome
			<%=session.getAttribute("USER_FIRSTNAME")%></h1>
		<!-- Form Start -->
		<form class="form-container" method="post" action="/submitComplaint"
			id="complaintForm" name="complaintForm"
			onsubmit="return formValidate()">
			<button type="button" class="btn btn-dark btn-block"
				onClick="window.location.href='statusUI.jsp'">
				Click Here To See
				<%=session.getAttribute("USER_FIRSTNAME")%>'s Complaint Status
			</button>
			<br>
			<h1 style="text-align: center; color: green;">Complaint Form</h1>
			<br>
			<div class="form-group">
				<label for="complaint_category">Complaint Category:</label> <select
					name="complaint_category" id="complaint_category">
					<!-- Default -->
					<option value="None">Select Options</option>

					<option value="others">Others</option>
					<option value="mason">Masonry</option>
					<option value="plumber">Plumbing</option>
					<option value="carpenter">Carpentry</option>
					<option value="security">Security</option>
					<option value="electrician">Electrical</option>
					<option value="health">Health</option>
					<option value="painter">Painting</option>
					<option value="cleaner">Cleaning</option>
					<option value="custodian">Custodian Related</option>
				</select>
			</div>
			<div class="form-group">
				<label for="complaint_content">Complaint Content:</label>
				<textarea rows="5" cols="50" class="form-control"
					id="complaint_content" name="complaint_content"
					placeholder="Complaint Content"></textarea>
			</div>


			<input type="hidden" id="complaint_author_id"
				name="complaint_author_id"
				value="<%=session.getAttribute("USER_ID")%>">

			<%@ include file="/admin/includes/db.jsp"%>

			<%
			try {
				connection = DriverManager.getConnection(connectionUrl, userId, password);
				statement = connection.createStatement();
				String sql = "SELECT * FROM users WHERE user_id = " + session.getAttribute("USER_ID");

				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>

			<input type="hidden" id="complaint_hostel" name="complaint_hostel"
				value="<%out.println(resultSet.getString("user_hostel"));%>">
			<input type="hidden" id="complaint_block" name="complaint_block"
				value="<%out.println(resultSet.getString("user_block"));%>">
			<input type="hidden" id="complaint_room_number"
				name="complaint_room_number"
				value="<%out.println(resultSet.getInt("user_room_number"));%>">

			<%
			}

			} catch (Exception e) {
			e.printStackTrace();
			}
			%>

			<button type="submit" class="btn btn-success btn-block">Submit</button>
		</form>
		<!-- Form End-->
	</div>
</div>
<script type="text/javascript">
	function formValidate() {
		var complaint_content = document.forms["complaintForm"]["complaint_content"];

		if (complaint_content.value == "") {
			window.alert("Please enter the Complaint Description.");
			complaint_content.focus();
			return false;
		}

		return true;
	}
</script>
<%
} else {
%>
<h1>You need to login as Student first to access this page</h1>
<%
}
%>
<%@ include file="/includes/footer.jsp"%>