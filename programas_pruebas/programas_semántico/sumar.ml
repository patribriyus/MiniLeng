Programa sumar;
booleano num, suma;

Principio
	suma := 0;
	leer(num);
	
	mq num <> 0
		suma := suma + num;
		leer(num);
	fmq
	
	escribir("La suma total de los numeros es: ", entacar(suma));
fin