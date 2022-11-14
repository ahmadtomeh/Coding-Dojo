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
	<h1>Change Your Entry</h1>
	<a href="/home">Dashboard</a>
	<form:form action="/books/${books.id}" method="post"
		modelAttribute="books">
		<input type="hidden" name="_method" value="put">
		
		<p>
			<form:input type="hidden" path="user" value = "${user_id}"/>
			<form:input type="hidden" path="userborrow" value = "${books.userborrow.id}"/>
		</p>
		<p>
			<form:label path="title" style="width: 10%">Title : </form:label>
			<form:input path="title" />
			<form:errors path="title" class="text-danger" />
		</p>
		<p>
			<form:label path="author" style="width: 10%">Author : </form:label>
			<form:input path="author" />
			<form:errors path="author" class="text-danger" />
		</p>
		<p>
			<form:label path="description" style="width: 10%">My thoughts : </form:label>
			<form:input path="description" />
			<form:errors path="description" class="text-danger" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
	<a class = "btn btn-danger" href="/books/${books.id }/delete"> Delete Book</a>
</body>
</html>