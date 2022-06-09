<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Book</title>
</head>

<body>
<%--	<c:if test="${msg == 'Update'}">--%>
<%--		<form  modelAttribute="book" action="../books/${book.id}" method="post">--%>

<%--	</c:if>--%>
<%--	<c:if test="${msg == 'Add'}">--%>
		<form:form  modelAttribute="book" action="../books/add" method="post">
<%--	</c:if>--%>
		<form:errors path="*" cssClass="errorblock" element="div" />

	<table>
<%--		<sec:csrfInput />--%>
		<tr>
			<td>Title:</td>
			<td><input type="text" path="title" name="title" value="${book.title}" /> </td>
			<td><form:errors path="title" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" path="author" name="author" value="${book.author}" /> </td>
			<td><form:errors path="author" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" path="price" name="price" value="${book.price}" /> </td>
			<td><form:errors path="price" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" path="isbn" name="isbn" value="${book.isbn}" /> </td>
			<td><form:errors path="isbn" cssClass="error" /> </td>
		</tr>
	</table>
	<input type="submit" value="${msg}"/>
		<sec:csrfInput />
		</form:form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="put">
			<sec:csrfInput />
			<button type="submit">Delete</button>
		</form>
	</c:if>
</body>

</html>