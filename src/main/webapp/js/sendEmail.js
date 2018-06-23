function sendEmail(){
	document.querySelector("#verzendemail").addEventListener('click', function(event){
		console.log("ferji")
		var formData = new FormData(document.querySelector("#sendForm"));
	    var encData = new URLSearchParams(formData.entries());
		
		fetch("http://localhost:8080/gitaarshop/restservices/sendemail", { method: 'POST', body: encData})
		.then(function (response) {
			console.log(response);
	        if (response.ok){
	            console.log("Email verzonden"); 
	        }
	        else console.log("Kan niet worden verzonden.");
	    })
	});
}