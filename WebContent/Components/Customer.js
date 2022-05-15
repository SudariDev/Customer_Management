//SAVE
$(document).on("click", "#btnSave", function(event){ 
	
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
 
	 
	// Form validation-------------------
	var status = validateItemForm(); 
	if (status != true) 
	 { 
	 $("#alertError").text(status); 
	 $("#alertError").show(); 
	 
 return; 
} 


// If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
	$.ajax( 
	{ 
	 url : "CustomerAPI", 
	 type : type, 
	 data : $("#formItem").serialize(), 
	 dataType : "text", 
	 complete : function(response, status) { 
		 
		 onItemSaveComplete(response.responseText, status); 
	 } 
	}); 
});

function onItemSaveComplete(response, status){ 
	if (status == "success") {
		
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") { 
			 
			 $("#alertSuccess").text("Successfully saved."); 
			 $("#alertSuccess").show(); 
			 $("#divItemsGrid").html(resultSet.data); 
		 } 
		 else if (resultSet.status.trim() == "error") {
			 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
		 } 
	} 
	else if (status == "error") { 
		
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
	} else{ 
		
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
		}
	$("#hidItemIDSave").val(""); 
	$("#formItem")[0].reset(); 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event){ 
		
		 $("#hidItemIDSave").val($(this).data("userid")); 
		 $("#name").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#address").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#mobile").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#email").val($(this).closest("tr").find('td:eq(3)').text()); 
		 $("#username").val($(this).closest("tr").find('td:eq(4)').text());  
		 $("#password").val($(this).closest("tr").find('td:eq(5)').text()); 
		
		// $("#").val($(this).closest("tr").find('td:eq(8)').text()); 
		 
});





$(document).on("click", ".btnRemove", function(event) { 
	 $.ajax( 
	 { 
	 	url : "CustomerAPI", 
	 	type : "DELETE", 
	 	data : "customerId=" + $(this).data("userid"),
	 	dataType : "text", 
	 	complete : function(response, status) { 
	 		onItemDeleteComplete(response.responseText, status); 
	 	} 
	}); 
})
	


function onItemDeleteComplete(response, status){
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response); 
			if (resultSet.status.trim() == "success"){
			
				$("#alertSuccess").text("Successfully deleted."); 
				$("#alertSuccess").show(); 
				$("#divItemsGrid").html(resultSet.data); 
				
			} else if (resultSet.status.trim() == "error") { 
				
				$("#alertError").text(resultSet.data); 
				$("#alertError").show(); 
		} 
	} 
	else if (status == "error") { 
		$("#alertError").text("Error while deleting."); 
		$("#alertError").show(); 
	} 
	else { 
		$("#alertError").text("Unknown error while deleting.."); 
		$("#alertError").show(); 
	} 
}

// CLIENT-MODEL================================================================
function validateItemForm(){
	// CODE

//Name---------------------------
if ($("#name").val().trim() == "")
{
return "Insert customer name.";
} 

//Address---------------------------
if ($("#address").val().trim() == "")
{
return "Insert Address.";
} 

//Mobile------------------------------
if ($("#mobile").val().trim() == "")
{
return "Insert mobile.";
}

//Email------------------------------
if ($("#email").val().trim() == "")
{
return "Insert email.";
}

//Username-------------------------------
if ($("#username").val().trim() == "")
{
return "Insert Size.";
}

//Password----------------------------
if ($("#password").val().trim() == "")
{
return "Insert password.";
}

	return true;
}


