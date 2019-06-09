<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../Include/header.jsp" %>	
<br><br>
<img width="200" height="200" src="studentImage.htm"/>
<div>
welcome Mr. ${student.student_enrolled.parent.fatherName} & Mrs.${student.student_enrolled.parent.motherName} ,
This month's Report card for ${student.student_enrolled.name} 
<br><br>
<a href="updateDetails.htm">update address details s</a>
<a href="query.htm">Write to class teacher</a>
<a href="queryToPrincipal.htm">Write to Principal</a>
<a href="viewQuery.htm">View my previous queries</a>
</div>
<table>
<c:forEach var="testResults" items="${student.testResults}">
  <tr><td>${testResults.test.subject.subjectName}</td> <td>${testResults.test.testType}</td>  <td>${testResults.test.maxMarks}</td> <td>${testResults.marksObtained}</td> <td>${testResults.status}</td> <td>${testResults.remarks}</td></tr>
</c:forEach>
</table>
<%@include file="../Include/footer.jsp" %>		
</body>
</html>