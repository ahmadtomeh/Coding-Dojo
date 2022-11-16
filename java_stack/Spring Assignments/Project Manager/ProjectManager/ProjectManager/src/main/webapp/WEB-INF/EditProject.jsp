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
<div class = "container col-12"><br><br>
	<h1>Edit Project</h1>
	<form:form action="/projects/${pro.id }/edit" method="post" modelAttribute="pro">
	<input type="hidden" name="_method" value="put">
		<p>
			<form:input type="hidden" path="user" value = "${user_id}"/>
		</p>
		<p>
		<form:errors path="title" class="text-danger" />
		</p>
		<p>
			<form:label class="col-2" path="title">Project Title : </form:label>
			<form:input path="title" />
		</p>
		<p>
		<form:errors path="description" class="text-danger" />
		</p>
		<p>
			<form:label class="col-2" path="description">Project Description : </form:label>
			<form:input path="description" />
		</p>
		<p>
		<form:errors path="dueDate" class="text-danger" />
		</p>
		<p>
			<form:label class="col-2" path="dueDate">Due Date : </form:label>
			<form:input type = "Date" path="dueDate" />
		</p>
		<a class = "btn btn-danger" href="/home">Cancel</a>
		<input class = "btn btn-success" type="submit" value="Submit" />
	</form:form>
	
	</div>
</body>
</html>