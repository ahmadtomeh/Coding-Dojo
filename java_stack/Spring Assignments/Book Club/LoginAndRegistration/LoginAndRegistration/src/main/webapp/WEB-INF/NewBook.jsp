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
	<h1>New Book</h1>
	<a href="/home">back to the shelves</a>
	
	<form:form action="/books/new" method="post" modelAttribute="book">
		<p>
			<form:input type="hidden" path="user" value = "${user_id}"/>
		</p>
		<p>
		<form:errors path="title" class="text-danger" />
		<form:errors path="author" class="text-danger" />
		<form:errors path="description" class="text-danger" />
		</p>
		<p>
			<form:label path="title" style="width: 10%">Title : </form:label>
			<form:input path="title" />
		</p>
		<p>
			<form:label path="author" style="width: 10%">Author : </form:label>
			<form:input path="author" />
		</p>
		<p>
			<form:label path="description" style="width: 10%">My Thoughts : </form:label>
			<form:input path="description" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>