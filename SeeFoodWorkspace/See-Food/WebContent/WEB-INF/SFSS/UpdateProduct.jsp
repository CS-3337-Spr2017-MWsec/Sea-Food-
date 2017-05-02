<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
<form action="SaveProductEditController" method="get">
<h1>Update Product</h1>
<br>
Product Code: ${productCode}
<br>
<br>
Product Name: <input type="text" name="productName" value="${productName}"/> 
<br />
Product Description: <input type="text" name="productDescription" value="${productDescription}"/> 

<br />
Quantity: <input type="text" name="quantity" value="${productQuantity}"/> 

<br />
Price: <input type="text" name="price" value="${productPrice}"/> 
<br />
Weight: <input type="text" name="weight" value="${productWeight}"/> 
<br />
Length: <input type="text" name="length" value="${productLength}"/> 

<br />

<input type="hidden" name="id" value="${productCode}" />

<input type="submit" name="save" value="Save" />
</form>


</body>
</html>