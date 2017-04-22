<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Selection</title>
</head>
<body>
<form action="ProductSelectionController" method="post">
Product Code: 
<input type="text" name="searchProductCode"  placeholder="Enter a search query" value=${param.searchProductCode}>
<input type="submit" value="submit">
</form>

 
 <c:forEach items="${filteredListOfProducts}" var="product">
 	${product.productCode}
 	${product.productName}
 	${product.productDescription}
 	${product.productWeight}
 	${product.productLength}
 	${product.productPrice}
 
 </c:forEach>

 
 ${product.productName}
 

 
</body>
</html>