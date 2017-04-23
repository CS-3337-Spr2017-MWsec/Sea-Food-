<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to SFSS!</title>
</head>
<body>
	<div style="text-align:left;">
		<h4>*All descriptions of each product are from Wikipedia.</h4>
	</div>
	<!-- TODO Requires checking of valid user. -->
	<!-- If there is a user logged in, display username, else display 'Hello!` only and without `logout`. -->
	
	<c:if test="${not empty username}">
		<div style="text-align:right;">
			<h1>Hello, ${username}!</h1>
			<a href="LoginController?logout=true">logout</a><hr/>
		</div>
	</c:if>
	<c:if test="${empty username}">
		<div style="text-align:right;">
			Have an account?
				<form action="LoginController" method="POST">
					Username: <input type="text" name="username" placeholder="Enter your username"/><br/>
					Password: <input type="password" name="password" placeholder="Enter your password"/><br/>
					<input type="submit" value="Log in"/>
				</form>
				
			Don't have an account? <a href="RegistrationController">Sign up!</a>
		</div>
	</c:if>
	
	<p style="text-align:right;">
		<a href="ShoppingCartController">Shopping Cart</a>	
	</p>
	
	
	
	<!-- LISTINGS OF PRODUCTS BELOW. -->
	<c:forEach items="${listOfProducts}" var="product">
		<div style="text-align:left;">
			<h2><strong>${product.name}</strong></h2><br/>
			<h4><em>*${product.description}</em></h4><br/>
			Amount in stock: ${product.stock}&emsp;<a href="ShoppingCartController?id=${product.id}">Add to Shopping Cart</a>&emsp;
			Price per pound: <em>$${product.price}</em>
		</div>
		<hr/>
	</c:forEach>
</body>
</html>