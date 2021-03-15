<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin/adminUI.jsp">ACFS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/admin/adminUI.jsp">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Users
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="/admin/students.jsp">Students</a></li>
	        <li><a class="dropdown-item" href="/admin/halls_officers.jsp">Halls Officers</a></li>
	        <li><a class="dropdown-item" href="/admin/custodians.jsp">Custodians</a></li>
	        <li><a class="dropdown-item" href="/admin/masons.jsp">Masons</a></li>
	        <li><a class="dropdown-item" href="/admin/carpenters.jsp">Carpenters</a></li>
	        <li><a class="dropdown-item" href="/admin/electricians.jsp">Electricians</a></li>
	        <li><a class="dropdown-item" href="/admin/securitys.jsp">Security</a></li>
	        <li><a class="dropdown-item" href="/admin/plumbers.jsp">Plumbers</a></li>
	        <li><a class="dropdown-item" href="/admin/admins.jsp">Admins</a></li>
	        <li><a class="dropdown-item" href="/admin/painters.jsp">Painters</a></li>
	        <li><a class="dropdown-item" href="/admin/health.jsp">Health Staff</a></li>
	        <li><a class="dropdown-item" href="/admin/cleaners.jsp">Cleaners</a></li>
	        <li><a class="dropdown-item" href="/admin/users.jsp">All Users</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Complaints
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          	<li><a class="dropdown-item" href="/admin/doneComplaints.jsp">Done Complaints</a></li>
          	<li><a class="dropdown-item" href="/admin/rejectedComplaints.jsp">Rejected Complaints</a></li>
	      	<li><a class="dropdown-item" href="/admin/complaints.jsp">All Complaints</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link default" aria-current="page" href="/admin/reports.jsp">Reports</a>
        </li>
      </ul>
    </div>
    <div class="dropdown">
	  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
	   	<%=session.getAttribute("USER_FIRSTNAME")%>
	  </a>
	
	  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
	    <li><a class="dropdown-item" href="#">Profile</a></li>
	    <li><a class="dropdown-item" href="/logout">Log Out</a></li>
	  </ul>
	</div>
  </div>
</nav>