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
	<h1>Save Travels</h1>
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Action</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expenses/${expense.id}">${expense.name}</a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td><a href="/expenses/edit/${expense.id}">Edit</a></td>
					<td><form action="/expenses/${expense.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class = "btn btn-danger">
					</form></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add an Expense:</h1>
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<p>
			<form:label path="name" style = "width: 10%">Expense : </form:label>
			<form:input path="name" />
			<form:errors path="name" class="text-danger" />
		</p>
		<p>
			<form:label path="vendor" style = "width: 10%">Vendor : </form:label>
			<form:input path="vendor" />
			<form:errors path="vendor" class="text-danger" />
		</p>
		<p>
			<form:label path="amount" style = "width: 10%">Amount : </form:label>
			<form:input type="number" path="amount" />
			<form:errors path="amount" class="text-danger" />
		</p>
		<p>
			<form:label path="description" style = "width: 10%">Description :</form:label>
			<form:textarea path="description" />
			<form:errors path="description" class="text-danger" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>