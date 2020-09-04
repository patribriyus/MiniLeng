package semantico;

import semantico.Simbolo.*;

public class Tabla_simbolos {
	private Tabla_dispersion tabla;
	
	public Tabla_simbolos() {
		inicializar_tabla();
	}
	/**********************************************************************
	Crea una tabla de simbolos vacia. Este procedimiento debe invocarse
	antes de hacer ninguna operacion con la tabla de simbolos.
	**********************************************************************/
	public void inicializar_tabla(){
		tabla = new Tabla_dispersion();
	}
	
	/**********************************************************************
	Busca en la tabla el simbolo de mayor nivel cuyo nombre coincida
	con el del parametro (se distinguen minusculas y mayusculas). Si
	existe, devuelve un puntero como resultado, de lo contrario lanza una excepcion.
	**********************************************************************/
	public Simbolo buscar_simbolo(String nombre) throws SimboloNoEncontradoException {
		return tabla.buscar_simbolo(nombre);
	}
	
	/**********************************************************************
	Introduce en la tabla un simbolo PROGRAMA, con el nombre
	del parametro, de nivel 0, con la direccion del parametro. Dado que debe
	ser el primer simbolo a introducir, NO SE VERIFICA QUE EL SIMBOLO YA
	EXISTA.
	 * @throws SimboloRepetidoException 
	**********************************************************************/
	public Simbolo introducir_programa(String nombre, int dir) {
		Simbolo simb = new Simbolo();
		simb.introducir_programa(nombre, dir);
		tabla.introducir_simbolo(simb);
		
		return simb;
	}
	
	/**********************************************************************
	Si existe un simbolo en la tabla del mismo nivel y con el mismo
	nombre, lanza una excepcion. De lo contrario, introduce un simbolo VARIABLE (simple)
	con los datos de los argumentos.
	**********************************************************************/
	public Simbolo introducir_variable(String nombre, Tipo_variable variable, int nivel, int dir) throws SimboloRepetidoException {
		tabla.existe(nombre, nivel);
		Simbolo simb = new Simbolo();
		simb.introducir_variable(nombre, nivel, variable, dir);
		tabla.introducir_simbolo(simb);
		
		return simb;
	}
	
	/**********************************************************************
	Si existe un simbolo en la tabla del mismo nivel y con el mismo
	nombre, lanza una excepcion. De lo contrario, introduce un simbolo
	ACCION con los datos de los argumentos.
	**********************************************************************/
	public Simbolo introducir_accion (String nombre, int nivel, int dir) throws SimboloRepetidoException {
		tabla.existe(nombre, nivel);
		Simbolo simb = new Simbolo();
		simb.introducir_accion(nombre, nivel, dir);
		tabla.introducir_simbolo(simb);
		
		return simb;
	}
	
	/**********************************************************************
	Si existe un simbolo en la tabla del mismo nivel y con el mismo
	nombre, lanza una excepcion. De lo contrario, introduce un simbolo
	PARAMETRO con los datos de los argumentos.
	**********************************************************************/
	public Simbolo introducir_parametro (String nombre, Tipo_variable variable, Clase_parametro parametro, int nivel, int dir) 
			throws SimboloRepetidoException {
		tabla.existe(nombre, nivel);
		Simbolo simb = new Simbolo();
		simb.introducir_parametro(nombre, nivel, variable, parametro, dir);
		tabla.introducir_simbolo(simb);
		
		return simb;
	}
	
	/**********************************************************************
	Elimina de la tabla todos los simbolos PROGRAMA de nivel 0 (deberia
	haber uno solo).
	**********************************************************************/
	public void eliminar_programa() {
		tabla.eliminar_nivel(0, Tipo_simbolo.PROGRAMA);
	}
	
	/**********************************************************************
	Elimina de la tabla todas las variables que sean del nivel del argumento.
	NO ELIMINA PARaMETROS.
	**********************************************************************/
	public void eliminar_variables(int nivel) {
		tabla.eliminar_nivel(nivel, Tipo_simbolo.VARIABLE);
	}
	
	/**********************************************************************
	Marca todos los parametros de un nivel como ocultos para que no puedan
	ser encontrados, pero se mantenga la definicion completa de la
	accion donde estan declarados para verificacion de
	invocaciones a la accion.
	**********************************************************************/
	public void ocultar_parametros(int nivel) {
		tabla.establecer_param_ocultos(nivel);
	}
	
	/**********************************************************************
	Elimina de la tabla todas los parametros que hayan sido ocultados
	previamente. LOS PROCEDIMIENTOS Y FUNCIONES DONDE ESTABAN DECLARADOS
	DEBEN SER ELIMINAODS TAMBIEN PARA MANTENER LA COHERENCIA DE LA TABLA.
	**********************************************************************/
	public void eliminar_parametros_ocultos(int nivel) {
		tabla.eliminar_param_ocultos(nivel);
	}
	
	/**********************************************************************
	Elimina de la tabla todas los procedimientos de un nivel.
	LOS PARAMETROS DE ESTAS ACCIONES
	DEBEN SER ELIMINADOS TAMBIEN PARA MANTENER LA COHERENCIA DE LA TABLA.
	**********************************************************************/
	public void eliminar_acciones(int nivel) {
		tabla.eliminar_nivel(nivel+1, Tipo_simbolo.PARAMETRO);
		tabla.eliminar_nivel(nivel, Tipo_simbolo.ACCION);
	}
}
