% ERROR LEXICO EN LA LINEA 13 -->(!=)
Programa contar;

% ----------------
accion n_cifras(val entero num, ref entero cifras);
% ----------------
principio
	cifras := 0;
	
	si cifras = 0 ent
		cifras := 1;
	si_no
		mq num != 0
			cifras := cifras + 1;
			num := num / 10;
		fmq
	fsi
fin
% ----------------
principio
	entero cifras, num;
	escribir("Introduce un número: ");
	leer(num);
	escribir("Se va a calcular el numero de cifras del numero ", entcar(num));
	n_cifras(num, cifras);
	escribir("El número de cifras de ", entacar(num), " es ", entacar(cifras));
fin