<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
-->

<title>Product Selection</title>
</head>



<body>
	<!--
	Nate's YT Account <iframe width="560" height="315"
	<iframe style="float:right;" width="560" height="315" 
	src="https://www.youtube.com/embed/live_stream?channel=UCEXqq00s8jq7fqKLQixJ-Iw&autoplay=1"
	frameborder="0" allowfullscreen></iframe>
	-->
	
	<!--
	NEW YT Account for webcamera.
	-->
	<iframe style="float:center;" width="560" height="315"
	src=" https://www.youtube.com/embed/live_stream?channel=UCae3AP4kpj9yRx5C2e100Ng&autoplay=1"
	frameborder="0" allowfullscreen></iframe>

	<!-- NON-VIDEO STREAM
	src="https://www.youtube.com/watch?v=4RUGmBxe65U"
	-->

	<%-- TEST
	<c:choose>
		<c:when test="${empty isNull}">
	--%>
	<br>
	<br>
	See something you like? Enter a product code to get more detailed information!
	<br>
	<br>
<form action="LiveCameraFeed" method="post">	
Search by Product Code: 
<input type="text" name="searchProductCode"  placeholder="Enter a search query" value=${param.searchProductCode}>

<input type="submit" name="submit" value="Submit" />
</form>
<br>
${message}
<br>

<br>
<table>
<th>${productCode}</th>
<th>${productName}</th>
<th>${productDescription}</th>
<th>${productWeight}</th>
<th>${productLength}</th>
<th>${productPrice}</th>

<c:forEach items="${filteredListOfProducts}" var="product">
 <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 </tr>
 </c:forEach>

 </table>
 <br>
 <br>
 <br>
 <form action="SearchDescription" method="post">	
Search Product Descriptions: 
<input type="text" name="searchProductDescription" value=${param.searchProductDescription}>
<input type="submit" name="submit" value="Submit" />
</form>
<br>
${message2}
<br>

<br>
<table>
<th>${productCode2}</th>
<th>${productName2}</th>
<th>${productDescription2}</th>
<th>${productWeight2}</th>
<th>${productLength2}</th>
<th>${productPrice2}</th>

<c:forEach items="${descriptionMatchProductList}" var="product">
  <tr>
 	<td>${product.id}</td>
 	<td>${product.name}</td>
 	<td>${product.description}</td>
 	<td>${product.weight}</td>
 	<td>${product.length}</td>
 	<td>${product.price}</td>
 	 </tr>
 </c:forEach>

 </table>
</body>
</html>