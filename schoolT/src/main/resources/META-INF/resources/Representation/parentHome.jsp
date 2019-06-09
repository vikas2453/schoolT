<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="JS/parentHome.js"></script>
<script type="text/javascript" src="JS/address.js"></script>
<link rel="stylesheet" href="/School/CSS/table.css" type="text/css">
</head>
<body>
<%@include file="Include/header.jsp" %>	
<br><br>
<img width="200" height="200" src="studentImage.htm"/>
<div>
Welcome Mr. ${student.student_enrolled.parent.fatherName} & Mrs.${student.student_enrolled.parent.motherName} ,
This month's Report card for ${student.student_enrolled.name} 
<br><br>
<a href="" onclick="viewAddressForm(event)">update address details s</a>
<a href="" onclick="veiwQueryForm(event)">Write to class teacher</a>
<a href="" onclick="fetchParentPendingQuery(event)">View my previous queries</a>
<a href ="" onclick="viewTestResults(event)">View test result</a>
<a href ="" onclick="applyLeave(event)">Apply Leave</a>
<a href ="" onclick="viewAttendance(event)">View my attendance</a>
</div>
<div id="testResults" class="CSSTableGenerator"></div>
<div id="parentQuery" class="CSSTableGenerator"></div>
<div id="address"></div>
<div id="query"></div>
<div id="applyLeave"></div>

<%@include file="Include/footer.jsp" %>		
</body>
</html>