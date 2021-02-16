<%@ include file="/admin/includes/admin_header.jsp" %>
<%@ include file="/admin/includes/admin_navigation.jsp" %>
	<div class="container-fluid bg">
		<div class="container">
			<h1>Welcome <%=session.getAttribute("USER_FIRSTNAME")%></h1>	         
            <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='/admin/register_admin.jsp'">Register New Admin</button>
		</div>
	</div>
<%@ include file="/admin/includes/admin_footer.jsp" %>