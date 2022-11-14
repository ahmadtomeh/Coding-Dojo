<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<h1 class="text-info container">Welcome, ${ thisUser.userName}!</h1>
	<br>
	<p class="container">Books from everyone's shelves:</p>
	<br>
	<p class="container">
		<a href="/logout">logout</a>
		<a href="/books/new">+ Add a book to my shelf!</a>
	</p>


	<table class="table table-bordered border border-dark container">
		<thead>
			<tr>
				<th class="jumbotron text-center"><h3>ID</h3></th>
				<th class="jumbotron text-center"><h3>Title</h3></th>
				<th class="jumbotron text-center"><h3>Author Name</h3></th>
				<th class="jumbotron text-center"><h3>Posted By</h3></th>
			</tr>
		</thead>

		<c:forEach var="i" items="${books}">
			<tr>
				<td>${i.id}</td>
				<td><a href="/books/${i.id}">${i.title}</a></td>
				<td>${i.author}</td>
				<td>${i.user.userName}</td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>