<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cafe Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<center>
	<div class="d-block justify-content-center progress-bar-striped">
	<h1 class="text-info container">Welcome!</h1>
		<form:form action="/register" method="post" modelAttribute="newUser"
			class="col-4">
			<table class="table table-bordered border border-dark container">
				<thead>
					<tr>
						<th class="jumbotron text-center" colspan="2"><h3>Register</h3></th>
						
					</tr>
				</thead>
				<tbody>
				<tr>
					<td>User Name:</td>
					<td>
					<form:input path="userName" class="form-control" />
					<form:errors path="userName" class="text-danger" />
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
					</td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td>
					<form:password path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
					</td>
				</tr>
				</tbody>
				<tfoot>
				<tr>
				<td colspan="2">
				<input type="submit" value="Register" class="btn btn-primary form-control" />
				</td>
				</tr>
				</tfoot>
			</table>
		</form:form>

		<form:form action="/login" method="post" modelAttribute="newLogin"
			class="col-4">
			
			
			<table class="table table-bordered border border-dark container">
				<thead>
					<tr>
						<th class="jumbotron text-center" colspan="2"><h3>Log In</h3></th>
						
					</tr>
				</thead>
				<tbody>
				<tr>
					<td>Email:</td>
					<td>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
					</td>
				</tr>
				</tbody>
				<tfoot>
				<tr>
				<td colspan="2">
				<input type="submit" value="Log In" class="btn btn-primary form-control" />
				</td>
				</tr>
				</tfoot>
			</table>
		</form:form>
	</div>
	</center>
</body>
</html>
