<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Change</title>
</head>
<body>
<%@include file="Include/header.jsp" %>	
	<form:form method="POST" commandName="user">
		<table>
			<tr>
				<td>UserId:</td>
				<td><form:input path="userId" /></td>			
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><form:password path="password"/></td>			
			</tr>
			
			<tr>
				<td>Confirm Password: </td>
				<td><form:password path="password"/></td>			
			</tr>
			
			<tr>
				<td></td>
				<td colspan="2"><input type="submit"></td>		
			</tr>
			
		</table>
		
	</form:form>
	<br><br>
<%@include file="Include/footer.jsp" %>	

</body>
</html>