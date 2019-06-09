<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enrollment form</title>
</head>
<body>
<%@include file="Include/header.jsp" %>	

<h3>Login with Username and Password</h3>

<c:if test="${not empty error}">	
		<div class="errorblock">
			Your login attempt was not successful, try again
			
		</div>
	</c:if>

<form name='f' method='POST'
action='j_spring_security_check'>
<table>
<tr><td>UserName:</td><td>
<input type='text' name='j_username'value=''>
</td></tr>
<tr><td>Password:</td><td>
<input type='password' name='j_password'/>
</td></tr>
<tr><td colspan='2'><input value="Login" type="submit"/></td></tr>
<tr><td colspan='2'><input name="reset" type="reset"/></td></tr>
</table>
</form>


<%@include file="Include/footer.jsp" %>	
</body>
</html>