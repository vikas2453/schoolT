<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New School Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>



</head>
<body>
<%@include file="../Include/header.jsp" %>	


School Details
<form:form method="POST"  commandName="school">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" />
			</td><td><font color="red"><form:errors path="name"/></font></td>
		</tr>
		
		<tr><td>Address:</td>
		</tr>
		
		<tr>
			<td>Flat No. :</td>
			<td><form:input path="address.flatno" /></td>
					
				
			<td>House No. :</td>
			<td><form:input path="address.houseNo" /></td>		
		
		</tr>
		
		<tr>		
			<td>Street :</td>
			<td><input type ="text" name ="address.street" /></td>
		
			<td>Sector	:</td>
			<td><form:input path="address.sector" /></td>
		</tr>
		
		<tr>		
			<td>City :</td>
			<td><form:input path="address.city" /></td>
		
			<td>State :</td>
			<td><form:input path="address.state" /></td>
		</tr>
		
		<tr>			
			<td>Pin Code :</td>
			<td><form:input path="address.pin" /></td>
				
			<td>Country :</td>
			<td><form:input path="address.country" /></td>
		</tr>
		
			
			<tr>
		
			<td colspan="2"><input type="submit"></td>
		</tr>
			
	</table>
</form:form>


<br><br>
<%@include file="../Include/footer.jsp" %>	
</body>
</html>

