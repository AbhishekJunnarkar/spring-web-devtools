<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Todo Page</title>
</head>
<body>
	Add todo page for ${name}

	<form method="post" modelAttribute="todo">
		Description : <input name="desc" type="text" /><input type="submit">

	</form>
</body>
</html>