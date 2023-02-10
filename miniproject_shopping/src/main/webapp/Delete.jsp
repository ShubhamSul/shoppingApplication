<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DeleteController">
Enter product Id<input type="text" name="prodId"><br>
<input type="submit" value="Delete"><br>
</form>
<%!String str=null; %>
<%
str=(String)session.getAttribute("dprod");
session.invalidate();%>
<h1><%=str %></h1><br>
<a href="DashboardAdmin.html">Home</a>
</body>
</html>