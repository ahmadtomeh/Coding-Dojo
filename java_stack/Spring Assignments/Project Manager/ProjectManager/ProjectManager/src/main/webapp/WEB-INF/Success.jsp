<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="container">
		<div class="d-flex col-5">
			<h1 class="text-info container">Welcome, ${ thisUser.lastName}!</h1>
			<a href="/logout">logout</a>
		</div>
		<br>
		<div class="d-flex col-12">
			<p class="container">All Project</p>
			<p class="end col-2">
				<a href="/projects/new">
					<button>+ new project</button>
				</a>
			</p>
		</div>
		<table class="table table-bordered border border-dark container">
			<thead>
				<tr>
					<th class="jumbotron text-center"><h3>Project</h3></th>
					<th class="jumbotron text-center"><h3>Team Lead</h3></th>
					<th class="jumbotron text-center"><h3>Due Date</h3></th>
					<th class="jumbotron text-center"><h3>Actions</h3></th>
				</tr>
			</thead>
			<c:forEach var="proj" items="${projects1}">
				<tr>
					<td><a href="/projects/${proj.id}">${proj.title }</a></td>
					<td>${proj.user.firstName } ${proj.user.lastName }</td>
					<td><fmt:formatDate pattern="MMM dd" value="${proj.dueDate}" /></td>
					<td><a href="/join/${proj.id }">join project</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<p class="container">Your Projects</p>
		<table class="table table-bordered border border-dark container">
			<thead>
				<tr>
					<th class="jumbotron text-center"><h3>Project</h3></th>
					<th class="jumbotron text-center"><h3>Team Lead</h3></th>
					<th class="jumbotron text-center"><h3>Due Date</h3></th>
					<th class="jumbotron text-center"><h3>Actions</h3></th>
				</tr>
			</thead>

			<c:forEach var="proj" items="${projects2}">
				<tr>
					<td><a href="/projects/${proj.id}">${proj.title }</a></td>
					<td>${proj.user.firstName } ${proj.user.lastName }</td>
					<td><fmt:formatDate pattern="MMM dd" value="${proj.dueDate}" /></td>
					<td><c:choose>
							<c:when test="${thisUser.id==proj.user.id }">
								<a href="/projects/${proj.id}/edit">Edit</a>
							</c:when>
							<c:otherwise>
								<a href="/disjoin/${proj.id}">leave team</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>



