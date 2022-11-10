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
<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninjas">
	<p>
	<form:label path="dojo" style="width: 10%">Dojo : </form:label>
		<form:select path="dojo">
			<c:forEach var="oneDojo" items="${dojos}">
				<form:option value="${oneDojo.id}" path="dojo">
				${oneDojo.name}
				</form:option>
			</c:forEach>
		</form:select>
		</p>
		<p>
			<form:label path="firstName" style="width: 10%">First Name : </form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" class="text-danger" />
		</p>
		<p>
			<form:label path="lastName" style="width: 10%">Last Name : </form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" class="text-danger" />
		</p>
		<p>
			<form:label path="age" style="width: 10%">Age : </form:label>
			<form:input type="number" path="age" />
			<form:errors path="age" class="text-danger" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>