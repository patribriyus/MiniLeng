% ERROR LEXICO EN LA LINEA 16 -->(&&)
programa comparador;
entero num1, num2, num3;
% Los numeros introducidos tienen que ser todos distintos
principio
	
	escribir("Introduce primer numero: ");
	leer(num1);
	escribir("Introduce segundo numero: ");
	leer(num2);
	escribir("Introduce tercer numero: ");
	leer(num3);
	
	% Se procede a calcular el mayor numero de los 3
	
	si (num1 > num2) AND (num1 < num3) ent
		escribir("El numero mayor es: ", entacar(num1));
	si_no 
		si (num2 > num1) AND (num2 > num3) ent
			escribir("El numero mayor es: ", entacar(num2));
		si_no 
			si (num3 > num1) AND (num3 > num2) ent
				escribir("El numero mayor es: ", entacar(num3));
			fsi
		fsi
	
fin