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