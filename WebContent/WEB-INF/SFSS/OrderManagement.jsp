<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <html lang="en"> 
<head> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
<title>Order Management</title> 
</head>
 <body> 
<br>

<div class="header" style="background-color:#db133c; color:white;padding:40px; height: 150px">

<h2 style="font-color:white">SEEFOOD SERVICE SUPREME</h2>
<br>
</div>

<div style="background-color:#eeeeee;">
<div class="container" style="height:175px">
<br>
<h2>Order Management</h2>
<br>
<form action="ViewAllOrdersController" method="post">
<input type="hidden" name="viewAllOrders" value="param.viewAllOrders">
<input type="submit" name="submit" value="View All Orders">
</form>
<br>
<br>
<br>
 <table class="table">
<th>${orderId}</th>
<th>${customerId}</th>
<th>${firstName}</th>
<th>${lastName}</th>
 <tr>
<c:forEach items="${viewAllOrdersList}" var="order">

 	<td>${order.orderId}</td>
 	<td>${order.customerId}</td>
 	<td>${order.firstName}</td>
 	<td>${order.lastName}</td>
 
<td><a href="OrderDetailsController?id=${order.orderId}"><button>View Order Details</button></a></td>
</tr>
  </c:forEach>
 </table>
 
 


<br>
<br>
<span style="font-size:15pt;">
<a href="VendorAdminMainController">Vendor Admin</a>
</span>
<br>
<br>
</div>
</div>
<div class="footer">
</div>
<br>
<%--<a href="EditOrderController">Edit Order</a>--%>
<br>
<br>
<%--<a href="DeleteOrderController">Delete Order</a>--%>
</body>
</html>