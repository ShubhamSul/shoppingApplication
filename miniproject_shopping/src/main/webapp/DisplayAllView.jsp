<%@page import="linkcode.shop.admin.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!List<Product> lst = null;
	Product prod = null;%>

	<%
	lst =(List<Product>)  session.getAttribute("prodlst");
		session.invalidate();
%>
<table border="3px" background="gray">
	<%		
		for(Product prod:lst){
	%>
	
		<tr>
			<td><%=prod.getProdId()%></td>
			<td><%=prod.getProdName()%></td>
			<td><%=prod.getProdPrice()%></td>
			<td><%=prod.getProdQty()%></td>
		</tr>

	<%} %>
		</table>
				<a href="DashboardAdmin.html">Home</a>
</html>