<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit book lists</title>
</head>
<body>
<h2>Edit your library book list</h2>
	<form action="editBooksDetailsServlet" method="post">
		<input type="hidden" name="id" value="${booksListToEdit.id}"> 
		List Name: <input type="text" name="borrowerListName" value="${booksListToEdit.borrowerListName}"><br /> 
		Library Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4"
			value="${date}">, <input type="text" name="year"
			placeholder="yyyy" size="4" value="${year}"> 
			Borrower Name: <input type="text" name="borrowerName" value="${booksListToEdit.borrower.borrowerName}"><br /> 
			Available Books:<br /> <select name="allBooksToAdd" multiple size="6">
			<c:forEach items="${requestScope.allBooks}" var="currenbooks">
				<option value="${currenbooks.id}">${currenbooks.publisher}|
					${currenbooks.title} | ${currenbooks.genre}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit your book list and exchange books">
	</form>
	<a href="index.html">Add new books here.</a>
</body>
</html>