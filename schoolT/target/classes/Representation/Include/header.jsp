<%-- <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %> --%>

<img src ="images/aboutus.jpg"/>
<marquee bgcolor="green"> Registration has been started now.</marquee>


 <link rel="stylesheet" href="/School/CSS/main.css" type="text/css">
 <ul id="main-nav">
 <li><a href="infrastructure.html"> Infrastructure</a></li>
 <li><a href="infrastructure.html"> Facilities</a></li>
 <li><a href="infrastructure.html"> Uniforms</a></li>
 <li><a href="infrastructure.html"> Motto</a></li>
 <li><a href="infrastructure.html"> School Pictures</a></li>
 <li><a href="infrastructure.html"> Activities</a></li>
 <li><a href="infrastructure.html"> Subjects</a></li>
 <li><a href="infrastructure.html"> Contacts us</a></li>
</ul>

<table border="2">
<tr>
<td>

<security:authorize access="isAuthenticated()">
Hello <security:authentication property="principal.username"/>!
<a href="j_spring_security_logout"> Logout</a>
</security:authorize>

<security:authorize access="isAnonymous()">
	<a href="login.htm">login</a>
	<a href="enrollment.htm">Enroll Student</a>
	<a href="FormNewTeacher.htm">Carrier</a>
</security:authorize>

<security:authorize access="hasRole('ROLE_admin')"> <a href="adminHome.html">Adminstration page</a>
</security:authorize> 

<security:authorize access="hasRole('ROLE_parent')"> <a href="parentHome.htm">parent's page</a>
</security:authorize> 

<security:authorize access="hasRole('ROLE_teacher')"> <a href="teacherHome.htm">Teacher's page</a>
</security:authorize> 
				


</td>
</tr>
</table>