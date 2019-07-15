<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" type="org.unibl.etf.bean.UserBean" scope="session"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="../templates/include.jsp" />
		<link href="resources/css/edit_profile.css" rel='stylesheet' type='text/css' />
		<title>Share: Edit profile</title>
	</head>
	
	<body>
		
		<form class="container" style="padding: 5%;" action="Controller?action=edit_profile" method="post">
			<div class="row">
			
				<div class="col-lg-4 justify-content-center align-self-center">
				
					<div class="profile_picture">
						<img class="profile_image" src="">
					</div>
					
				</div>
				
				<div class="col-lg-8 basic_info">
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
				    <label for="email">Email</label>
				    <input type="email" class="form-control" name="email" id="email" placeholder="Enter your email address">
				  </div>
				</div>
			
			</div>
			
			<div class="row">
				<div class="col-lg-5">
					<div class="form-group">
				    <label for="faculty">Faculty</label>
				    <select class="custom-select" id="faculty">
					  <option selected>Choose your faculty</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
					</select>
				  </div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
					    <label for="programme">Programme</label>
					    <input type="text" class="form-control" name="programme" id="programme" placeholder="Enter your study programme">
					  </div>	
				</div>
				
				<div class="col-lg-3">
				<div class="form-group">
				    <label for="year">Year</label>
				    <input type="number" class="form-control" min="1" max="6" name="year" id="year" placeholder="Studies year">
				  </div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<label for="interests">Interests</label>
				    <textarea class="form-control" name="interests" id="interests" rows="5" placeholder="Enter your interests"></textarea>
				</div>
			</div>
		
		</form>
	
	</body>
</html>