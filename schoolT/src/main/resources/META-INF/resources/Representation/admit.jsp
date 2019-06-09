<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admit Students</title>
</head>
<body>

<FORM ACTION="http://localhost:8080/School/admitStudentHome.htm">
Enrollment Number:
<input type="TEXT" id="enrollmentNumber" NAME="enrollmentNumber" ><BR>

<input type="SUBMIT" Name="search"> 
</FORM>


<form:form method="POST"  action="admit.htm" commandName="student_enrolled">
	<table id="studentDetails">
		<tr>
		<td><form:input path="enrollmentNumber" /></td>
			<td>UserName :</td>
			
			
			<td><form:input path="user.username" /></td>			
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>			

			<td>Admission seeking to class :</td>
			<td><form:input path="standardSeekingAdmission" /></td>						
			
		</tr>
		
		<tr>
		
			<td>Father's Name :</td>
			<td><form:input path="parent.fatherName" /></td>
					
			<td>Mother's Name :</td>
			<td><form:input path="parent.motherName" /></td>
			
		</tr>
		
		<tr>
		
			<td>Father's Contact Number :</td>
			<td><form:input path="parent.fatherContactNumber" /></td>
					
			<td>Mother's Contact Number :</td>
			<td><form:input path="parent.motherContactNumber" /></td>
			
		</tr>
		
		
		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="Male" label="M" /> 
				<form:radiobutton path="gender" value="Female" label="F" /></td>
				
		</tr>
		
		<tr><td>Address:</td>
		</tr>
		
		<tr>
			<td>Flat No. :</td>
			<td><form:input path="user.address.flatno" /></td>
					
				
			<td>House No. :</td>
			<td><form:input path="user.address.houseNo" /></td>		
		
		</tr>
		
		<tr>		
			<td>Street :</td>
			<td><input type ="text" name ="user.address.street" /></td>
		
			<td>Sector	:</td>
			<td><form:input path="user.address.sector" /></td>
		</tr>
		
		<tr>		
			<td>City :</td>
			<td><form:input path="user.address.city" /></td>
		
			<td>State :</td>
			<td><form:input path="user.address.state" /></td>
		</tr>
		
		<tr>	
		
			<td>Pin Code :</td>
			<td><form:input path="user.address.pin" /></td>
				
			<td>Country :</td>
			<td><form:input path="user.address.country" /></td>
		</tr>
		
		<tr>
			<c:choose>
			<c:when test="${student_enrolled.status eq 'admitted'}"><td colspan="2">${student_enrolled.status}<input type="submit" Name="Admit" disabled ="disabled"></td></c:when>
			
			<c:otherwise><td colspan="2">${student_enrolled.status}<input type="submit" Name="Admit" ></td></c:otherwise>
			
			</c:choose>
			
		</tr>
				
	</table>
			
</form:form>


</body>
</html>