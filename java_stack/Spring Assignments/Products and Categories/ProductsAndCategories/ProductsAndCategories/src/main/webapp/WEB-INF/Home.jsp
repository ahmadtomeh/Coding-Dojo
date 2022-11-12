<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<h1 class="jumbotron text-center">Home Page</h1>
<div class="col-sm-8 container">
		<a href="/products/new">New Product</a>
		<br>
		<a href="/categories/new">New category</a>
	<hr>
	
		<table class="table table-bordered border border-dark">
			<thead>
				<tr>
					<th class="jumbotron text-center"><h2>Products</h2></th>
					<th class="jumbotron text-center"><h2>Categories</h2></th>
				</tr>
			</thead>
			<tr>
				<td>
					<c:forEach var="i" items="${products}">
						<ul>
							<li><a href = "/products/${i.id}">${i.name}</a></li>
						</ul>
					</c:forEach></td>
				<td>
					<c:forEach var="i" items="${categories}">
						<ul>
							<li><a href = "/categories/${i.id}">${i.name}</a></li>
						</ul>
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>
</body>
</body>
</html>