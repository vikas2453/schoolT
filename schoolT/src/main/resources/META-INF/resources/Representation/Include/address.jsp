<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
Address details are:
<form:form method="POST" id="addressForm" commandName="user">
	
		
			flat no :
			<form:input path="address.flatno" />
			<font color="red"><form:errors path="address.flatno"/></font>
			
			
			houseNo :
			<form:input path="address.houseNo" />
			<font color="red"><form:errors path="address.houseNo"/></font>
			


			street :
			<form:input path="address.street" />
			<font color="red"><form:errors path="address.street"/></font>
			
			
			sector :
			<form:input path="address.sector" />
			<font color="red"><form:errors path="address.sector"/></font>
			
			
			
			city :
			<form:input path="address.city" />
			<font color="red"><form:errors path="address.city"/></font>
			
			
			state :
			<form:input path="address.state" />
			<font color="red"><form:errors path="address.state"/></font>

			country :
			<form:input path="address.country" />
			<font color="red"><form:errors path="address.country"/></font>
			
			<input type="submit" value="update" onclick="updateAddressForm(event)"/>					
						
			
</form:form>
