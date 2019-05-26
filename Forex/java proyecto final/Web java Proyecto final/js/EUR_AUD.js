function actualizarPrecioEUR() {
	var valoriginal=30000; 
	var min= 5;
	var max= -5;
	var randomnum =Math.floor(Math.random() * (+max - +min)) + +min;
	var result= valoriginal +randomnum;
	postMessage(result);
	
	
}

setInterval("actualizarPrecioEUR()",12000);