<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Categories Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="jumbotron text-center">${categories.name}</h1>
	<div class="col-sm-8 container">
		<a href="/">Home</a>
		<hr>
		<h3>Products</h3>
		
		<c:forEach var="i" items="${categories.products }">
			<p>- ${i.name }</p>
		</c:forEach>
		<hr>
		<h2>Add a Products</h2>
		<form action="/AddProductToCategory" method="post">
			<input type="hidden" name="IdP" value="${categories.id}"> <select
				name="category">
				<c:forEach var="i" items="${products }">
					<option value="${ i.id}">${i.name}</option>
				</c:forEach>
			</select>
			<button>Add</button>
		</form>
	</div>
</body>
</html>