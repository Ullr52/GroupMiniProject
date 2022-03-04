<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> book list</title>
</head>
<body>
<h2>Borrower book lists</h2>
	<form method="post" action="booksListNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allBooks}" var="currentbooklist">
				<tr>
					<td><input type="radio" name="id" value="${currentbooklist.id}"></td>
					<td><h3>${currentbooklist.borrowerListName}</h3></td>
				</tr>
				<tr>
					<td colspan="3">Trip Date: ${currentbooklist.borrowDate}</td>
				</tr>
				<tr>
					<td colspan="3">Borrower: ${currentbooklist.borrower.borrowerName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentbooklist.listOfBooks}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.publisher}, ${listVal.title}, ${listVal.genre}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToBooksList"> <input
			type="submit" value="delete" name="doThisToBooksList"> 

	</form>
	<a href="addBooksForListServlet">Create a new borrower book list</a>
	<br />
	<a href="index.html">Add a new book to the library</a>
</body>
</html>