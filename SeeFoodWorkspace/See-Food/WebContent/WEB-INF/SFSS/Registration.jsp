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
	<h3>Creating a new SFSS family member...!</h3>
	<h4>We just need your:</h4>
	<form action="RegistrationController" method="POST">
		Username: <input type="text" name="username" placeholder="Enter your username"/><br/>
		Email: <input type="text" name="email" placeholder="Enter your email"/><br/>
		Password: <input type="password" name="password1"/><br/>
		Re-enter your password: <input type="password" name="password2"/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>