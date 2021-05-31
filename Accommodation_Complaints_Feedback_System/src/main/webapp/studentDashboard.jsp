<%@ include file="/includes/header.jsp"%>
<div class="d-flex" id="wrapper">
		
            <!-- Sidebar-->
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="sidebar-heading border-bottom bg-light">ACMS</div>
			    <div class="list-group list-group-flush">
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/studentDashboard.jsp">Dashboard</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/studentUI.jsp"> Submit Complaint</a>
			        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="statusUI.jsp"> Complaint Status</a>
			    </div>
			</div>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
            	<!-- Navbar -->
               	<%@ include file="/includes/navigation.jsp"%>
               
               	<%
					if (session.getAttribute("USER_ID") != null && session.getAttribute("USER_ROLE").equals("student")) {
				%>
               
                <!-- Page content-->
                <div class="container-fluid bg">
                	<br>
                	<!-- Page Heading -->
	                <div class="row">
	                    <div class="col-lg-12">
	                        <h1 class="page-header">
	                            Welcome
	                            <small><%=session.getAttribute("USER_FIRSTNAME")%></small>
	                            
	                        </h1>
	                        
	                    </div>
	                </div>
	                <!-- /.row -->	
                	
                </div>
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