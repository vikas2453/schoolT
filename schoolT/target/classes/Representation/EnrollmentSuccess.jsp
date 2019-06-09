<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Include/header.jsp" %>	
<br><br>
Mr. ${student.parent.fatherName} & Mrs. ${student.parent.motherName}, Thanks for regsitration  Please note your enrollment number for future reference.<br>
Your enrollment number is ${student.enrollmentNumber}

Also please come along with your ward ${student.name} for the interview on.
<br><br>
<%@include file="Include/footer.jsp" %>	  
</body>
</html>