<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

Query Form
enctype="multipart/form-data" can be added in the form so that attachment can also be uploaded with the query.
severity:must be in dropdown, http://www.mkyong.com/spring-mvc/spring-mvc-dropdown-box-example.
<form:form id="queryForm" method="POST"  commandName="query">
	<table>
		<tr>
			<td>Subject :</td>
			<td><form:input path="subject" />
			</td><td><font color="red"><form:errors path="subject"/></font></td>
			
			</tr>
			<tr>			
			<td>Severity :</td>
				<td><form:select path="severity" items="${severityList}"/>
					  
             </td>
			<td><form:errors path="severity" cssClass="error" /></td>
			
			<td>Nature query :</td>
				<td><form:select path="nature">
					  <!-- form:option value="NONE" label="--- Select ---" />  -->
					  <form:options items="${natureQuery}" />
				       </form:select>
             </td>
			<td><form:errors path="nature" cssClass="error" /></td>
			
			</tr>		
		
		<tr>
		
		<c:forEach var="requestResponse" items="${query.requestResponseList}" varStatus="status">
		<td> Text for the Query:<input name ="requestResponseList[${status.index}].requestText" value="${requestResponse.requestText}"/>		
		
		</td>
		</c:forEach>
		</tr>
		<tr>
		
			<td colspan="2"><input type="submit" onclick="postQueryForm(event)"></td>
		</tr>

		
	</table>
</form:form>


