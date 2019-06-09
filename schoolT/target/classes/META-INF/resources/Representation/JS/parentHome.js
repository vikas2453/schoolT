$(document).ready(function(){
	 $("div:empty").hide();	
});


function fetchParentPendingQuery(event){
	$("#parentQuery").toggle();
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
	
	$.ajax({		
		url:"parent/pendingQuery.htm",
		dataType:"json",
		contentType: "application/json; charset=utf-8",	
		
		success:function(response){
		var new_table = document.createElement('table');	
		$.each(response, function(i, value) {			
			var new_row = document.createElement('tr');			
			new_row.setAttribute("id",response[i].queryId);
			new_row.insertCell(0).innerHTML = '<a href="" onclick="fetchQueryDetails('+response[i].queryId+', event)">'+response[i].subject+'</a>';
			
			new_row.insertCell(1).innerHTML = response[i].severity;
			new_row.insertCell(2).innerHTML = response[i].status;			
			//new_row.insertCell(3).innerHTML = response[i].nature;		
			new_row.insertCell(3).innerHTML = response[i].dateStarted;					
			
			new_table.appendChild(new_row);			
			
			
			 });
		
		$("#parentQuery").html('');
		$("#parentQuery").append(new_table);

	},
	error:function(e, response){   
		alert(e);
		alert(response.status());
		console.log(e);
	}
	
});

}



function viewTestResults(event){
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;	
	
	$.ajax({		
		url:"fetchTestResults.htm",
		cache: true,
		dataType:"json",
		contentType: "application/json; charset=utf-8", 
		
		success:function(data){
		
		var new_table = document.createElement('table');	
		$.each(data, function(i, value) {
			
			var new_row = document.createElement('tr');
			new_row.insertCell(0).innerHTML = data[i].test.testType;
			new_row.insertCell(1).innerHTML = data[i].test.testDate;
			new_row.insertCell(2).innerHTML = data[i].test.subject.subjectName;			
			new_row.insertCell(3).innerHTML = data[i].status;		
			new_row.insertCell(4).innerHTML = data[i].marksObtained;
			new_row.insertCell(5).innerHTML = data[i].remarks;
			
			
			new_table.appendChild(new_row);			
			
			
			 });
		
		$("#testResults").html('');
		$("#testResults").append(new_table);
		$("#testResults").toggle();
		
		
		
		
		},
		error:function(e, response){   
			alert(e);
			alert(response.status());
			console.log(e);
		}
		
	});

}



function fetchQueryDetails(queryId, event){
	
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
	
	$.ajax({		
		url:"fetchQueryDetails.htm",
		dataType:"json",
		contentType: "application/json; charset=utf-8",       

		data:"queryId="+queryId,
		success:function(data){
		
		
		$.each(data, function(i, value) {
			var new_row = document.createElement('tr');
			new_row.insertCell(0).innerHTML = data[i].requestResponseId;
			new_row.insertCell(1).innerHTML = data[i].requestText;
			if(data[i].responsText){
				new_row.insertCell(2).innerHTML =data[i].responsText;
			}
			else{
				new_row.insertCell(2).innerHTML="no response yet from teacher";
			}
			$('#'+queryId).after(new_row);			
			
			 });
		
		},
		error:function(e, response){   
			alert(e);
			alert(response.status());
			console.log(e);
		}
		
	});
}

function veiwQueryForm(event){
	$("#query").toggle();
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
    $.ajax({
         type: "GET",
         cache: true,
         url: "query.htm",
         data: "",
         success: function(response){    	
    		$('#query').html('');
             $('#query').html(response);             
         }
    });
}


    function postQueryForm(event){
    	$("#query").toggle();
    	if(event.preventDefault) event.preventDefault();
    	else event.returnValue = false;
        $.ajax({
             type: "POST",
             cache: true,
             url: "query.htm",
             data: $('#queryForm').serialize(),
             success: function(response){
        	console.log("success from server");
        	alert("query submitted succesfully");
        		$('#query').html('');
                              
             }
        });
    }


    function applyLeave(event){
    	$("#applyLeave").toggle();
    	if(event.preventDefault) event.preventDefault();
    	else event.returnValue = false;
        $.ajax({
             type: "Get",
             cache: true,
             url: "applyLeave.htm",
             data: "",
             success: function(response){
        	console.log("success from server");
        		$('#query').html('');
                 $('#query').html(response);             
             }
        });
        
    }




