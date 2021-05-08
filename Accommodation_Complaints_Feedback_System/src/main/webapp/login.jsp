<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/navigation.jsp"%>

<div class="container">
	<h1 style="text-align: center;">Accommodation Complaints
		Management System</h1>
	<!-- Form Start -->
	<br>
	<form class="form" method="post" action="/login"
		name="login_form" id="login_form" autocomplete="off" onsubmit="return validateForm()">

		<div class="form-group">
			<label for="category">User Role:</label> <select class="form-control"
				id="user_role" name="user_role">
				<option value="admin">Admin</option>
				<option value="student">Student</option>
				<option value="halls_officer">Halls Officer</option>
				<option value="custodian">Custodian</option>
				<option value="mason">Mason</option>
				<option value="carpenter">Carpenter</option>
				<option value="security">Security</option>
				<option value="plumber">Plumber</option>
				<option value="electrician">Electrician</option>
				<option value="cleaner">Cleaner</option>
				<option value="health">Health</option>
				<option value="painter">Painter</option>
			</select>
		</div>
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" name="username" id="username" placeholder="Username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" name="password" id="password" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-success btn-block">Login</button>
	</form>
	<!-- Form End-->
</div>

<script type="text/javascript">
	function validateForm() {
		var uname = document.forms["login_form"]["uname"];
		var password = document.forms["login_form"]["password"];

		if (uname.value == "") {
			window.alert("Please enter your Username.");
			uname.focus();
			return false;
		}

		if (password.value == "") {
			window.alert("Please enter your Password.");
			password.focus();
			return false;
		}

		return true;
	}
</script>
<%@ include file="/includes/footer.jsp"%>