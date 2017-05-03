<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <html lang="en"> 
<head> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
<title>Order Details</title> 
</head>
 <body> 


<div class="header" style="background-color:#db133c; color:white;padding:40px; height: 150px">
<h2 style="font-color:white">SEEFOOD SERVICE SUPREME</h2>
<br>
</div>
<div style="background-color:#eeeeee;">
<div class="container" style="height:1025px">
<br>

<h2>Order Details</h2>
<br>
<h3>Order Id: ${orderId}</h3>
<br>

<table class="table">
<th>${firstName}</th>
<th>${lastName}</th>
<th>${email}</th>
<th>${phoneNumber}</th>
<tr>

<c:forEach items="${viewCustomerList}" var="customer">
<td>${customer.firstName}</td>
<td>${customer.lastName}</td>
<td>${customer.email}</td>
<td>${customer.telephone}</td>
</c:forEach>
</tr>
</table>

<br>
<br>
<table class="table">
<th>${productId}</th>
<th>${productName}</th>
<th>${productDescription}</th>
<th>${weight}</th>
<th>${length}</th>
<th>${price}</th>
<th>${quantity}</th>
<tr>
<c:forEach items="${orderDetailsProductList}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	<td>${product.stock}</td>
 	<td>

 	</td>
 </tr>
 </c:forEach>
 </table>

 
 <c:set var="total" value="${0}"/>
<c:forEach var="product" items="${orderDetailsProductList}">
    <c:set var="total" value="${total + (product.price * product.stock)}" />
</c:forEach>
<br>
 <h3>Order Total: $ ${total}</h3>
 <br>
 <br>

<h4>Shipping Address</h4>
<br>
<table class="table">

<c:forEach items="${viewCustomerList}" var="customer">
<tr><td>${customer.firstName} ${customer.lastName}</td></tr>
<tr><td>${customer.shippingStreetAddress}</td></tr>
<tr><td>${customer.shippingCity} ${customer.shippingState} ${customer.shippingZip}</td></tr>
</c:forEach>
</table>
<br>
<br>


<h4>Billing Address</h4>
<br>
<table class="table">

<c:forEach items="${viewCustomerList}" var="customer">
<tr><td>${customer.firstName} ${customer.lastName}</td></tr>
<tr><td>${customer.billingStreetAddress}</td></tr>
<tr><td>${customer.billingCity} ${customer.billingState} ${customer.billingZip}</td></tr>
</c:forEach>
</table>

<br>
<br>




<br>
<br>
<span style="font-size:15pt;">
<a href="ViewAllOrdersController">Back to Order Management</a>
<br>
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