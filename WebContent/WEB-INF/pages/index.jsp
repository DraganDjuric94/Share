<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="../templates/include.jsp" />
		<link href="resources/css/index.css" rel='stylesheet' type='text/css' />
		<title>Welcome to Share</title>
	</head>
	<body>
	
		<div class="container-fluid" style="height: 100vh">
		<div class="row full_height">
		
			<div class="col-lg-6 justify-content-center align-self-center">
				<h3 style="text-align: center;">Welcome to Share!</h3>
				<br>
				<form action="Controller?action=login" method="post" class="login_form">
				  <div class="form-group">
				    <label for="email_field">Email address</label>
				    <input type="email" class="form-control" name="email" id="email_field" aria-describedby="emailHelp" placeholder="Enter email">
				  </div>
				  <div class="form-group">
				    <label for="password_field">Password</label>
				    <input type="password" class="form-control" name="password" id="password_field" placeholder="Enter password">
				  </div>
				  <div class="register_box">
				  	<p>Don't have an account?</p>
				  	<a href="Controller?action=register" style="padding-left: 5px;">Register</a>
				  </div>
				  <button type="submit" class="btn btn-primary">Log in</button>
				</form>
			</div>
			<div class="col-lg-6 description_box">
				<div class="row" style="height: 100%">
					<div class="col-lg-4"></div>
					<div class="col-lg-8 col-12 justify-content-center align-self-center">
						<h5 class="description_text">Connect with friends.</h5>
						<h5 class="description_text">Share your thoughts.</h5>
						<h5 class="description_text">Access learning materials.</h5>
						<h5 class="description_text">Explore events and news.</h5>
					</div>
				</div>
			</div>
		
		</div>
		</div>
	
	
	</body>
</html>