function initPage() {
	getTokenForPurchase();
	wijzigProduct();
	deleteProduct();
}

function getTokenForPurchase(){
    token = window.sessionStorage.getItem("myJWT");
    parseJwtForPurchase(token);
}

function parseJwtForPurchase (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace('-', '+').replace('_', '/');
    var base = JSON.parse(window.atob(base64));
    var jwtmail = base.sub;
    loadProducts(jwtmail);
}

function loadProducts(jwtmail) {
	var uri = "http://localhost:8080/gitaarshop/restservices/products";
	fetch(uri)
		.then(response => response.json())
		.then(function(myJson){
			for(const product of myJson){
				var id = product.product_id;
				var name = product.name;
				var description= product.description;
				var image = product.image;
				var price = product.price;
				
				var div = document.createElement("div");
				div.className = "col-lg-4 col-sm-6 productcard";
	
				var div2 = document.createElement("div");
				div2.className = "service-box mt-5 mx-auto";
				
				var imageElement = document.createElement("img");
				imageElement.className = "imgsizel";
				imageElement.src = "img/" + image;
				
				div2.appendChild(imageElement);
				
				var div3 = document.createElement("div");
				div3.className = "card-body";
				
				var pid = document.createElement("p");
				pid.className = "productid hide";
				pid.innerHTML = id;
				
				var titel = document.createElement("h3");
				titel.className = "mb-3 producttitel";
				titel.innerHTML = name;
				
				var text = document.createElement("p");
				text.className = "mb-0 productdescription";
				text.innerHTML = description;
				
				var prijs = document.createElement("p");
				prijs.className = "mb-0 productprice";
				prijs.innerHTML = "€ " + price;
				
				var aantal = document.createElement("div");
				aantal.innerHTML= '<label>Aantal: </label><input type="number" min="0" id="productaantal" name="productaantal" value=1 /></input>';

				div3.appendChild(pid);
				div3.appendChild(titel);
				div3.appendChild(text);
				div3.appendChild(prijs);
				div3.appendChild(aantal);
				
				var div4 = document.createElement("div");
				div4.className = "card-footer";
				
				var button = document.createElement("button");
				button.className = "btn btn btn-success";
				button.setAttribute("data-toggle", "modal");
				button.setAttribute("data-target", "#myModal");
				button.innerHTML = "Beheren";
				
				var button2 = document.createElement("button");
				button2.className = "btn btn btn-success";
				button2.setAttribute("id", "addOrderPurchaseProduct");
				button2.innerHTML = "Voeg toe";
				
				div4.appendChild(button);
				div4.appendChild(button2);
				div2.appendChild(div3);
				div2.appendChild(div4);
				div.appendChild(div2);
				
				var row = document.querySelector("#producten");
				row.appendChild(div);

				button.addEventListener('click', function(e){
					
					document.querySelector("#productid").value = product.product_id;
					document.querySelector("#editname").value = product.name;
					document.querySelector("#editdescription").value = product.description;
					document.querySelector("#editprice").value = product.price;
					document.querySelector("#editimage").value = product.image;
				});
		
				button2.addEventListener('click', function(e){
				  var url = "http://localhost:8080/gitaarshop/restservices/purchaseproduct/" + jwtmail + product.product_id;
				  
				  var response = confirm("Weet u zeker dat u dit product wilt toevoegen aan uw winkelwagen?");
				  if ( response == true ){  
					  fetch(url, { method: 'POST'})
					  .then(function (response) {
					  if (response.ok){
					  console.log("Product is toegevoegd aan winkelwagen."); 
		  		          alert("Product is toegevoegd aan winkelwagen.");
		  		          window.location.href = "shoppingcart.html";
		  		          
					       return response.ok();
					  }
					  else throw "Kan niet worden toegevoegd.";
					  })
				  }
				});
			}
		})
}

function addProduct(){
	var button = document.getElementById("add");
	button.addEventListener('click', function(){
	
		var formData = new FormData(document.querySelector("#addProduct"))
		var encData = new URLSearchParams(formData.entries());
		var response = confirm("Weet u zeker dat u dit product wilt toevoegen?");
		if ( response == true ){ 
			fetch("http://local®host:8080/gitaarshop/restservices/products", { method: 'POST', body: encData})
			.then(function (response) {
				console.log(response + " response");
				if (response.ok){
					console.log("Product is toegevoegd."); 
					alert("Product is toegevoegd.");
					window.location.href = "http://localhost:8080/gitaarshop/";
					    
					return response.ok();
				} else throw "Kan niet worden toegevoegd.";
			})
		}
	});
}

function wijzigProduct(){
	var button = document.getElementById("edit");
    button.addEventListener('click', function(){
        var formData = new FormData(document.querySelector("#editProduct"))
        var encData = new URLSearchParams(formData.entries());
        var response = confirm("Weet u zeker dat u dit product wilt wijzigen?");
		if ( response == true ){  
		    fetch("http://localhost:8080/gitaarshop/restservices/products", { method: 'PUT', body: encData})
	    	.then(function (response) {
	    		console.log("response " + response);
			    if (response.ok){
			    	
					console.log("Product gewijzigd"); 
			        alert("Product is gewijzigd.");
			        window.location.href = "http://localhost:8080/gitaarshop/";
					
			        return response();
			    }
			    else throw "Kan niet worden gewijzigd";
	    	})
		}
	}); 
}

function deleteProduct(){
	document.querySelector("#delete").addEventListener('click', function(event){

		var naam = document.querySelector("#editname").value;
		var url = "http://localhost:8080/gitaarshop/restservices/products/";
		var complete_url = url + naam;
	    var response = confirm("Weet u zeker dat u dit product wilt verwijderen?");
	    if ( response == true ){  
			fetch(complete_url, { method: 'DELETE'})
			.then(function (response) {
		        if (response.ok){
		            console.log("Product verwijderd"); 
		            alert("Product is verwijderd.");
		            window.location.href = "http://localhost:8080/gitaarshop/";
		            
		        }
		        else throw "Kan niet worden verwijderd. ";
		    })
	    }
	});
}
	    
function refreshPage(){
    window.location.reload();
} 

function logout() {
	sessionStorage.removeItem('myJWT');
	window.location.href = 'http://localhost:8080/gitaarshop/';
}