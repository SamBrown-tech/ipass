function initPageLogin(){
	myLogin();
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
	console.log("test")
    var button = document.querySelector('#loginbtn');
    button.addEventListener('click', function(){
        var formData = new FormData(document.querySelector("#inloggegevens"))
        var encData = new URLSearchParams(formData.entries());
        console.log( "haha");

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


function addAccount(){
	console.log("test");
	 var button = document.getElementById("createbtn");
	    button.addEventListener('click', function(){
	       var formData = new FormData(document.querySelector("#maakacc"))
	       var encData = new URLSearchParams(formData.entries());
	       console.log(encData + " encData");
	       
           fetch("http://localhost:8080/gitaarshop/restservices/account", { method: 'POST', body: encData})
            .then(function (response) {
                if (response.ok){
                    console.log("Account toegevoegd");
                    alert("Account is toegevoegd");
                    return response.json();
                }
                else throw "Account kan niet worden toegevoegd";
            })
	    });
}