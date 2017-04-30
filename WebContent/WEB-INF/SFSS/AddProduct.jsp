<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product SFSS</title>
</head>
<body>
<h1>Add New Product</h1>
<br>
<form action="AddProductController" method="post">
Product Name: <input type="text" name="productName" value=${param.productName}>
<br>
<br>
Product Description: <input type="text" name="productDescription" value=${param.productDescription}>
<br>
<br>
Product Price: <input type="text" name="productPrice" value=${param.productPrice}>
<br>
<br>
Product Weight: <input type="text" name="productWeight" value=${param.productWeight}>
<br>
<br>

Product Length: <input type="text" name="productLength" value=${param.productLength}>
<br>
<br>
<input type="submit" name="submit" value="submit"/>

</form>

<br>
${message}
<br>
<br>

<br>
<a href="AddProductController">Add New Product</a>
<br>
<br>
<a href="EditProductController">Edit Product</a>
<br>
<br>
<a href="DeleteProductController">Delete Product</a>
</body>
</html>