function initPagePurchaseProducts() {
	getTokenPurchaseProducts();
	parseJwtPurchaseProducts();
}

function getTokenPurchaseProducts(){
    token = window.sessionStorage.getItem("myJWT");
    parseJwtPurchaseProducts(token);
}

function parseJwtPurchaseProducts (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace('-', '+').replace('_', '/');
    var base = JSON.parse(window.atob(base64));
    var jwtmail = base.sub;
    loadPurchases(jwtmail);
}

function loadPurchases(jwtmail) {
	var uri = "http://localhost:8080/gitaarshop/restservices/purchase";
	fetch(uri)
	.then(response => response.json())
	.then(function(myJson){
		for(const purchase of myJson){
			if(purchase.email == jwtmail){
                var table = document.getElementById("shoppingcard_table");
                var row = table.insertRow(0);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);

                cell3.className = "tabelprijs";
                cell2.className = "tabelaantal";

                cell1.innerHTML = purchase.name;
                cell2.innerHTML = purchase.quantity;
                cell3.innerHTML = purchase.price;
            }
            else{
                console.log("Hij is NIET gelijk");
            }
        }
        getAantal();
    })
}

function getAantal(){
    var table = document.getElementById("shoppingcard_table"), sumProduct = 0;

    for(var i = 1; i < table.rows.length; i++)
    {
        sumProduct = sumProduct + parseInt(table.rows[i].cells[1].innerHTML) * parseFloat(table.rows[i].cells[2].innerHTML);
    }
    document.querySelector(".totalprice").innerHTML = sumProduct;
}

function addPurchaseProduct(){
	console.log('test');
	      var test = document.querySelector('.producttitel').innerHTML;
	      console.log(test + " value");
		  var formData = new FormData(document.querySelector("#addPurchaseProductForm"))
		  var encData = new URLSearchParams(formData.entries());
		  console.log(encData + " encData");

		  fetch("http://localhost:8080/gitaarshop/restservices/purchaseproduct", { method: 'POST', body: encData})
		  .then(function (response) {
			  console.log(response + " response");
		  if (response.ok){
		      console.log("Orderproduct toegevoegd."); 
		      return response.ok();
		  }
		  else throw "Kan niet worden toegevoegd.";
		  })
}