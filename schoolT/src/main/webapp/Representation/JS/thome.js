
function KakshaDetails(event){
	alert("KakshaDetails");
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
	
	$.ajax({		
		url:"KakshaDetails.htm",
		dataType:"json",
		contentType: "application/json; charset=utf-8",	
		
		success:function(response){
		//alert(response);
		var new_table = document.createElement('table');	
		$.each(response, function(i, value) {			
			var new_row = document.createElement('tr');
			//alert(response[i].admissionNumber);
			new_row.setAttribute("id",response[i].admissionNumber);
			new_row.insertCell(0).innerHTML = response[i].admissionNumber;
			
			new_row.insertCell(1).innerHTML = response[i].student_enrolled.name;
			//new_row.insertCell(2).innerHTML = response[i].status;			
			//new_row.insertCell(3).innerHTML = response[i].nature;		
			//new_row.insertCell(3).innerHTML = response[i].dateStarted;					
			
			new_table.appendChild(new_row);			
			
			
			 });
		
		
		$("#KakshaDetails").append(new_table);

	},
	error:function(e, response){   
		alert(e);
		alert(response.status());
		console.log(e);
	}
	
});
}