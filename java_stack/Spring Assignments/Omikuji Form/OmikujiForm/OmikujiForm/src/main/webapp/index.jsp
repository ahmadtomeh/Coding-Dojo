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
div {
text-align: start;
padding-left: 2%;
}
</style>
<body>
 <form action='/git' method='POST'>
<center>
<h1>Send an Omikuji!</h1>
<div style = "border-style: solid; width: 20%">
<p>Pick any number from 5 to 25	</p>
  <input type="number" max="25" min="5" name= "year"/>
<p>Enter the name of any city.</p>
<input type="text" name="city"/>
<p>Enter the name of any real person.</p>
<input type="text" name="person"/>
<p>Enter professional endeavor or hobby:</p>
<input type="text" name = "hobby"/>
<p>Enter any tybe of living thing.</p>
<input type="text" name = "living"/>
<p>Say something nice to someone:</p>
<textarea rows="5" cols="20" name = "something"></textarea>
<p>Send and show a friend</p>
<p><input type="submit" value = "Send"/></p>
</div>
</center>
</form>
</body>
</html>