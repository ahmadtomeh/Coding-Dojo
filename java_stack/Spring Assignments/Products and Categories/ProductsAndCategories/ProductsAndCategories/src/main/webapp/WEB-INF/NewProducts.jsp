<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>New Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="jumbotron text-center">New Product</h1>
	<div class="col-sm-8 container">
		<a href="/">Home</a>
		<hr>
		<table class="table table-bordered border border-dark">
			<form:form action="/products/new" method="post"
				modelAttribute="products">
				<tr>
					<td><form:label path="name" style="width: 10%">Name: </form:label></td>
					<td><form:input class="form-control" path="name" /> <form:errors path="name"
							class="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="description" style="width: 10%">Description: </form:label></td>
					<td><form:input class="form-control" path="description" /> <form:errors
							path="description" class="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="price" style="width: 10%">Price: </form:label></td>
					<td><form:input class="form-control" path="price" /> <form:errors
							path="price" class="text-danger" /></td>
				</tr>
				<tr>
					<td colspan="2"><input class="form-control" type="submit" value="Submit" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>