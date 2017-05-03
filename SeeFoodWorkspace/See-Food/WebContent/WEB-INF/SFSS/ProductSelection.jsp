<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<title>Product Selection</title>
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
				<a class="navbar-brand" href="SeeFoodController">SeeFood Service
					Supreme</a>
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
		</div>
	</div>


	<!--
    CAMERA.
    -->
	<center>
		<div class='jumbotron' style="text-align: right;">
			<!-- TEST -->
			<img align="left"
				src="http://clipartix.com/wp-content/uploads/2016/04/Crabs-crab-clipart-free-clip-art-images-clipartwiz.png"
				width="320" height="213">

			<iframe width="854" height="480"
				src="https://www.youtube.com/embed/-8XpJD7UShw" frameborder="0"
				allowfullscreen></iframe>
			</iframe>

			<br> See something you like? Enter a product code to get more
			detailed information! <br> <br> <br>
		</div>
	</center>

	<div id="grey">
		<div class="container">
			<center>
				<h3>Product Search</h3>
			</center>

			<div class="row">
				<br />


				<form action="ProductSelectionController" method="post">
					Search by Product Code: <input type="text" name="searchProductCode"
						placeholder="Enter a search query"
						value="${param.searchProductCode}"> <input type="submit"
						name="submit" value="Submit" />
				</form>
				<br> ${message} <br> <br>
				<table>
					<thead>
						<tr>
							<th>${productCode}</th>
							<th>${productName}</th>
							<th>${productDescription}</th>
							<th>${productWeight}</th>
							<th>${productLength}</th>
							<th>${productPrice}</th>
						</tr>
					</thead>
					<c:forEach items="${filteredListOfProducts}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.description}</td>
							<td>${product.weight}</td>
							<td>${product.length}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<form action="SearchDescriptionController" method="post">
					Search Product Descriptions: <input type="text"
						name="searchProductDescription" placeholder="Enter a description"
						value="${param.searchProductDescription}"> <input
						type="submit" name="submit" value="Submit" />
				</form>
				<br> ${message2} <br> <br>
				<table>
					<thead>
						<tr>
							<th>${productCode2}</th>
							<th>${productName2}</th>
							<th>${productDescription2}</th>
							<th>${productWeight2}</th>
							<th>${productLength2}</th>
							<th>${productPrice2}</th>
						</tr>
					</thead>
					<c:forEach items="${descriptionMatchProductList}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.description}</td>
							<td>${product.weight}</td>
							<td>${product.length}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
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