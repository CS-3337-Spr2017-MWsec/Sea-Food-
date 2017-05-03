<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Management</title>
</head>
<body>
<h1>Order Management</h1>
<br>
<form action="ViewAllOrdersController" method="post">
<input type="hidden" name="viewAllOrders" value="param.viewAllOrders">
<input type="submit" name="submit" value="View All Orders">
</form>


 <table>
<th>${orderId}</th>
<th>${customerId}</th>



<c:forEach items="${viewAllOrdersList}" var="order">
 <tr>
 	<td>${order.orderId}</td>
 	<td>${order.customerId}</td>

 	<td>

 	</td>
 </tr>
 </c:forEach>
 </table>
<br>
<br>
<a href="EditOrderController">Edit Order</a>
<br>
<br>
<a href="DeleteOrderController">Delete Order</a>
</body>
</html>