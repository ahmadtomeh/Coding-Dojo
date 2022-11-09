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
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="languages" items="${languages}">
				<tr>
					<td><a href="/languages/${languages.id}">${languages.name}</a></td>
					<td><c:out value="${languages.creator}"></c:out></td>
					<td><c:out value="${languages.version}"></c:out></td>
					<td><a href="/languages/${languages.id}/delete">Delete</a>
					<td><a href="/languages/${languages.id}/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name" style="width: 10%">Name : </form:label>
			<form:input path="name" />
			<form:errors path="name" class="text-danger" />
		</p>
		<p>
			<form:label path="creator" style="width: 10%">Creator : </form:label>
			<form:input path="creator" />
			<form:errors path="creator" class="text-danger" />
		</p>
		<p>
			<form:label path="version" style="width: 10%">Version : </form:label>
			<form:input type="number" path="version" />
			<form:errors path="version" class="text-danger" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>