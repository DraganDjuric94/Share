<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" type="org.unibl.etf.bean.UserBean" scope="session"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="../templates/include.jsp" />
		<link href="resources/css/index.css" rel='stylesheet' type='text/css' />
		<title>Share: Register</title>
	</head>
	<body>
	
		<div class="container-fluid" style="height: 100vh">
		<div class="row full_height">
		
			<div class="col-lg-6 justify-content-center align-self-center">
				<h4 style="text-align: center;">To register, please fill the following form</h4>
				<br>
				<form action="Controller?action=register" method="post" class="login_form">
				  <div class="form-group">
				    <label for="first_name">First name</label>
				    <input type="text" class="form-control" name="first_name" id="first_name"placeholder="Enter your first name">
				  </div>
				  <div class="form-group">
				    <label for="last_name">Last name</label>
				    <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Enter your last name">
				  </div>
				  <div class="form-group">
				    <label for="username">Username</label>
				    <input type="text" class="form-control" name="username" id="username" placeholder="Enter your username">
				  </div>
				  <div class="form-group">
				    <label for="password">Password</label>
				    <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password">
				  </div>
				  <div class="form-group">
				    <label for="password_repeated">Repeat password</label>
				    <input type="password" class="form-control" name="password_repeated" id="password_repeated" placeholder="Reenter your password">
				  </div>
				  <div class="form-group">
				    <label for="email">Email address</label>
				    <input type="email" class="form-control" name="email" id="email" placeholder="Enter your email">
				  </div>
				  <button type="submit" class="btn btn-primary">Register</button>
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