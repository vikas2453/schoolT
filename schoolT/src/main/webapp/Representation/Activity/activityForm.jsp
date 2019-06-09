<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrollment form</title>
 <link type="text/css" rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/themes/ui-lightness/jquery-ui.css" />


       <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> 

 

       <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>



<script type="text/javascript" src="JS/activityForm.js"></script>



</head>
<body>
<%@include file="../Include/header.jsp" %>	


Student enrollment form
<form:form method="POST"  commandName="activity">
	<table>
		<tr>
			<td>Activity Name :</td>
			<td><form:input path="activityName" />
			</td><td><font color="red"><form:errors path="activityName"/></font></td>
			
			<td>Description</td>
			<td><form:input path="description" /></td>	
			<td><font color="red"><form:errors path="description"/></font></td>			
			
		</tr>
		
		<tr>
		
			<td>Activity Date :</td>
			<td><input type="text" id="performDate1" /></td>
			
		
			<td>Level :</td>
			<td><form:input path="level" /></td>
			
		</tr>
		<tr>
		<td>Location of activity:</td>
		<td><form:input path="location" /></td>
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

