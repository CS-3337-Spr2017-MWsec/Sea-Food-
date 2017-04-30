<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Product SFSS</title>
</head>
<body>
<h1>Delete Product</h1>
<br>
<form action="DeleteProductController" method="post">
Enter a product code to delete product:
<input type="text" name="deleteProductSearch" value=${param.deleteProductSearch}>

<input type="submit" name="submit" value="Submit">
</form>
<br>
${message}
<br>

<br>
<table>
<th>${productCode}</th>
<th>${productName}</th>
<th>${productDescription}</th>
<th>${productWeight}</th>
<th>${productLength}</th>
<th>${productPrice}</th>

<c:forEach items="${deleteProductList}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	<td>
 <a href="DeleteProductButtonController?id=${product.id}"><button>Delete Product</button></a>

 	</td>
 </tr>
 </c:forEach>

 </table>
 
 ${messageDeleted}
 
 <br>
 <br>
 <br>

<br>

</body>
</html>