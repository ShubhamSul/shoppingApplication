<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Insert Title Here</title>
<style type="text/css">
div{
color:red;
}
</style>

</head>
<body>
<%! String str=null; %>
<form action="ProductController">
<table>
<tr>
<td>Product ID</td>
<td><input type="text" name="prodId"></td>
</tr>

<tr>
<td>Product Name</td>
<td><input type="text" name="prodName"></td>
</tr>

<tr>
<td>Product Price</td>
<td><input type="text" name="prodPrice"></td>
</tr>

<tr>
<td>Product Qty</td>
<td><input type="text" name="prodQty"></td>
</tr>

<tr>
<td><input type="submit" name="prodQty"></td>
</tr>
</table>
</form>

<div>
<%
str=(String)session.getAttribute("msg");
session.invalidate();
%>
<h1><%=str %></h1>
</div>
<a href="DashboardAdmin.html">Home</a>
</body>
</html>