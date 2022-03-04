<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new book list</title>
</head>
<body>
<h2>What I want from the Library</h2>
	<form action="createNewBooksListServlet" method="post">
		Borrower List Name: <input type="text" name="borrowerListName"><br /> 
		Day going to the library: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input type="text" name="year" placeholder="yyyy" size="4"> 
		Borrower Name: <input type="text" name="borrowerName"><br /> 
		
		Available books:<br /> <select name="allBooksToAdd" multiple size="15">
			<c:forEach items="${requestScope.allBooks}" var="currentbooks">
				<option value="${currentbooks.id}">${currentbooks.publisher} | ${currentbooks.title} | ${currentbooks.genre}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create book list and add books">
	</form>
	<a href="index.html">Add new Books Here.</a>
</body>
</html>