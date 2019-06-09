<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="styleSheet" href="/School/CSS/query.css" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="JS/allQuery.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../Include/header.jsp" %>	
<br><br>
<img width="200" height="200" src="studentImage.htm"/>
<div>

All your pending queries are
<br><br>

</div>
<table>
<c:forEach var="query" items="${queryList}">
  <tr id=${query.queryId}><td>${query.queryId}</td> <td><a href="" onclick="fetchQueryDetails(${query.queryId}, event)">${query.subject}</a></td> 
   
  <td>${query.severity}</td> <td>${query.status}</td> <td>${query.nature}</td> <td>${query.dateStarted}</td></tr>
    
</c:forEach>
</table>
<div id="result">
		
</div>

<%@include file="../Include/footer.jsp" %>		
</body>
</html>