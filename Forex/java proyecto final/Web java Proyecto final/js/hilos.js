function actualizarPrecio() {
	var valoriginal=50000; 
	var min= 20;
	var max= -20;
	var randomnum =Math.floor(Math.random() * (+max - +min)) + +min;
	var result= valoriginal +randomnum;
	postMessage(result);
}

setInterval("actualizarPrecio()",5000);

