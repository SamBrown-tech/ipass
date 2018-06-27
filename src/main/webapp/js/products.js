function initPage() {
	getTokenForPurchase();
	wijzigProduct();
	deleteProduct();
}

function getTokenForPurchase(){
    token = window.sessionStorage.getItem("myJWT");
    parseJwtForPurchase(token);
}

function parseJwtForPurchase(token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace('-', '+').replace('_', '/');
    var base = JSON.parse(window.atob(base64));
    var jwtmail = base.sub;
    loadProducts(jwtmail);
}

function loadProducts(jwtmail) {
	var uri = "https://ipassgitaarshop.herokuapp.com/restservices/products";
	fetch(uri)
	.then(response => response.json())
	.then(function(myJson){
		for(const product of myJson){
			var id = product.product_id;
			var name = product.name;
			var description= product.description;
			var image = product.image;
			var price = product.price;
			
			var productcard = document.createElement("div");
			productcard.className = "col-lg-4 col-sm-6 productcard";

			var stylingdiv = document.createElement("div");
			stylingdiv.className = "service-box mt-5 mx-auto";
			
			var imageElement = document.createElement("img");
			imageElement.className = "imgsizel";
			imageElement.src = "img/" + image;
			
			stylingdiv.appendChild(imageElement);
			
			var card_body = document.createElement("div");
			card_body.className = "card-body";
			
			var productid = document.createElement("p");
			productid.className = "productid hide";
			productid.innerHTML = id;
			
			var title = document.createElement("h3");
			title.className = "mb-3 producttitle";
			title.innerHTML = name;
			
			var text = document.createElement("p");
			text.className = "mb-0 productdescription";
			text.innerHTML = description;
			
			var product_price = document.createElement("p");
			product_price.className = "mb-0 productprice";
			product_price.innerHTML = "€ " + price;
			
			var amount = document.createElement("div");
			amount.innerHTML= '<label>Aantal: </label><input type="number" min="0" id="productaantal" name="productaantal" value=1 /></input>';

			card_body.appendChild(productid);
			card_body.appendChild(title);
			card_body.appendChild(text);
			card_body.appendChild(product_price);
			card_body.appendChild(amount);
			
			var card_footer = document.createElement("div");
			card_footer.className = "card-footer";
			
			var manage = document.createElement("button");
			manage.className = "btn btn btn-success visibleAdmin";
			manage.setAttribute("data-toggle", "modal");
			manage.setAttribute("data-target", "#myModal");
			manage.innerHTML = "Beheren";
			
			var product_to_shoppingcart = document.createElement("button");
			product_to_shoppingcart.className = "btn btn btn-success visibleCustomer";
			product_to_shoppingcart.setAttribute("id", "addOrderPurchaseProduct");
			product_to_shoppingcart.innerHTML = "Voeg toe";
			
			card_footer.appendChild(manage);
			card_footer.appendChild(product_to_shoppingcart);
			stylingdiv.appendChild(card_body);
			stylingdiv.appendChild(card_footer);
			productcard.appendChild(stylingdiv);
			
			var row = document.querySelector("#producten");
			row.appendChild(productcard);

			manage.addEventListener('click', function(e){
				
				document.querySelector("#productid").value = product.product_id;
				document.querySelector("#editname").value = product.name;
				document.querySelector("#editdescription").value = product.description;
				document.querySelector("#editprice").value = product.price;
				document.querySelector("#editimage").value = product.image;
			});
	
			product_to_shoppingcart.addEventListener('click', function(e){
			  var url = "https://ipassgitaarshop.herokuapp.com/restservices/purchaseproduct/" + jwtmail + product.product_id;
			  
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
			fetch("https://ipassgitaarshop.herokuapp.com/restservices/products", { method: 'POST', body: encData})
			.then(function (response) {
				console.log(response + " response");
				if (response.ok){
					console.log("Product is toegevoegd."); 
					alert("Product is toegevoegd.");
					window.location.href = "https://ipassgitaarshop.herokuapp.com/";
					    
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
		    fetch("https://ipassgitaarshop.herokuapp.com/restservices/products", { method: 'PUT', body: encData})
	    	.then(function (response) {
	    		console.log("response " + response);
			    if (response.ok){
			    	
					console.log("Product gewijzigd"); 
			        alert("Product is gewijzigd.");
			        window.location.href = "https://ipassgitaarshop.herokuapp.com/";
					
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
		var url = "https://ipassgitaarshop.herokuapp.com/restservices/products/";
		var complete_url = url + naam;
	    var response = confirm("Weet u zeker dat u dit product wilt verwijderen?");
	    if ( response == true ){  
			fetch(complete_url, { method: 'DELETE'})
			.then(function (response) {
		        if (response.ok){
		            console.log("Product verwijderd"); 
		            alert("Product is verwijderd.");
		            window.location.href = "https://ipassgitaarshop.herokuapp.com/";
		            
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
	window.location.href = 'https://ipassgitaarshop.herokuapp.com/';
}