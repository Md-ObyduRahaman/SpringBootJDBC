<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	th {
		background-color: orange;
		color: white;
	}
	
.btn_update {
	background-color: #0bda51;
	color: white;
}

.btn_delete {
	background-color: red;
	color: white;
}
</style>
</head>
<body>
<center>
<h1> Display Employee Record</h1>  <hr/>

<table border="5" width="600px">
	<tr>
		<th> Employee ID </th>
		<th> Employee Name </th>
		<th> Employee Address</th>
		<th> Update </th>
		<th> Delete </th>
	</tr>
		<c:forEach var="tab" items="${data }">
		<form action="update" method="post">
	<tr>
		<td> <input type="text" value="${tab.empid }" name="empid" readonly> </td>
		<td> <input type="text" value="${tab.empname }" name="empname"> </td>
		<td> <input type="text" value="${tab.address }" name="address"> </td>
		<td> <input type="submit" value="UPDATE" class="btn_update"> </form></td>
		<td>
			<form action="delete" method="post">
				<input type="hidden" value="${tab.empid }" name="empid">
				<input type="submit" value="DELETE" class="btn_delete">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>
<hr/>
<h2> ${msg } </h2>
</center>

</body>
</html>