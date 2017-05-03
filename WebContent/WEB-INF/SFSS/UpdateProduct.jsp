<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <html lang="en"> 
<head> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
<title>Update Product</title> 
</head>
 <body> 
<br>

<div class="header" style="background-color:#db133c; color:white;padding:40px; height: 150px">

<h2 style="font-color:white">SEEFOOD SERVICE SUPREME</h2>
<br>
</div>

<div style="background-color:#eeeeee;">
<div class="container" style="height:500px">
<br>

<h2>Update Product</h2>
<br>
<span style="font-size:14pt">Product Code: ${productCode}</span>
<br>
<br>
<form action="SaveProductEditController" method="get">
Product Name: <input type="text" size="50" name="productName" value="${productName}"/> 
<br />
<br />
Product Description: <input type="text" size="50" name="productDescription" value="${productDescription}"/> 
<br />
<br />
Quantity: <input type="text" name="quantity" value="${productQuantity}"/> 
<br />
<br />
Price: <input type="text" name="price" value="${productPrice}"/> 
<br />
<br />
Weight: <input type="text" name="weight" value="${productWeight}"/> 
<br />
<br />
Length: <input type="text" name="length" value="${productLength}"/> 

<br />

<input type="hidden" name="id" value="${productCode}" />
<br><br>
<input type="submit" name="save" value="Save" />
</form>
</span>
<br>
<br>
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
</span>
<br>
<br>
</div>
</div>
<div class="footer">
</div>

</body>
</html>