<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <html lang="en"> 
<head> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
<title>Add Product</title> 
</head>
 <body> 
<br>

<div class="header" style="background-color:#db133c; color:white;padding:40px; height: 150px">

<h2 style="font-color:white">SEEFOOD SERVICE SUPREME</h2>
<br>
</div>

<div style="background-color:#eeeeee;">
<div class="container" style="height:440px">
<br>
<h2>Add New Product</h2>
<br>

<form action="AddProductController" method="post">
Product Name: <input type="text" name="productName" value=${param.productName}>
<br>
<br>
Product Description: <input type="text" name="productDescription" value=${param.productDescription}>
<br>
<br>

Product Weight: <input type="text" name="productWeight" value=${param.productWeight}>
<br>
<br>

Product Length: <input type="text" name="productLength" value=${param.productLength}>
<br>
<br>
Product Price: <input type="text" name="productPrice" value=${param.productPrice}>
<br>
<br>

Quantity: <input type="text" name="productQuantity" value=${param.productQuantity}>
<br>
<br>
<br>
<input type="submit" name="submit" value="submit"/>

</form>
<br>
<br>
<br>
<form action="ViewAllAddController" method="post">
<input type="hidden" name="viewAllProductsDelete" value="param.viewAllProductsDelete">
<input type="submit" name="submit" value="View All Products">
</form>

<br>
<br>
${message}
<br>
<br>

<table class="table">
<th>${productCode}</th>
<th>${productName}</th>
<th>${productDescription}</th>
<th>${productWeight}</th>
<th>${productLength}</th>
<th>${productPrice}</th>
<th>${productQuantity}</th>


<c:forEach items="${viewAllProductsList}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	<td>${product.stock}</td>
 </tr>
 </c:forEach>
 </table>
<br>
<br>
<span style="font-size:15pt;">
<a href="AddProductController">Add New Product</a>
<br>
<br>
<a href="EditProductController">Edit Product</a>
<br>
<br>
<a href="DeleteProductController">Delete Product</a>
<br><br>
<br>
<a href="VendorAdminMainController">Vendor Admin</a>
</span>
<br>
<br>
</div>
</div>
<div class="footer">
</div>
</body>
</html>