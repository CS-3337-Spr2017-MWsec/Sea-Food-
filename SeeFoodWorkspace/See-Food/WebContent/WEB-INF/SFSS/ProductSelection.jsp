<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Selection</title>
</head>



<body>
	<c:choose>
		<c:when test="${empty entry}">
			<form action="ProductSelectionController" method="POST">
				<c:if test="${not empty errorMsg}">
					<p style="color: red;">${errorMsg}</p>
				</c:if>
				Search by Product Code: <input type="text" name="searchProductCode" placeholder="Enter a search query">
				<input type="submit" value="Submit">
			</form><br/>
		</c:when>
	
		<c:otherwise>
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
				
					<c:forEach items="${filteredlistOfTestProducts}" var="product">
				<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.weight}</td>
						<td>${product.length}</td>
						<td>${product.price}</td>
						<td></td>
				</tr>
					</c:forEach>
			</table>
			<br/>
		</c:otherwise>
	</c:choose>
</body>
</html>