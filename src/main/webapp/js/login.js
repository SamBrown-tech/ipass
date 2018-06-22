function initPageLogin(){
	myLogin();
	displayChange();
	addAccount();
}

var input = document.getElementById("inloggegevens");
input.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("loginbtn").click();
	    }
	});

function myLogin(){
    var button = document.querySelector('#loginbtn');
    button.addEventListener('click', function(){
        var formData = new FormData(document.querySelector("#inloggegevens"))
        var encData = new URLSearchParams(formData.entries());

           fetch("http://localhost:8080/gitaarshop/restservices/authentications", { method: 'POST', body: encData, headers: {'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")}})
            .then(function (response) {
                if (response.ok){
                    console.log("ingelogt"); 
                    window.location.replace("http://localhost:8080/gitaarshop");
//                    javascript:history.back();
                    return response.json();
                }
                else throw "wrong username/password";
            })
            .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
                .catch(error => console.log(error));
            });
}

function displayChange(){
	var button = document.querySelector(".maak");
	button.addEventListener('click', function(){
		var maak = document.querySelector(".maakaccount");
		var login = document.querySelector(".container");

		login.style.display = "none";
		maak.style.display = "block";
		
	})
}


function addAccount(){
	 var button = document.getElementById("createbtn");
	    button.addEventListener('click', function(){
	    	var formData = new FormData(document.querySelector("#maakacc"))
	        var encData = new URLSearchParams(formData.entries());
	        if(document.querySelector("#voornaam").innerHTML === "" ){
	        	console.log("Voornaam vergeten");
	        	accountData();
	        }
	        else if(document.querySelector("#achternaam").innerHTML === ""){
	        	console.log("Achternaam vergeten");
	        }
	        else if(document.querySelector("#mailadres").innerHTML === ""){
	        	console.log("Email vergeten");
	        }
	        else if(document.querySelector("#makepass").innerHTML === ""){
	        	console.log("Wachtwoord vergeten");
	        }
	        else{
	           fetch("http://localhost:8080/gitaarshop/restservices/account", { method: 'POST', body: encData})
	            .then(function (response) {
	                if (response.ok){
	                    console.log("Account toegevoegd");
	                    var maak = document.querySelector(".maakaccount");
	            		var login = document.querySelector(".container");

	            		login.style.display = "block";
	            		maak.style.display = "none";
	                    return response.json();
	                }
	                else throw "Account kan niet worden toegevoegd";
	            })
	        }
	    });
}