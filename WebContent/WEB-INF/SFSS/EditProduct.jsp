<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product SFSS</title>
</head>
<body>
<h1>Edit Product</h1>
<br>
<form action="EditProductController" method="post">
Enter a product code to edit a product:
<input type="text" name="editProductSearch" value=${param.editProductSearch}>

<input type="submit" name="submit" value="Submit">
</form>
<br>
${message}
<br>

<form action="ViewAllEditController" method="post">
<input type="hidden" name="viewAllProductsEdit" value="param.viewAllProductsEdit">
<input type="submit" name="submit" value="View All Products">
</form>

<br>
<br>
<table>
<th>${productCode}</th>
<th>${productName}</th>
<th>${productDescription}</th>
<th>${productWeight}</th>
<th>${productLength}</th>
<th>${productPrice}</th>


<c:forEach items="${viewAllProductsList}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	<td>
 <a href="EditProductButtonController?id=${product.id}"><button>Edit Product</button></a>

 	</td>
 </tr>
 </c:forEach>

${messageEdit}

<c:forEach items="${editProductList}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.quantity}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	<td>
 <a href="EditProductButtonController?id=${product.id}"><button>Edit Product</button></a>

 	</td>
 </tr>
 </c:forEach>

 </table>
 
 
 <br>
 <br>

<a href="AddProductController">Add New Product</a>
<br>
<br>
<a href="EditProductController">Edit Product</a>
<br>
<br>
<a href="DeleteProductController">Delete Product</a>

<br>

</body>
</html>