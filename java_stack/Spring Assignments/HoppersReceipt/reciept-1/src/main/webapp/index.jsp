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
<h1>Customer Name : <c:out value="${name}"/></h1>
<h2>Item Name : <c:out value="${item}"/></h2>
<h2>Price : <c:out value="${price}"/></h2>
<h2>Description : <c:out value="${des}"/></h2>
<h2>Vendor : <c:out value="${vendor}"/></h2>
</body>
</html>