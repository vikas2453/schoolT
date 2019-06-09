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
<%@include file="Include/header.jsp" %>	
<br><br>
<div>
<br><br>
<a href="FormNewTeacher.htm">Add a new teacher details, needs to be modified to confirm the teacher</a>
</div>
<div><a href="modifyTeacherDetail.htm">Modify Teacher details</a></div>
<div><a href="RemoveTeacherDetail.htm">Remove Teacher details</a></div>

<%@include file="Include/footer.jsp" %>		
</body>
</html>