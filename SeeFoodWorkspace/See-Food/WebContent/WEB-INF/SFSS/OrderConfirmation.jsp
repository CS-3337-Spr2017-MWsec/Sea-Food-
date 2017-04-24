<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.Date" %>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Order Confirmed!</title>
</head>
<body>
	<h1>Thank You!</h1>
	
	<a style="text-align:right;" href="LoginController?logout=true">logout</a>
	
	<c:set var="today" value="<%=new Date(new Date().getTime()) %>"/>
	<c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60 * 60 * 24 * 1000) %>"/>
	
	<h2>Your orders will come in at: <fmt:formatDate type="date" value="${tomorrow}" pattern="d"/></h2><br/>
	
	<c:forEach items="userProducts" var="items">
		<strong>${items.name}</strong><br/>
		<em>${items.description}</em><br/>
		Amount: ${items.quantity}<br/>
		Weight: ${items.weight}<br/>
		Length: ${items.length}<br/> 
		Date ordered: <fmt:formatDate type="date" value="${today}" pattern="d"/><hr/>
		
		<!-- FOR REFERENCE.
		<strong>${product.name}</strong><br/>
		<em>${product.description}</em><br/>
		<!-- Amount in cart: ${product.stock}&emsp;Edit stock: <input type="number" name="stock"><br/>
			<form action="OrderController" method="POST">
			<input type="hidden" name="id" value="${product.id}">
			<input type="hidden" name="name" value="${product.name}">
			<input type="hidden" name="desc" value="${product.description}">
			Amount in cart:
				<select name="itemQuantity">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</form><br/>
		<a href="ToggleRemoveController?id=${product.id}">Delete</a><br/>
						<hr/>
		-->
		
		
	</c:forEach>
	
	<a href="SeeFoodController">Continue shopping</a>
</body>
</html>