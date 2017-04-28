<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css" />


<!-- Custom styles for this template -->
<link href="assets/css/main.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="assets/js/hover.zoom.js"></script>
<script src="assets/js/hover.zoom.conf.js"></script>


<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 -->
<title>Registration</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">See-Food</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="market.html">Market</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a href="register.html">Register</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<c:choose>
		<c:when test="${empty billing}">

			<!-- <h3>A new SFSS family member!</h3> -->
			<header>A new SFSS family member!</header>
			<div class="container">
				<h1 class="well">Registration Form</h1>
				<div class="col-lg-12 well">
					<h4>We just need your:</h4>
					<form action="RegistrationController" method="POST">
						<div class="col-sm-12">
							<img src="http://clipart-library.com/images/qcBALMeni.gif"
								style="position: absolute; top: -15px; right: 0px;" width="350"
								height="350">
							<div class="row">
								<label>Username: </label> <input type="text" name="username"
									placeholder="Enter your username" class="form-control"
									style="width: 300px;"><br />
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<label>Email: </label> <input type="text" name="email"
									placeholder="Enter your email" class="form-control"
									style="width: 300px;"><br />
							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<label>Password: </label> <input type="password"
									name="password1" class="form-control" style="width: 300px;" /><br />


							</div>
						</div>
						<div class="col-sm-12">
							<div class="row">
								<label>Re-enter your password: </label> <input type="password"
									name="password2" class="form-control" style="width: 300px;" /><br />

							</div>
						</div>
						<input type="submit" value="Submit" />


					</form>
					<a href="SeeFoodController">Go back</a>
				</div>
			</div>
		</c:when>

		<c:otherwise>
			<c:if test="${not empty username}">
				<h3>Oh? So you want these products?</h3>
				<h4>In order for us to deliver these to your door, we'll need:</h4>
				<form action="RegistrationController" method="POST">
					First name: <input type="text" name="firstName"><br />
					Last name: <input type="text" name="lastName"><br />
					Shipping address: <input type="text" name="shippingAddress"><br />
					Phone number: <input type="text" name="number"><br />
					Billing address: <input type="text" name="billingAddress"><br />
					Card number: <input type="text" name="card"><br /> <input
						type="submit" value="Submit">
				</form>
			</c:if>
		</c:otherwise>
	</c:choose>

	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>