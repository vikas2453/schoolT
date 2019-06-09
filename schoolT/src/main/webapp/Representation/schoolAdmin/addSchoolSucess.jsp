<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School Added</title>
</head>
<body>
<%@include file="../Include/header.jsp" %>	
<br><br>
School ${ school.name} is registered successfully with  address ${school.address}
<br><br>
<%@include file="../Include/footer.jsp" %>	  
</body>
</html>