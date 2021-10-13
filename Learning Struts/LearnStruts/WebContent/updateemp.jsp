<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateemp" method="post">
Employee id 
	<input type = "number" name = "id" ><br>
	Employee name
	<input type = "text" name = "name" ><br>
	Employee address
	<input type = "text" name = "address" >
	<br><br>
	<input type = "submit" value = "Update">
</form>
<br>
<br>
<a href="/LearnStruts/"> Homepage</a>

</body>
</html>