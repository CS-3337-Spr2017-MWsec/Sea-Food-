<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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

<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
-->
<title>Welcome to SFSS!</title>
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
				<a class="navbar-brand" href="SeeFoodController">See-Food</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="ProductSelectionController">Market</a></li>
					<li><a href="#">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
					<li><a href="">Contact</a></li>
					<li><a href="">Register</a></li>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</div>


	<!-- TODO Requires checking of valid user. -->
	<!-- If there is a user logged in, display username, else display 'Hello!` only and without `logout`. -->

	<c:if test="${not empty username}">
		<div class='jumbotron' style="text-align: right;">
			<div style="text-align: left;"></div>
			<!-- <h1>Hello, ${username}!</h1> -->
			<header>
			<h3>Hello, ${username}!</h3>
			</header>
			<a href="LoginController?logout=true"><button>Log Out</button></a>&emsp;
			<a href="ShoppingCartController"><button>Shopping Cart</button></a>
		</div>
	</c:if>
	<c:if test="${empty username}">
		<div class='jumbotron' style="text-align: right;">

			Have an account?
			<form action="LoginController" method="POST">
				<label>Username: </label> <input type="text" name="username"
					placeholder="Enter your username" /><br /> <label>Password: </label>  <input
					type="password" name="password" placeholder="Enter your password" /><br />
				<input type="submit" value="Log in" />&emsp; <a
					href="ShoppingCartController"><button>Shopping Cart</button></a>
			</form>

			Don't have an account? <a href="RegistrationController">Sign up!</a>
		</div>
	</c:if>

	<div class="container pt">
		<div class="row mt">
			<div class="col-lg-6 col-lg-offset-3 centered">
				<h3>Products</h3>
				<hr>


				<div style="float: right;">

	<!-- CAMERA. -->
	<iframe width="560" height="315" src="https://www.youtube.com/embed/-8XpJD7UShw" frameborder="0" allowfullscreen></iframe>
	
					<br /> <a href="ProductSelectionController">Come and see what
						we've got!</a> <br />
				</div>

				<!-- LISTINGS OF PRODUCTS BELOW. -->
				<!-- TEST -->
				<c:forEach items="${listOfProducts}" var="product">
					<div style="text-align: left;">
						<div style="">
							<h2>
								<strong>${product.name}</strong>
							</h2>
							<br />
							<h3>
								Product ID: <em>${product.id}</em>
							</h3>
							<h4>
								<em>*${product.description}</em>
							</h4>
							<br /> Amount in stock: ${product.stock}&emsp; Price per pound:
							<em>$${product.price}</em>&emsp; Weight: <em>${product.weight}</em>&emsp;
							Length: <em>${product.length}</em><br /> <a
								href="ShoppingCartController?id=${product.id}"><button>Add
									to Shopping Cart</button></a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>





	<h4>
		<em>*All descriptions of each product are from Wikipedia.</em>
	</h4>
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>My Bunker</h4>
					<p>
						CSULA, <br />
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