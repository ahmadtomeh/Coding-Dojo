<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<h1 class = "text-info container">Welcome, ${ thisUser.userName}!</h1>
<br>
<br>
<p class = "container"><a href = "/logout">logout</a></p>

<table class="table table-bordered border border-dark container">
			<thead>
				<tr>
					<th class="jumbotron text-center"><h3>Team Name</h3></th>
					<th class="jumbotron text-center"><h3>Skill Level(1-5)</h3></th>
					<th class="jumbotron text-center"><h3>Game Day</h3></th>
				</tr>
			</thead>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td><a href="/teams/${team.id}">${team.name }</a></td>
					<td>${team.level}</td>
					<td>${team.day}</td>
				</tr>
			</c:forEach>
		</table>
		<center>
		<a class="btn-outline-dark form-control container" href = "/teams/new">Create New Team</a>
		</center>
		
</body>
</html>