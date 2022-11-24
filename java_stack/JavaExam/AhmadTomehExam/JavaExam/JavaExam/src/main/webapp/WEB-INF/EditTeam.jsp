<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
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
	<div class="container col-12">

		<h1>Edit Team</h1>
		<a href="/home">dashboard</a>
		<form:form action="/teams/${pro.id }/edit" method="post" modelAttribute="pro">
			<input type="hidden" name="_method" value="put">
		<p>
			<form:input type="hidden" path="user" value = "${user_id}"/>
		</p>
			<table class="table table-bordered border border-dark container">
				<tbody>
					<tr>
						<td>Team Name :</td>
						<td><form:input path="name" class="form-control"  />
							<form:errors path="name" class="text-danger" /></td>
					</tr>
					<tr>
						<td>Skill Level(1-5) :</td>
						<td><form:input type="number" path="level" class="form-control"  />
							<form:errors path="level" class="text-danger" /></td>
					</tr>
					<tr>
						<td>Game Day :</td>
						<td><form:input path="day" class="form-control"  />
							<form:errors path="day" class="text-danger" /></td>
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="2"><input class="btn btn-success form-control" type="submit"
							value="Submit" /></td>
					</tr>
				</tfoot>
			</table>
		</form:form>
		<a href="/teams/${pro.id }/delete">delete</a>
	</div>
</body>
</html>