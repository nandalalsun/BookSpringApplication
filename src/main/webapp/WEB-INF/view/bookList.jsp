<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Books currently in the shop</title>
</head>

<body>
	<h1>Book currently in the shop</h1>
	<table>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.isbn}</td>
				<td><a href="books/${book.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="books/add"> Add a Book</a>
	<a href="logout">Logout</a>
</body>

</html>