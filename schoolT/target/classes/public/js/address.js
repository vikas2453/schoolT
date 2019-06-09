function viewAddressForm(event){
	$("#address").toggle();
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
    $.ajax({
         type: "GET",
         cache: false,
         url: "updateDetails.htm",
         data: "",
         success: function(response){     	
    		$('#address').html('');
             $('#address').html(response);
             console.log($('#address').html());
         }
    });
}

function updateAddressForm(event){	
	$("#address").toggle();
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
    $.ajax({
         type: "POST",
         cache: false,
         url: "updateDetails.htm",
         data: $('#addressForm').serialize(),
         success: function(response){  
    	 alert("details updated sucessfully");
    	 $('#address').html('');
         }
    });
}
