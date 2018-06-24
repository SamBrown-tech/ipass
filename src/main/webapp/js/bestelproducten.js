function initPagePurchaseProducts() {
	getTokenPurchaseProducts();
}

function getTokenPurchaseProducts(){
    token = window.sessionStorage.getItem("myJWT");
    console.log(token + " is token")
    parseJwtPurchaseProducts(token);
}

function parseJwtPurchaseProducts (token) {
	console.log("token is " + token );
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

    for(var i = 0; i < table.rows.length; i++)
    {
        sumProduct = sumProduct + parseInt(table.rows[i].cells[1].innerHTML) * parseFloat(table.rows[i].cells[2].innerHTML);
        console.log('sum is ' + sumProduct);
    }
    console.log("eindbedrag " + sumProduct);
    var totalprice = document.getElementById("totalprice");
    console.log("totalprice = " + totalprice);
    
}