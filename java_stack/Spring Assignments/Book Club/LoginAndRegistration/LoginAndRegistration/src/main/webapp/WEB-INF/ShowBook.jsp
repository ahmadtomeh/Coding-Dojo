<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="d-flex justify-content-between col-12">
		<h1>${ books.title}!</h1>
		<p>
			<a href="/home">back to the shelves</a>
		</p>
	</div>
		<p>Books from everyone's shelves:</p>
		<br>
		
		<h3><c:choose>
         
         <c:when test = "${books.user.id != user_id}">
            <span class="text-danger">${ books.user.userName}</span>
         </c:when>

         
         <c:otherwise>
            <span class="text-danger">You</span>
         </c:otherwise>
      </c:choose>
		
			 read <span
				class="text-info">${ books.title}</span> by <span
				class="text-success">${ books.author}</span>
		</h3>
		<c:choose>
         
         <c:when test = "${books.user.id != user_id}">
            <h5>Here are ${ books.user.userName}'s thoughts:</h5>
         </c:when>

         
         <c:otherwise>
         <h5>Here are your thoughts:</h5>
         </c:otherwise>
      </c:choose>
		
		<hr>
		<p class="container">${ books.description}</p>
		<hr>
		<c:choose>
         
         <c:when test = "${books.user.id != user_id}">
            <input class = "btn-danger" type="submit" disabled="disabled" value="Delete" />
            <input class = "btn-danger" type="submit" disabled="disabled" value="Edit" />
         </c:when>

         
         <c:otherwise>
         <div  class = "d-flex">
         <form:form action="/delete/${book.id }" method="delete" modelAttribute="book">
         <input class = "btn-danger" type="submit" value="Delete" />
         </form:form>
         <form:form action="/books/${book.id }/edit" method="get" modelAttribute="book">
         <input class = "btn-danger" type="submit" value="Edit" />
         </form:form>
         </div>
         </c:otherwise>
      </c:choose>
	</div>
</body>
</html>