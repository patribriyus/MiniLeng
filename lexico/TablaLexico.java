package lexico;

public class TablaLexico {
	private static final int N = 47; // Numero de tokens definidos en la tabla
	private static int tabla[] = new int[N];
	
	public enum token {
		tCOMENTARIO, tPROGRAMA, tACCION, tVAL, tREF,	// Palabras reservadas
		tESCRIBIR, tLEER, tENTACAR, tCARAENT, 			// Funciones
		tENTERO, tBOOLEANO, tCARACTER, tVAR,			// Tipos de datos
		tPRINCIPIO, tFIN, tSI, tENT, tSI_NO, tFSI, tMQ, tFMQ,	// Agrupaciones
		tPUNT_COMA, tCOMA,								// Separadores
		tPLUS, tMINUS, tMULTIPLY, tDIVIDE,				// Operaciones aritmeticas
		tPARENT_IZQ, tPARENT_DER, tMOD, tDIV,
		tMAYOR, tMENOR, tIGUAL, tMAI, tMEI, 			// Operaciones logicas
		tNI, tOPAS, tAND, tOR, tNOT,
		CARACTER, tCADENA, tTRUE, tFALSE,				// Valores constantes
		tIDENTIFICADOR, tNUMERO
	};
	
	// Constructor
	public TablaLexico(){
		for (int i=0; i<N; i++) {
            tabla[i] = 0;
        }
	}
	
	public static void aumentar_token(token t) {
		tabla[t.ordinal()]++;
	}
	
	public static void mostrar_tabla() {
		String texto = "";
		
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Palabras reservadas     | Comentarios: "+tabla[0]+"	Programa: "+tabla[1]+"	Accion: "+tabla[2]+"     |\n";
		texto += "|                         | Val: "+tabla[3]+"	Ref: "+tabla[4]+" 				      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Funciones               | Escribir(): "+tabla[5]+"	Leer(): "+tabla[6]+"                     |\n";
		texto += "|                         | Entacar(): "+tabla[7]+"	Caraent(): "+tabla[8]+"                  |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Tipos de datos          | Entero: "+tabla[9]+"	Booleano: "+tabla[10]+"			      |\n";
		texto += "|                         | Caracter: "+tabla[11]+"	Var: "+tabla[12]+"				      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Agrupaciones            | Principio: "+tabla[13]+"	Fin: "+tabla[14]+"			      |\n";
		texto += "|                         | Si: "+tabla[15]+"	Ent: "+tabla[16]+"	Si_no: "+tabla[17]+"	Fsi: "+tabla[18]+"	      |\n";
		texto += "|                         | Mq: "+tabla[19]+"	Fmq: "+tabla[20]+"				      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Separadores             | ';': "+tabla[21]+"	',': "+tabla[22]+"				      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Operaciones aritmeticas | '+': "+tabla[23]+"	'-': "+tabla[24]+"	'*': "+tabla[25]+"	'/': "+tabla[26]+"		      |\n";
		texto += "|                         | '(': "+tabla[27]+"	')': "+tabla[28]+"	'Mod': "+tabla[29]+"	'Div': "+tabla[30]+"		      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Operaciones logicas     | '>': "+tabla[31]+"	'<': "+tabla[32]+"	'=': "+tabla[33]+"	'>=': "+tabla[34]+"	'<=': "+tabla[35]+"	      |\n";
		texto += "|                         | '<>': "+tabla[36]+"	':=': "+tabla[37]+"	'And': "+tabla[38]+"	      |\n";
		texto += "|                         | 'Or': "+tabla[39]+"	'Not': "+tabla[40]+"			      |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
		texto += "| Valores constantes      | Caracter: "+tabla[41]+"	Cadena: "+tabla[42]+"	True: "+tabla[43]+"	      |\n";
		texto += "|                         | False: "+tabla[44]+"	Identificador: "+tabla[45]+"	Numero: "+tabla[46]+"     |\n";
		texto += "+-------------------------+---------------------------------------------------+\n";
			
		System.out.println(texto);
	}
}
