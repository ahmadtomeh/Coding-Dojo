<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<style>
div div {
text-align: start;
padding-left: 5%;
width: 30%;
background-color: blue;
border-style: solid;
}
.container{
margin-left: 40%;
}

a{
padding-left: 14%;
}
</style>
<body>
<div class = "container">
<h1>Here's Your Omikuji!</h1>
<div>
<h2>In <span>${year}</span> years, you will<br>
live in <span>${city}</span> with<br>
<span>${person }</span> as your<br>
roommate, <span>${hobby }</span><br>
for a living.<br>
The next time you<br>
see a <span>${living }</span>, you will<br>
have good luck.<br>
Also, <span>${something }</span>.</h2>
</div>
<a href = "/omikuji">Go Back</a>
</div>
</body>
</html>