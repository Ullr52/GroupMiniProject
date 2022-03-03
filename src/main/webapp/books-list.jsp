<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>book List</title>
</head>
<body>
<div class="container">
<h2>My Library Books Available</h2>
<form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allBooks}" var="currentbooks">
			<tr>
				<td><input type="radio" name="id" value="${currentbooks.id}"></td>
				<td>${currentbooks.publisher}</td>
				<td>${currentbooks.title}</td>
				<td>${currentbooks.genre}</td>
			</tr>
		</c:forEach>
	</table>
	
		
		<input type="submit" value="edit" name="doThisToBook"> <input
			type="submit" value="delete" name="doThisToBook"> <input
			type="submit" value="add" name="doThisToBook">
	</form>
	</div>
</body>
</html>