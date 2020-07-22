<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1> New Employee Register</h1> <hr/>
<form action="add" method="post">
	<table border="5" width="300px">
	<tr>
		<td>Employee ID </td>
		<td><input type="text" name="empid"> </td>
	</tr>
	<tr>
		<td>Employee Name </td>
		<td><input type="text" name="empname"> </td>
	</tr>
	<tr>
		<td>Employee Address </td>
		<td><input type="text" name="address"> </td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" name="Register"></td>
	</tr>
	</table>
</form>
<hr/>
<h2> ${msg } </h2>
</center>
</body>
</html>