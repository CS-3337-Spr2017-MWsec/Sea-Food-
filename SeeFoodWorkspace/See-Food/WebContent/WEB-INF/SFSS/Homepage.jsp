<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Welcome to SFSS!</title>
</head>
<body>
	<!-- TODO Requires checking of valid user. -->
	<!-- If there is a user logged in, display username, else display 'Hello!` only and without `logout`. -->
	
	<c:if test="${not empty username}">
		<div class='jumbotron' style="text-align:right;">
			<div style="text-align:left;">
				<h4><em>*All descriptions of each product are from Wikipedia.</em></h4>
			</div>
			<!-- <h1>Hello, ${username}!</h1> -->
			<header><h1>Hello, ${username}!</h1></header>
			<a href="LoginController?logout=true"><button>Log Out</button></a>&emsp;
			<a href="ShoppingCartController"><button>Shopping Cart</button></a>
		</div>
	</c:if>
	<c:if test="${empty username}">
		<div class='jumbotron' style="text-align:right;">
			<div style="text-align:left;">
				<h4><em>*All descriptions of each product are from Wikipedia.</em></h4>
			</div>
			Have an account?
				<form action="LoginController" method="POST">
					Username: <input type="text" name="username" placeholder="Enter your username"/><br/>
					Password: <input type="password" name="password" placeholder="Enter your password"/><br/>
					<input type="submit" value="Log in"/>&emsp;
					<a href="ShoppingCartController"><button>Shopping Cart</button></a>
				</form>
				
			Don't have an account? <a href="RegistrationController">Sign up!</a>
		</div>
	</c:if>
	
	
	<div style="float:right; border=5px;">
	<!--
	NEW YT Account for webcamera.
	
	ORIGINAL
	<iframe style="float:right;" width="560" height="315"
	src="https://www.youtube.com/channel/UCae3AP4kpj9yRx5C2e100Ng/live"
	frameborder="0" allowfullscreen></iframe>
	
	<iframe "width="900" height="315" src="https://www.youtube.com/embed/aFiUwFbV9Mw"
	frameborder="0" allowfullscreen></iframe>
	-->
	<iframe width="560" height="315" src="https://www.youtube.com/embed/G14pCtS9MI4" frameborder="0" allowfullscreen></iframe>
	
	<br/>
	<a href="ProductSelectionController">Come and see what we've got!</a>
	<br/>
	</div>
	
	<!-- LISTINGS OF PRODUCTS BELOW. -->
	<!-- TEST -->
	<c:forEach items="${listOfProducts}" var="product">
		<div style="text-align:left;">
			<div style="jumbotron">
				<h2><strong>${product.name}</strong></h2><br/>
				<h3>Product ID: <em>${product.id}</em></h3>
				<h4><em>*${product.description}</em></h4><br/>
				Amount in stock: ${product.stock}&emsp;
				Price per pound: <em>$${product.price}</em>&emsp;
				Weight: <em>${product.weight}</em>&emsp;
				Length: <em>${product.length}</em><br/>
				<a href="ShoppingCartController?id=${product.id}"><button>Add to Shopping Cart</button></a>
			</div>
		</div>
	</c:forEach>
</body>
</html>