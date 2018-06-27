/* onload */
function initPageLogin(){
	myLogin();
	addAccount();
}
/* press enter to login */
var input = document.getElementById("inloggegevens");
input.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("loginbtn").click();
	    }
	});

/* authenticates the login attempt */
function myLogin(){
    var button = document.querySelector('#loginbtn');
    button.addEventListener('click', function(){
        var formData = new FormData(document.querySelector("#inloggegevens"))
        var encData = new URLSearchParams(formData.entries());
        console.log( "haha");

           fetch("https://ipassgitaarshop.herokuapp.com/restservices/authentications", { method: 'POST', body: encData, headers: {'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")}})
            .then(function (response) {
                if (response.ok){
                    console.log("ingelogt"); 
                    window.location.replace("https://ipassgitaarshop.herokuapp.com/");
//                    javascript:history.back();
                    return response.json();
                }
                else throw "wrong username/password";
            })
            .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
                .catch(error => console.log(error));
            });
}

/* creates new account */
function addAccount(){
	 var button = document.getElementById("createbtn");
	    button.addEventListener('click', function(){
	       var formData = new FormData(document.querySelector("#maakacc"))
	       var encData = new URLSearchParams(formData.entries());
	       console.log(encData + " encData");
	       
           fetch("https://ipassgitaarshop.herokuapp.com/restservices/account", { method: 'POST', body: encData})
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


function logout() {
	sessionStorage.removeItem('myJWT');
	window.location.href = 'https://ipassgitaarshop.herokuapp.com/';
}