<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
				<a class="navbar-brand" href="SeeFoodController">SFSS</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="ProductSelectionController">Market</a></li>
					<li><a href="">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
					<li><a href="Contact">Contact</a></li>
					<li><a href="RegistrationController">Register</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<c:choose>
		<c:when test="${empty billing}">

			<!-- <h3>A new SFSS family member!</h3> -->
			<h1>A new SFSS family member!</h1>
			<div class="container">
				<h2 class="well">Registration Form</h2>
				<div class="col-lg-12 well">
					<h4>We just need your:</h4>
					<form action="RegistrationController" method="POST">
						<div class="col-sm-12">
							<iframe src="//giphy.com/embed/odwOXY8XpcYWQ" width="320"
								height="180" frameBorder="0" class="giphy-embed"
								style="position: absolute; top: -15px; right: 0px;"></iframe>


						</div>

						<div class="col-sm-12">

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

				<header>Oh? So you want these products?</header>
				<div class="container">
					<h1 class="well">In order for us to deliver these to your
						door, we'll need</h1>
					<div class="col-lg-12 well">

						<form action="RegistrationController" method="POST">
							<div class="col-sm-12">

								<div class="row">

									First name: <input type="text" name="firstName"><br />
								</div>
							</div>

							<div class="col-sm-12">

								<div class="row">
									Last name: <input type="text" name="lastName"><br />

								</div>
							</div>
							<div class="col-sm-12">

								<div class="row">
									Shipping address: <input type="text" name="shippingAddress"><br />
								</div>
							</div>

							<div class="col-sm-12">

								<div class="row">
									Phone number: <input type="text" name="number"><br />

								</div>
							</div>
							<div class="col-sm-12">

								<div class="row">
									Billing address: <input type="text" name="billingAddress"><br />
								</div>
							</div>
							<div class="col-sm-12">

								<div class="row">
									Card number: <input type="text" name="card"><br />
								</div>
							</div>

							<input type="submit" value="Submit">
						</form>
					</div>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
	<!-- footer -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>My Bunker</h4>
					<p>
						CSULA <br />
					</p>
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a> <br /> <a href="#">Twitter</a> <br /> <a
							href="#">Facebook</a>
					</p>
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<h4>About See-Food</h4>
					<p>
						Put your heart, mind, and soul into even your smallest acts. This
						is the secret of success. - Swami Sivananda


						<!-- /col-lg-4 -->
				</div>

			</div>
		</div>

	</div>


	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>