<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<h1>${book.title}</h1>
<p>Description:${book.description}</p>
<p>language:${book.language}</p>
<p>Number of Pages:${book.numberOfPages}</p>
</body>
</html>