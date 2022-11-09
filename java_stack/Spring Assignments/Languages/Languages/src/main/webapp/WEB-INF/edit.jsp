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
	<form action="/languages/${languages.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<a href="#">Delete</a>
	</form>
	<a href="/languages">Dashboard</a>
	<form:form action="/languages/${languages.id}" method="post"
		modelAttribute="languages">
		<input type="hidden" name="_method" value="put">
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