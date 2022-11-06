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
* {
	margin: 0 auto;
	font-family: cursive;
}

section {
	display: flex;
	justify-content: space-around;
	margin-top: 5%;
}

div p {
	font-size: larger;
}

.box {
	border: 2px solid black;
	width: 250px;
	height: 250px;
	text-align: center;
	display: flex;
	flex-direction: column;
	justify-content: space-evenly;
	align-items: center;
}

.title {
	font-size: xx-large;
}

.title2 {
	font-size: xx-large;
	margin-left: 2%;
	margin-top: 1%;
	margin-bottom: 1%;
}

input {
	width: 50%;
	height: 10%;
	box-shadow: 3px 3px black;
	border: 1px solid black;
}

.activities {
	overflow-y: scroll;
	transition: all;
	width: 95%;
	height: 190px;
	border: 2px solid black;
}

.p {
	margin-left: 3%;
}

label {
	padding-top: 10%;
}
</style>
<body>
	<p>
		<label class="title">Your Gold :</label> <label class="title">${gold}</label>
	</p>
	<form action='/process_money' method='GET'>
		<section>
			<div class="box">
				<p class="title">Farm</p>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="which" value="Farm"> <input
					type="submit" value="Find Gold!">
			</div>
	</form>
	<form action='/process_money' method='post'>
		<div class="box">
			<p class="title">Cave</p>
			<p>(earns 10-20 gold)</p>
			<input type="hidden" name="which" value="Cave"> <input
				type="submit" value="Find Gold!">
		</div>
	</form>
	<form action='/process_money' method='post'>
		<div class="box">
			<p class="title">House</p>
			<p>(earns 10-20 gold)</p>
			<input type="hidden" name="which" value="House"> <input
				type="submit" value="Find Gold!">
		</div>
	</form>
	<form action='/process_money' method='post'>
		<div class="box">
			<p class="title">Quest</p>
			<p>
				(earns/takes<br>0 - 50 gold)
			</p>
			<input type="hidden" name="which" value="Quest"> <input
				type="submit" value="Find Gold!">
		</div>
	</form>
	</section>
	<p class="title2">Activities :</p>
	<div class="activities">
		<c:forEach var="a" items="${msg}">
				<c:choose>
          <c:when test="${a.contains('lost')}">
            <p style = "color: red">
            <c:out value="${a}"></c:out></p>
            </c:when>
            <c:otherwise>
            <p style = "color: green">
            <c:out value="${a}"></c:out></p>
            </c:otherwise>
            </c:choose>
			</c:forEach>

		
	</div>

</body>
</html>