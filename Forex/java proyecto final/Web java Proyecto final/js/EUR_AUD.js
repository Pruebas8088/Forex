function actualizarPrecioEUR() {
	var valoriginal=30000; 
	var min= 20;
	var max= -20;
	var randomnum =Math.floor(Math.random() * (+max - +min)) + +min;
	var result= valoriginal +randomnum;
	postMessage(result);
	
	
}

setInterval("actualizarPrecioEUR()",5000);