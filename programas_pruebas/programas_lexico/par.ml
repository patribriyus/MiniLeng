% ERROR LEXICO EN LA LINEA 17 -->('')
Programa par;

% Funcion para calcular si un numero dado es par o no
accion es_par(val entero num, ref booleano espar);
principio
	si (num mod 2)=0 ent
		espar := true;
	si_no
		espar := false;
	fsi
fin

principio
	entero num;
	booleano espar;
	escribir('Introducir numero: ');
	leer(num);
	
	par(num, espar);
	si espar=true ent
		escribir('El numero es par.');
	si_no
		escribir('El numero no es par.');
	fsi
fin