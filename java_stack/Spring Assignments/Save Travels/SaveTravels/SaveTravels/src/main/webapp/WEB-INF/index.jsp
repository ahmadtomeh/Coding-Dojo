<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
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
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><c:out value="${expense.name}"></c:out></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add an Expense:</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense : </form:label>
        <form:input path="name"/>
        <form:errors path="name" class="text-danger"/>
    </p>
    <p>
        <form:label path="vendor">Vendor : </form:label>
        <form:input path="vendor"/>
        <form:errors path="vendor" class="text-danger"/>
    </p>
    <p>
        <form:label path="amount">Amount : </form:label>
        <form:input type="number" path="amount"/>
        <form:errors path="amount" class="text-danger"/>  
    </p> 
    <p>
        <form:label path="description">Description :</form:label>
        <form:textarea path="description"/>
        <form:errors path="description" class="text-danger"	/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>