<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo's List for ${name}</title>
</head>
<body>
<h1>Your Todo's list</h1>
<table>
	<caption>Your Todo's are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<th>${todo.desc}</th>
				<th>${todo.targetDate}</th>
				<th>${todo.done}</th>
			</tr>
		</c:forEach>
		</tbody>
</table>
<br/>
<a href="/add-todo">Add a Todo</a>
</body>
</html>