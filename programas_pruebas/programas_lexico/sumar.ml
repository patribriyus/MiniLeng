% ERROR LEXICO EN LA LINEA 5 -->(suma_)
Programa sumar;

Principio
	entero num, suma_ := 0;
	leer(num);
	
	mq num <> 0
		suma_ := suma_ + num;
		leer(num);
	fmq
	
	escribir("La suma total de los numeros es: ", entacar(suma_));
fin