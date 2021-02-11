<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>login</title>
  </head>
  <body>
      
    <div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
				<!-- Form Start -->
            <form class="form-container" method="post" action="/login" name="login_form" id="login_form" onsubmit="return validateForm()">
                <h1>Login Form</h1>
                <div class="form-group">
                    <label for="category">Category:</label>
                    <select class="form-control" id="category" name="category">
                        <option>Admin</option>
                        <option>Student</option>
                        <option>Halls Officer</option>
                        <option>Custodian</option>
                        <option>Mason</option>
                        <option>Carpenter</option>
                        <option>Security</option>
                        <option>Plumber</option>
                        <option>Electrician</option>
                    </select>
                </div>
                  <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" name="uname" id="uname" placeholder="Username">
                  </div>
                  <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
            </form>
				<!-- Form End-->
		</div>
	</div>
	
	<script type="text/javascript">
	 function validateForm()                                    
     { 
         var uname = document.forms["login_form"]["uname"];               
         var password = document.forms["login_form"]["password"];
        
         if (uname.value == "")                                  
         { 
             window.alert("Please enter your Username."); 
             uname.focus(); 
             return false; 
         } 

         if (password.value == "")                                  
         { 
             window.alert("Please enter your Password."); 
             password.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>