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
<script type="text/javascript" src="JS/allQuery.js"></script>
<script type="text/javascript" src="JS/thome.js"></script>
<script type="text/javascript" src="JS/address.js"></script>
<link rel="stylesheet" href="/School/CSS/table.css" type="text/css">
</head>
<body>
<%@include file="../Include/header.jsp" %>	
Welcome ${teacher.name}, Your class is <a href="" onclick="KakshaDetails(event)">${teacher.kaksha.standard}${teacher.kaksha.section}</a>
Create a test 
<a href="" onclick="viewAddressForm(event)">update address details s</a>
<a href="createActivity.htm">Create an activity</a>
<a href="attendence.htm">Attendence</a>
Upload test results
View test result of my class
View test result of my subject
View test result by individual 
<a href="" onclick="fetchTeacherPendingQuery(event)">View all my pending queries</a>
<div id="teacherpendingQuery" class="CSSTableGenerator"></div>
<div id="KakshaDetails" class="CSSTableGenerator"></div>
<div id="address"></div>
<%@include file="../Include/footer.jsp" %>		
</body>
</html>