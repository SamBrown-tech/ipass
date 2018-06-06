function initPage() {
	fetch('https://ipapi.co/json/')
		.then(function(response) {
			return response.json();
		})
		.then(function(myJson) {
			document.querySelector("#country").innerHTML += myJson.country;
			document.querySelector("#country_name").innerHTML += myJson.country_name;
			document.querySelector("#region").innerHTML += myJson.region;
			document.querySelector("#city").innerHTML += myJson.city;
			document.querySelector("#postal").innerHTML += myJson.postal;
			document.querySelector("#latitude").innerHTML += myJson.latitude;
			document.querySelector("#longitude").innerHTML += myJson.longitude;
			document.querySelector("#ip").innerHTML += myJson.ip;
			
			var lat = myJson.latitude;
			var long = myJson.longitude;
			var city = myJson.city;
			showWeather(lat,long,city);
			loadCountries();
			getMyLocation();
		})			
}

function showWeather(lat, long, city) {
	var uri = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + long + "&appid=a76d194b2adccf904633de0fb698bf82&units=metric";
	fetch(uri)
		.then(response => response.json())
		.then(function(myJson){		
			var temp = " graden";
			var stad = document.querySelector("#stad").innerHTML = city;
			var temperatuur = document.querySelector("#temperatuur").innerHTML = myJson.main.temp + temp;
			var luchtvochtigheid = document.querySelector("#luchtvochtigheid").innerHTML = myJson.main.humidity;
			var windsnelheid = document.querySelector("#windsnelheid").innerHTML = myJson.wind.speed;
			var windrichting = document.querySelector("#windrichting").innerHTML = myJson.wind.deg;
			var zonsopgang = document.querySelector("#zonsopgang").innerHTML = myJson.sys.sunrise;
			var zonsondergang = document.querySelector("#zonsondergang").innerHTML = myJson.sys.sunset;
			var expiration_time = new Date().getTime() + (1000 * 60 * 10);
			var weather = { 
				"stad" : stad, 
				"temperatuur" : temperatuur, 
				"luchtvochtigheid" : luchtvochtigheid,
				"windsnelheid" : windsnelheid,
				"windrichting" : windrichting,
				"zonsopgang" : zonsopgang,
				"zonsondergang" : zonsondergang,
				"expiration_time" : expiration_time
			};					
			var current_time = new Date().getTime();
			
			window.localStorage.setItem(stad, JSON.stringify(weather));
			
			for(country in window.localStorage){
				var c_storage = JSON.parse(window.localStorage.getItem(country));
				console.log(c_storage.expiration_time);
				if(current_time < c_storage.expiration_time){
					localStorage.removeItem(country);
				}
			}		
		})
}

function loadCountries() {
	var uri = "http://localhost:8080/firstapp/restservices/countries";
	fetch(uri)
		.then(response => response.json())
		.then(function(myJson){
			for(const country of myJson){
				var table = document.getElementById("table");
				var row = table.insertRow(1);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
				var cell7 = row.insertCell(6);
				cell6.className = "hide";
				cell7.className = "hide";
								
				cell1.innerHTML = country.name;
				cell2.innerHTML = country.capital;
				cell3.innerHTML = country.region;
				cell4.innerHTML = country.surface;
				cell5.innerHTML = country.population;
				cell6.innerHTML = country.lat;
				cell7.innerHTML = country.lng;				
			}
			
			table = document.querySelectorAll("#table tr");
			for	(const row of table){
				row.addEventListener("click", function(){
					var lat = row.cells[5].innerHTML;
					var lng = row.cells[6].innerHTML;
					var city = row.cells[1].innerHTML;
					showWeather(lat, lng, city);
				});
			}
		})
}

function getMyLocation(){
	var city = document.querySelector("#city");
	city.addEventListener("click", function(){
		var lat = document.getElementById("latitude").innerHTML;
		var lng = document.getElementById("longitude").innerHTML;
		var city = document.getElementById("city").innerHTML;
		showWeather(lat,lng,city);
	});
}