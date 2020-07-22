<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	tr {
		background-color: orange;
		color:white;
	}
	
	th {
		background-color: orange;
		color: white;
	}
</style>
</head>
<body>
<center>
	<h1> Search Emplyee Record </h1> <hr/>
	<form action="find" method="post">
		<table border="5" width=84%>
		<tr>
			<td>Find by Empid</td>
			<td> <input type="text" name="empid"> </td>
			
			<td>Find by EmpName</td>
			<td> <input type="text" name="empname"> </td>
			
			<td>Find by Address</td>
			<td> <input type="text" name="address"> </td>
			<td> <input type="submit" value="SEARCH"> </td>
		</tr>
		</table>
	</form>
	 <hr/>
	 
	 <table border="5" width=50%>
	 	<tr>
	 		<th> Employee Id </th>
	 		<th> Employee Name </th>
	 		<th> Employee Address</th>
	 	</tr>
	 		<c:forEach var="tab" items="${data }">
	 	<tr>
	 		<td> ${tab.empid } </td>
	 		<td> ${tab.empname } </td>
	 		<td> ${tab.address} </td>
	 	</tr>
	 	</c:forEach>
	 </table>
	
	<br/>
	<h2> ${msg } </h2>
</center>
</body>
</html>