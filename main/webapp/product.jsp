<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>
<h1>Create Product</h1>
<form action="products" method="post">
Name:<input type="text" name="name">
Description:<input type="text" name="description">
Price:<input type="text" name="price">
Coupon Code:<input type="text" name="CouponCode"/>
<input type="submit" value="Save">

</form>
</body>
</html>