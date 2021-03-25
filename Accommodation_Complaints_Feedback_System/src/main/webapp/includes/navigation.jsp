<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">ACMS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/">Home</a>
        <a class="nav-link" href="/includes/about.jsp">About</a>
        <a class="nav-link" href="/includes/contact.jsp">Contact</a>
      </div>
    </div>
    <% 
    	if (session.getAttribute("USER_FIRSTNAME") != null) { 
    %>
    <div class="dropdown">
	  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
	    <%=session.getAttribute("USER_FIRSTNAME")%>
	  </a>
	
	  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
	    <li><a class="dropdown-item" href="/profile.jsp">Profile</a></li>
	    <li><a class="dropdown-item" href="/logout">Log Out</a></li>
	  </ul>
	</div>
	<% } %>
  </div>  
</nav>