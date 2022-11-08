<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>

</head>
<body>
	<h1>All Books</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneBook" items="${books}">
				<tr>
					<td>${oneBook.id}</td>
					<td><a href = "/books/${oneBook.id}">${oneBook.title}</a></td>
					<td>${oneBook.language}</td>
					<td>${oneBook.numberOfPages}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>