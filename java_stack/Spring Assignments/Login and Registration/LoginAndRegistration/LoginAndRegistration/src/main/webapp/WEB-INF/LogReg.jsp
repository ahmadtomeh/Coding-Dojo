<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<h1 class = "text-info container">Welcome!</h1>
    <p class = "container">Join our growing community.</p>
<div class = "d-flex justify-content-around progress-bar-striped">
    <form:form action="/register" method="post" modelAttribute="newUser" class = "col-4">
    
    <h3 class = "text-dark">Register</h3><br>
        <div class="form-group d-flex">
            <label class="col-4">User Name:</label>
            <div class="col-8">
            <form:input path="userName" class="form-control" />
            <small><form:errors path="userName" class="text-danger" /></small>
            </div>
        </div>
        <br>
        <div class="form-group d-flex">
            <label class="col-4">Email:</label>
            <div class="col-8">
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
            </div>
        </div>
        <br>
        <div class="form-group d-flex">
            <label class="col-4">Password:</label>
            <div class="col-8">
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
            </div>
        </div>
        <br>
        <div class="form-group d-flex">
            <label class="col-4">Confirm Password:</label>
            <div class="col-8">
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
            </div>
        </div>
        <br>
        <div class = "col-12 ">
        <input type="submit" value="Register" class="btn btn-primary" />
        </div>
    </form:form>

    <form:form action="/login" method="post" modelAttribute="newLogin" class = "col-4">
    
        <h3 class = "text-dark">Login</h3><br>
    
        <div class="form-group  d-flex">
            <label class="col-4">Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <br>
        <div class="form-group  d-flex">
            <label class="col-4">Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <input type="submit" value="Login" class="btn btn-success" />
    </form:form>
</div>
</body>
</html>