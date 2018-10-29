var host = "http://localhost:8080"
var i =0;
	
function getMessages(){
	i=0;
	$.get(host +"/app/get",function(data){
		data.forEach(getMessage);
	});	
}

function getMessage(testEntry,prepend){
	i++;
var divBlock = "<tr> <td>" +i + "</td> <td style='width: 30%;'>" 
				+ testEntry.timestamp+"</td> <td style='width: 35%;'>" 
				+testEntry.content+"</td><td>"
				+testEntry.size+" </td> </tr> ";
	if(prepend !== "prepend"){
		$('#tabl').append(divBlock);
	}else{
		$('#tabl').prepend(divBlock);
	}
}	

function saveContent(){
		console.log($('#content').val());
		$.ajax({
			traditional: true,
			type : "POST",
		    data : $('#content').val(),
			contentType : "application/json",
			url : "/app/add",
			success: function() {
                   window.location.reload();
               },
		});
}