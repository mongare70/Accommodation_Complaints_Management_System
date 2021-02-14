<%@ include file="/admin/includes/admin_header.jsp" %>
<%@ include file="/admin/includes/admin_navigation.jsp" %>
	<div class="container-fluid bg">
		<div class="container">
		<h2>Welcome ${admin.fname}</h2> 	         
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='studentRegistration.jsp'">Register Student</button>
            
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='hallsOfficerRegistration.jsp'">Register Halls Officer</button>
            
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='custodianRegistration.jsp'">Register Custodian</button>
            
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='masonRegistration.jsp'">Register Mason</button>
            
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='carpenterRegistration.jsp'">Register Carpenter</button>
           
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='securityRegistration.jsp'">Register Security</button>
            
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='plumberRegistration.jsp'">Register Plumber</button>
    
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='electricianRegistration.jsp'">Register Electrician</button>
                
            <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='/'">Log Out</button>
		</div>
	</div>
<%@ include file="/admin/includes/admin_footer.jsp" %>