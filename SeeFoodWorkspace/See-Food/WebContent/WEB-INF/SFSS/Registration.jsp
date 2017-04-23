<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty billing}">
			<h3>A new SFSS family member!</h3>
			<h4>We just need your:</h4>
			<form action="RegistrationController" method="POST">
				Username: <input type="text" name="username" placeholder="Enter your username"/><br/>
				Email: <input type="text" name="email" placeholder="Enter your email"/><br/>
				Password: <input type="password" name="password1"/><br/>
				Re-enter your password: <input type="password" name="password2"/><br/>
				<input type="submit" value="Submit"/>
			</form>
		</c:when>
		
		<c:otherwise>
			<c:if test="${not empty username}">
				<h3>Oh? So you want these products?</h3>
				<h4>In order for us to deliver these to your door, we'll need:</h4>
				<form action="RegistrationController" method="POST">
					First name: <input type="text" name="firstName"><br/>
					Last name: <input type="text" name="lastName"><br/>
					Shipping address: <input type="text" name="shippingAddress"><br/>
					Phone number: <input type="text" name="number"><br/>
					Billing address: <input type="text" name="billingAddress"><br/>
					Card number: <input type="text" name="card"><br/>
					<input type="submit" value="Submit">
				</form>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>