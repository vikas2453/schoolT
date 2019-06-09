<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="JS/allQuery.js"></script>
<script type="text/javascript" src="JS/thome.js"></script>
<link rel="stylesheet" href="/School/CSS/table.css" type="text/css">
</head>
<body>
<%@include file="../Include/header.jsp" %>	
Welcome ${teacher.name}, Your class is <a href="" onclick="KakshaDetails(event)">${teacher.kaksha.standard}${teacher.kaksha.section}</a>
Create a test 
<a href="createActivity.htm">Create an activity</a>
<a href="attendence.htm">Attendence</a>
Upload test results
View test result of my class
View test result of my subject
View test result by individual 
<a href="" onclick="fetchTeacherPendingQuery(event)">View all my pending queries</a>
<div id="teacherpendingQuery" class="CSSTableGenerator"></div>
<div id="KakshaDetails" class="CSSTableGenerator"></div>
<form:form method="POST" commandName="studentListForm">
<table>

<c:forEach var="student" items="${studentListForm.studentList}" varStatus="i">
<form:hidden path="studentList[${i.index}].admissionNumber"/>
<form:input path="studentList[${i.index}].student_enrolled.name"></form:input>
<form:select path="studentList[${i.index}].todayAttendance.status" items="${status}"></form:select>
</c:forEach>  

</table>
<input type="submit">
</form:form>


<%@include file="../Include/footer.jsp" %>		
</body>
</html>