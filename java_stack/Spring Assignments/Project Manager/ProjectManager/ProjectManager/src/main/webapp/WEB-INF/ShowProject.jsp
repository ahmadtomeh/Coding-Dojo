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
		<br>
		<div class="d-flex col-12">
			<h1 class="container">Project Details</h1>
			<a class="d-flex col-2" href="/home">Back to Dashboard</a>
		</div>
		<p>
			<label>Project : </label> ${ projects.title}!
		</p>
		<p>
			<label>Description : </label> ${ projects.description}!
		</p>
		<p>
			<label>Due Date : </label>
			<fmt:formatDate pattern="dd/MM/yyyy" value="${projects.dueDate}" />
		</p>
		

		<c:choose>
			<c:when test="${thisUser.id==projects.user.id }">
				<a class="btn btn-danger" href="/projects/${projects.id }/delete">
			Delete</a>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>