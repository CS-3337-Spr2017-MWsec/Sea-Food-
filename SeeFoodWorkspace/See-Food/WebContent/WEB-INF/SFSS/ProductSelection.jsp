<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
-->

<title>Product Selection</title>
</head>



<body>
	<div style="float:right;">
	<!--
	NEW YT Account for webcamera.
	
	ORIGINAL
	<iframe style="float:right;" width="560" height="315"
	src="https://www.youtube.com/channel/UCae3AP4kpj9yRx5C2e100Ng/live"
	frameborder="0" allowfullscreen></iframe>
	
	<iframe width="560" height="315" src="https://www.youtube.com/embed/aFiUwFbV9Mw"
	frameborder="0" allowfullscreen></iframe>
	-->
	<iframe width="560" height="315" src="https://www.youtube.com/embed/G14pCtS9MI4" frameborder="0" allowfullscreen></iframe>
	
	</div>
	<br/>

	<%-- TEST
	<c:choose>
		<c:when test="${empty isNull}">
	--%>
	<div style="float:clear;">
			<form action="ProductSelectionController" method="POST">
				<c:if test="${not empty errorMsg}">
					<p style="color: red;">${errorMsg}</p>
				</c:if>
				Search by Product Code: <input type="text" name="searchProductCode" placeholder="Enter a search query">
				<input type="submit" value="Submit">
			</form><br/>
	<%-- TEST	
		</c:when>
	
		<c:otherwise>
	--%>
			${message}
			<br/>
			
			<table>
				<tr>
					<th>${productCode}</th>
					<th>${productName}</th>
					<th>${productDescription}</th>
					<th>${productWeight}</th>
					<th>${productLength}</th>
					<th>${productPrice}</th>
				</tr>
				
		<c:if test="${not empty isNull}">
					<c:forEach items="${filteredListOfTestProducts}" var="product">
				<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.weight}</td>
						<td>${product.length}</td>
						<td>${product.price}</td>
				</tr>
				<tr></tr>
				
				<!--
					Product ID: ${product.id}
					Product Name: ${product.name}
					Product Description: ${product.description}
					Product Weight: ${product.weight}
					Product Length: ${product.length}
					Product Price: ${product.price}
				
				-->
					</c:forEach>
		</c:if>
			</table>
			<br/>
			
			<a href="SeeFoodController">Home</a>
	<%-- TEST
		</c:otherwise>
	</c:choose>
	--%>
	</div>
</body>
</html>