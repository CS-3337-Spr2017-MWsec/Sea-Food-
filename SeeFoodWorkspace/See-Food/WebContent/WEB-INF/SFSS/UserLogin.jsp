<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
				<a class="navbar-brand" href="SeeFoodController">SeeFood Service Supreme</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="ProductSelectionController">Market</a></li>
					<li><a href="#">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
					<li><a href="">Contact</a></li>
	
				</ul>
			</div>
		</div>
	</div>

	<div class="container">

		<h1 class="well">SFSS member logging in!</h1>
		<div class="col-lg-12 well">
			<form action="LoginController" method="post">
				<div class="col-sm-12">

					<div class="row">
						<label>Username: </label> <input type="text" name="username"
							placeholder="Enter your username" class="form-control"
							style="width: 300px;"><br />
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<label>Password: </label> <input type="password" name="password1"
							class="form-control" style="width: 300px;" /><br />
					</div>
				</div>


<!-- 
				<input type="text" name="username" placeholder="Enter username">
				<input type="password" name="password" placeholder="Enter password">  -->
				<input type="submit" value="Login">
			</form>
		</div>
	</div>
	<!-- footer -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>My Bunker</h4>
					<p>
						CSULA<br />
					</p>
				</div>

				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a><br /> <a href="#">Twitter</a><br /> <a
							href="#">Facebook</a>
					</p>
				</div>

				<div class="col-lg-4">
					<h4>About See-Food</h4>
					<p>
						Put your heart, mind, and soul into even your smallest acts. This
						is the secret of success.<br />-Swami Sivananda
					</p>
				</div>
			</div>
		</div>
	</div>

	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>