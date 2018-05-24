var numone;
var numtwo;
var operator;
var result = null;

function changeDisplay(num) { 
	var mydisplay = document.getElementById("display").innerHTML;
	if(mydisplay == 0) {
		document.getElementById("display").innerHTML = num;
	} else {
		var textnode = document.createTextNode(num);
		display.appendChild(textnode);
	}
}

function divide() {
	numone = document.getElementById("display").innerHTML;
	operator = "/";
	document.getElementById("display").innerHTML = 0;
}

function product() {
	numone = document.getElementById("display").innerHTML;
	operator = "*";
	document.getElementById("display").innerHTML = 0;
}

function plus() {
	numone = document.getElementById("display").innerHTML;
	operator = "+";
	document.getElementById("display").innerHTML = 0;
}

function min() {
	numone = document.getElementById("display").innerHTML;
	operator = "-";
	document.getElementById("display").innerHTML = 0;
}

function outcome() {
	numtwo = document.getElementById("display").innerHTML;
	console.log(numone);
	console.log(numtwo);
	console.log(result);
	numone = parseInt(numone);
	numtwo = parseInt(numtwo);
	if(operator == "-") {
		result = numone - numtwo;
	} else if(operator == "+") {
		result = numone + numtwo;
	} else if(operator == "*") {
		result = numone * numtwo;
	} else if(operator == "/") {
		result = numone / numtwo;
	}  else {
		result = "something went wrong";
	}
	document.getElementById("display").innerHTML = result;
	numone = result;
	return result;
}