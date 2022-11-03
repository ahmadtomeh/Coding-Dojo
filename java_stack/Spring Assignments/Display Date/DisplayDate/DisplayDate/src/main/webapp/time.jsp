<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<script type="text/javascript" src="js/time.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Style.css">
</head>
<body>
<a href="/">Dashboard</a>
<center>
<h1 class = "time"><c:out value = "${date }"></c:out></h1>
</center>
</body>
</html>