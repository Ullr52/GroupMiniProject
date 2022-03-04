<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit books</title>
</head>
<body>
<h2>Edit a library book</h2>
<form action = "editBookServlet" method="post">
Publisher: <input type ="text" name = "publisher" value= "${booksToEdit.publisher}">
Title: <input type = "text" name = "title" value= "${booksToEdit.title}">
Genre: <input type = "text" name = "genre" value= "${booksToEdit.genre}">
<input type = "hidden" name = "id" value="${booksToEdit.id}">
<input type = "submit" value="Save Edited Book">
</form>
</body>
</html>