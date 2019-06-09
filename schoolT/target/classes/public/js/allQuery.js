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
			if(data[i].responsText)
				new_row.insertCell(2).innerHTML =data[i].responsText;
			else{
				var varid="response"+data[i].requestResponseId;
				var responseid = data[i].requestResponseId;
			new_row.insertCell(2).innerHTML ='<div id='+varid+'><a href="" onclick="requestResponse('+varid+',event,'+responseid+')">Respond</a></div>';
			}
			$('#'+queryId).after(new_row);			
			
			 });
		
		},
		error:function(e, response){			
			alert(response.status());
			console.log(e);
		}
		
	});
}

function requestResponse(varid,event,responseid){
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
	var inputid="input"+responseid;
	$(varid).html('<input id='+inputid+' type ="text"> <input type="submit" onclick=submitResponse('+inputid+','+responseid+')>');
}

function fetchTeacherPendingQuery(event){
	console.log("fetchTeacherPendingQuery");
	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;
	
	$.ajax({		
		url:"teacher/pendingQuery.htm",
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
			new_row.insertCell(3).innerHTML = response[i].initiator;		
			new_table.appendChild(new_row);				
			
			 });
		
		
		$("#teacherpendingQuery").append(new_table);

	},
	error:function(e, response){   
		alert(e);
		alert(response.status());
		console.log(e);
	}
	
});

}
	


function submitResponse(inputid, requestId){	
	var text1 = $(inputid).val();	
	$.post("teacher/response.htm",{response:text1, repsonseId:requestId},function(data, status){
	      alert(status);
	    });
	$('#response'+requestId).html(text1);
	
	
}

