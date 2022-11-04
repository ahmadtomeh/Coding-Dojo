<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="oneFruit" items="${fruit}">
				<tr>
					<td><c:out value="${oneFruit.name}"></c:out></td>
					<td><c:out value="${oneFruit.price}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>