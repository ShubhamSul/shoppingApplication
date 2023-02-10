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
	<form action="SerachProductController">
		Enter product Id <input type="text" name="prodId"><br> <input
			type="submit" value="Search">
	</form>

	<%!List<Product> lst = null;
	Product prod = null;%>

	<%
	Object o = session.getAttribute("prod");
	if (o instanceof List) {
		lst = (List <Product>) o;
		session.invalidate();
		if (lst != null) {
			prod = lst.get(0);
			lst = null;
	%>
	<table border="1.5px" background="red">
		<tr>
			<td><%=prod.getProdId()%></td>
			<td><%=prod.getProdName()%></td>
			<td><%=prod.getProdPrice()%></td>
			<td><%=prod.getProdQty()%></td>
		</tr>
	</table>
	<%
	}
	} else {
	String str = (String) o;
	out.println(str);
	}
	%>
		<a href="DashboardAdmin.html">Home</a>
</body>
</html>