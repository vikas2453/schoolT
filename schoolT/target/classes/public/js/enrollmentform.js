function validateUserId() {

	// get the form values
	var userId = $('#userId').val();	
	$.ajax( {
		type : "GET",
		url : "validateUserId.htm",
		data : "userId=" + userId,
		success : function(response) {
			// we have the response
			$('#userIdError').html(response);
		},
		error : function(e) {

			alert('Error: ' + e);

		}

	});

}

function fetchTargetConSumer(){
	var triggerId = $('#triggers').val();
	$.ajax( {type : "GET",
	url :"validateUserId.htm",
	data : "triggerId=" + triggerId,
	
	success : function(response) {
		// we have the response
		 $('#targetConsumers').get(0).options.length = 0;   
		 $('#targetConsumers').get(0).options[0] = new Option("Select targeted consumers", "-1");
		 alert(response);		 	 
		 var i=0;
		 $.each(response,function(){
			 alert(this);
			 $('#targetConsumers').get(0).options[$('#targetConsumers').get(0).options.length] = new Option(this,i++);
			 
		 })
		                 
		 
	},
	error : function(e) {

		alert('Error: ' + e);

	}
	
});}
