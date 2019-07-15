<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="userBean" type="org.unibl.etf.bean.UserBean" scope="session"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="../templates/include.jsp" />
		<link href="resources/css/home.css" rel='stylesheet' type='text/css' />
		<title>Share</title>
	</head>
	
	<body>
	
		<div class="container-fluid" style="height: 100%;">
	
			<div class="row" style="height: 100%;">
	
				<div class="col-lg-2">
					<button class="btn btn-primary visible-xs visible-sm collapsed friendsButton"
						type="button" 
						data-toggle="collapse"
						data-target="#activeFriends"
						aria-controls="activeFriends" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
	
					<div class="collapse activeFriends" id="activeFriends">
					<div class="row" style="padding-top: 2%;">
					
					<% for(int i = 0; i < 20; i++) {%>
						<div class="row" style="width: 95%; margin: auto; padding-bottom: 2%;">
							<div class="col-3 justify-content-center align-self-center">
								<div class="profile_picture">
									<img class="profile_image" src="">
								</div>
							</div>
							<div class="col-9 justify-content-center align-self-center">
								<p class="center_content">Name Surname <%=i%></p>
							</div>
						</div>
					<%} %>
						
					</div>
					</div>
				</div>
				<div class="col-lg-7" style="background-color: green;"></div>
				<div class="col-lg-3">
					<div class="row" style="background-color: black; height: 50%;"></div>
					<div class="row" style="background-color: orange; height: 50%;"></div>
				</div>
	
			</div>
	
	
		</div>
	
	</body>
</html>