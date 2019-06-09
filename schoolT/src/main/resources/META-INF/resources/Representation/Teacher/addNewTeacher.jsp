<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrollment form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="JS/enrollmentform.js"></script>


</head>
<body>
<%@include file="../Include/header.jsp" %>	

Teacher form
<form:form method="POST" commandName="teacher" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" />
			</td><td><font color="red"><form:errors path="name"/></font></td>
			
			<!-- here we will be implementing logic to check the availability of seats for 
			every class so that user can check this before proceeding with the registration -->
			<td>Highest qualification : </td>
			<td><form:input path="highestQualification" /></td>	
			<td><font color="red"><form:errors path="highestQualification"/></font></td>			
			
		</tr>
		
		<tr>
		
			<td>Primary Subjects : </td>
			<td><form:input path="primarySubject" /></td>
			<td><font color="red">needs to be changed to drop down with subjects in the drop down<form:errors path="secondaySubject"/></font></td>
		
			<td> Secondary subjects:</td>
			<td><form:input path="secondaySubject" /></td>
			<td><font color="red">needs to be changed to drop down with subjects in the drop down<form:errors path="secondaySubject"/></font></td>
		</tr>
		<tr>
		<td>Upload photo :</td>
		<td><input type="file" name="photo" size="50" /></td>
		
		<td>Upload resume :</td>
		<td><input type="file" name="resume" size="50" /></td>
		</tr>
		
		<tr>
		
			<td>Contact Number :</td>
			<td><form:input path="contactNumber" /></td>
			<td><font color="red"><form:errors path="contactNumber"/></font></td>
		
			<td>Months of teaching experience :</td>
			<td><form:input path="monthsOfExperience" /></td>
			<td><font color="red"><form:errors path="monthsOfExperience"/></font></td>
		</tr>
		
		
		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="Male" label="M" /> 
				<form:radiobutton path="gender" value="Female" label="F" /></td>
				<td><font color="red"><form:errors path="gender"/></font></td>
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
			<td>UserId :</td>
			<td><form:input id="userId" path="user.username" onblur="validateUserId()"/></td>
			<td><p id ="userIdError"></p>

			
		</tr>
		
		<tr>
				
			<td>Password :</td>
			<td><form:input path="user.password" /></td>
			
			<td>Confirm Password :</td>
			<td><form:input path="user.confirmPassword" /></td>
		</tr>
		<tr>
				
			<td>Security Question :</td>
			<td><form:input path="user.securityQuestion" /></td>
			
			<td>Security Answer :</td>
			<td><form:input path="user.securityAnswer" /></td>
			
			
		</tr>
		
		<tr>
				
			<td>Email address :</td>
			<td><form:input path="user.emailaddress" /></td>	
			
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

