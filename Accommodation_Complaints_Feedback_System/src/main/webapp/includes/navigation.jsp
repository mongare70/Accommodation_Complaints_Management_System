<!-- Top navigation-->
 <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
     <div class="container-fluid">
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                 <li class="nav-item dropdown">
                 	<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
	    				<%=session.getAttribute("USER_FIRSTNAME")%>
	  				</a>
                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/profile.jsp">Profile</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/logout">Log Out</a>
                    </div>
                 </li>
             </ul>
         </div>
     </div>
 </nav>