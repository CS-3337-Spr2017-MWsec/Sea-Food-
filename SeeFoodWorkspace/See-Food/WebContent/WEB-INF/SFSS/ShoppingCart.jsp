<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<c:choose>
		<c:when test="${empty userProducts}">
			<h2>There is nothing in your Shopping Cart!</h2><br/>
		</c:when>
		
		<c:otherwise>
			<h2>Your products in your Shopping Cart:</h2>
			<p>
				Total products in shopping cart: ${numberOfProducts}<br/>
			</p>
			
			<c:forEach items="${userProducts}" var="product">
				<li>
					<c:choose>
							<c:when test="${product.delete}"> <!-- If product object is marked for removal. -->
								<s>
									<strong>${product.name}</strong><br/>
									<em>${product.description}</em><br/>
									Weight: <strong>${product.weight}</strong><br/>
									Size: <strong>${product.length}</strong><br/>
									<!-- Amount in cart: ${product.quantity}<br/> -->
								</s>
									<a href="ToggleRemoveController?id=${product.id}">Do NOT delete</a>&emsp;
									<a href="RemoveProductsController">Remove selected products</a><br/>
								<hr/>
							</c:when>
							
							<c:otherwise> <!-- Otherwise, remove from removal. -->
								<strong>${product.name}</strong><br/>
								<em>${product.description}</em><br/><br/>
								Weight: <strong>${product.weight}</strong><br/>
								Size: <strong>${product.length}</strong><br/>
									<form action="OrderController" method="POST">
										<input type="hidden" name="id" value="${product.id}">
										<input type="hidden" name="name" value="${product.name}">
										<input type="hidden" name="desc" value="${product.description}">
										<input type="hidden" name="weight" value="${product.weight}">
										<input type="hidden" name="length" value="${product.length}">
									</form><br/>
									Total: <em>$${product.price} <strong>per pound</strong></em><br/>
									
									Amount in cart:
									<select name="itemQuantity">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>&emsp;
									
									<!-- ORIGINAL Total: <em>$${product.price}</em> -->
								<a href="ToggleRemoveController?id=${product.id}">Delete</a><br/>
								<hr/>
								
							</c:otherwise>	
					</c:choose>
				</li>
			</c:forEach>
			
			<a href="SeeFoodController">Continue shopping</a>&emsp;
			<input type="submit" value="Checkout">
		</c:otherwise>
	</c:choose>
	
	<c:if test="${empty userProducts}">
		<a href="SeeFoodController">Continue shopping</a>
	</c:if>
	
	<!--
	<c:if test="${not empty userProducts}">
		<a href="RemoveProductsController">Remove selected products</a><br/><hr/>
		<input type="Submit" value="Checkout">
	</c:if>
	-->
</body>
</html>