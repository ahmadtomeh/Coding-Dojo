<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="container">${ teams.name}</h1>
		<br> <a class="d-flex col-2" href="/home">dashboard</a> <br>
		<br>
		<p>
			<label>Team Name : </label> ${ teams.name}
		</p>
		<p>
			<label>Skill Level : </label> ${ teams.level}
		</p>
		<p>
			<label>Game Day : </label> ${teams.day}
		</p>

		<ul>
			<lable>Players :</lable>
		</ul>
		<c:forEach var="i" items="${teams2}">
			<li>${i.userName}</li>
		</c:forEach>
<hr>
<p>Add Player :</p>
		<form action="/join/${teams.id}" method="post">
			<table class="table table-bordered border border-dark container">
				<tr>
				
				<td>Player Name: </td>
					<td><select name="user1">
							<c:forEach var="i" items="${users}">
								<option value="${ i.id}">${i.userName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
				<td colspan="2">
				<button class="btn btn-primary form-control">Add</button>
				</td>
				</tr>
			</table>
		</form>

		<c:choose>
			<c:when test="${user_id==teams.user.id }">
				<a href="/teams/${teams.id }/edit">edit</a>
				<br>
				<a href="/teams/${teams.id }/delete">delete</a>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>