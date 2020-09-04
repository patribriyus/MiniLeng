Programa sumar;
entero num, suma := 0;

Principio
	suma := 0;
	leer(num);
	
	mq num <> 0
		suma := suma + num;
		leer(num);
	fmq
	
	escribir("La suma total de los numeros es: ", entacar(suma));
fin