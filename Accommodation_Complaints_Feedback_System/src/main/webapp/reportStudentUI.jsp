<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/navigation.jsp"%>
<%
if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("custodian")) {
%>
<div class="container-fluid bg">
<br>
	<button type="button" class="btn btn-primary btn-lg"
		onClick="window.location.href='/users.jsp'">Back</button>

	<div class="container">
		<div class="forms">
		<!-- Form Start -->
		<form class="form-container" method="post" action="/reportStudent"
			id="reportForm" name="reportForm" onsubmit="return formValidate()">
			<h1>Report Student Form</h1>
			<div class="form-group">
				<label for="student_id">Student ID:</label> <input type="number"
					class="form-control" value="${userId}" id="student_id"
					name="student_id" readonly>
			</div>
			<div class="form-group">
				<label for="report_title">Report Title:</label> <input type="text"
					class="form-control" id="report_title" name="report_title"
					placeholder="Report Title">
			</div>
			<div class="form-group">
				<label for="report_content">Report Content:</label>
				<textarea rows="5" cols="50" class="form-control"
					id="report_content" name="report_content"
					placeholder="Report Content"></textarea>
			</div>

			<input type="hidden" id="report_author_id" name="report_author_id"
				value="<%=session.getAttribute("USER_ID")%>">

			<button type="submit" class="btn btn-success btn-block">Submit</button>
		</form>
		<!-- Form End-->
		</div>
	</div>
</div>
<script type="text/javascript">
	function formValidate() {
		var student_id = document.forms["reportForm"]["student_id"];
		var report_title = document.forms["reportForm"]["report_title"];
		var report_content = document.forms["reportForm"]["report_content"];

		if (student_id.value == "") {
			window.alert("Please enter the Student ID.");
			student_id.focus();
			return false;
		}

		if (report_title.value == "") {
			window.alert("Please enter the Report Title.");
			report_title.focus();
			return false;
		}

		if (report_content.value == "") {
			window.alert("Please enter the Report Description.");
			report_content.focus();
			return false;
		}

		return true;
	}
</script>
<%
} else {
%>
<h1>You need to login as Custodian first to access this page</h1>
<%
}
%>
<%@ include file="/includes/footer.jsp"%>