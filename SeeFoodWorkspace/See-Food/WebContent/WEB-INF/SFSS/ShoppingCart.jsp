<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>
	<c:choose>
		<c:when test="${not empty username}">
			${username}'s Shopping Cart
		</c:when>
		<c:otherwise>
			Guest's Shopping Cart
		</c:otherwise>
	</c:choose>
</title>	
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
				<a class="navbar-brand" href="SeeFoodController">SeeFood</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="ProductSelectionController">Market</a></li>
					<li><a href="About">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
					<li><a href="Contact">Contact</a></li>
					<li><a href="RegistrationController">Register</a></li>
				</ul>
			</div>
		</div>
	</div>



			<div id="grey">
	<c:choose>
		<c:when test="${empty userProducts}">

			<div id="ww">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2 centered">

							<h1>There is nothing in your Shopping Cart!</h1>
							<img src="https://media.giphy.com/media/KZZt2LROglZSw/giphy.gif">
						</div>
					</div>
				</div>
			</div>

		</c:when>

		<c:otherwise>
				<div class="container">
					<center>
						<h3>Your products in your Shopping Cart:</h3>
					</center>

				
					<p>
						Total products in shopping cart: ${numberOfProducts}<br />
					</p>

					<c:forEach items="${userProducts}" var="product">
						<c:choose>
								<c:when test="${product.delete}">
									<!-- If product object is marked for removal. -->
									<div style="">
										<s> <strong>${product.name}</strong><br /> <em>${product.description}</em><br />
											Weight: <strong>${product.weight}</strong><br /> Size: <strong>${product.length}</strong><br />
											<!-- Amount in cart: ${product.quantity}<br/> -->
										</s> <a href="ToggleRemoveController?id=${product.id}">Do NOT
											delete</a>&emsp; <a href="RemoveProductsController">Remove
											selected products</a><br />
										<hr />
									</div>
								</c:when>

								<c:otherwise>
									<!-- Otherwise, remove from removal. -->
									<div style="">
										<strong>${product.name}</strong><br /> <em>${product.description}</em><br />
										<br /> Weight: <strong>${product.weight}</strong><br />
										Length: <strong>${product.length}</strong><br />
										<form action="OrderController" method="POST">
											<input type="hidden" name="id" value="${product.id}">
											<input type="hidden" name="name" value="${product.name}">
											<input type="hidden" name="desc"
												value="${product.description}"> <input type="hidden"
												name="weight" value="${product.weight}"> <input
												type="hidden" name="length" value="${product.length}">
										</form>
										<br /> Total: <em>$${product.price} <strong>per
												pound</strong></em><br /> Amount in cart: <select name="itemQuantity">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>&emsp;

										<!-- ORIGINAL Total: <em>$${product.price}</em> -->
										<a href="ToggleRemoveController?id=${product.id}">Delete</a><br />
										<hr />
									</div>
								</c:otherwise>
							</c:choose>
					</c:forEach>

					<a href="SeeFoodController"><button>Continue shopping</button></a> &emsp; <input
						type="submit" value="Checkout">
				</div>
		</c:otherwise>
	</c:choose>

		<c:if test="${empty userProducts}">
			<a href="SeeFoodController"><button>Continue shopping</button></a>
		</c:if>
			</div>

	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>My Bunker</h4>
					<p>
						CSULA <br />
					</p>
				</div>

				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a> <br /> <a href="#">Twitter</a> <br /> <a
							href="#">Facebook</a>
					</p>
				</div>

				<div class="col-lg-4">
					<h4>About SeeFood</h4>
					<p>
						Put your heart, mind, and soul into even your smallest acts. This
						is the secret of success.<br/>- Swami Sivananda
					</p>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/bootstrap.min.js"></script>



</body>
</html>