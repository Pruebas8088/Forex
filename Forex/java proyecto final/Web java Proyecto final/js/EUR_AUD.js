function actualizarPrecioEUR() {
	var min=-1.00; 
	var max=1.00;  
	var randomnum = Math.random() * (+max - +min) + +min; 
	postMessage(randomnum.toFixed(3));
}

setInterval("actualizarPrecioEUR()",5000);