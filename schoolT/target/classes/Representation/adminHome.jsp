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
<a href="admitStudentHome.htm">Manage students</a>
all this should be in left nav and as soon as the user click on this nav, sub nav options must come like Add sutdent, remove student, modify student details etc while removing student options like generate tc and send an email to parent to take tc on certain date..
</div>
<div><a href="manageTeacher.html">Manage teacher</a>  options like add new teacher,modify a teacher, remove teacher while remving teacher options like "printing the experrince letter" </div>
<div><a href="manageTecher.htm">Manage activities</a></div>

<%@include file="Include/footer.jsp" %>		
</body>
</html>