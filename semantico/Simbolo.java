package semantico;

import java.util.ArrayList;

public class Simbolo {
	public enum Tipo_simbolo 	{ PROGRAMA, VARIABLE, ACCION, PARAMETRO };
	public enum Tipo_variable 	{ DESCONOCIDO, ENTERO, BOOLEANO, CHAR, CADENA };
	public enum Clase_parametro { VAL, REF };
	
	// Atributos
	private String nombre = null;
	private Integer nivel = null;
	private Tipo_simbolo tipo = null;
	private Tipo_variable variable = null;
	private Clase_parametro parametro = null;
	private boolean visible = true;
	private ArrayList<Simbolo> lista_parametros = null;
	private int dir;
	
	// Metodos getter
	public String getNombre() 							{ return nombre; }
	public Integer getNivel() 							{ return nivel; }
	public Tipo_simbolo getTipo() 						{ return tipo; }
	public Tipo_variable getVariable() 					{ return variable; }
	public Clase_parametro getParametro() 				{ return parametro; }
	public boolean getVisible() 						{ return visible; }
	public ArrayList<Simbolo> getLista_parametros() 	{ return lista_parametros; }
	public int getDir() 								{ return dir; }
	
	// Metodos setter
	public void setNombre(String nombre) 									{ this.nombre = nombre; }
	public void setNivel(Integer nivel) 									{ this.nivel = nivel; }
	public void setTipo(Tipo_simbolo tipo) 									{ this.tipo = tipo; }
	public void setVariable(Tipo_variable variable) 						{ this.variable = variable; }
	public void setParametro(Clase_parametro parametro) 					{ this.parametro = parametro; }
	public void setVisible(boolean visible) 								{ this.visible = visible; }
	public void setLista_parametros(ArrayList<Simbolo> lista_parametros) 	{ this.lista_parametros = lista_parametros; }
	public void setDir(int dir) 											{ this.dir = dir; }
	
	// Metodos de configuracion para cada tipo de simbolo
	public void introducir_programa(String nombre, int dir) {
		setNombre(nombre);
		setNivel(0);
		setTipo(Tipo_simbolo.PROGRAMA);
		setDir(dir);
	}
	
	public void introducir_variable(String nombre, Integer nivel, Tipo_variable variable, int dir) {
		setNombre(nombre);
		setNivel(nivel);
		setTipo(Tipo_simbolo.VARIABLE);
		setVariable(variable);
		setDir(dir);
	}
	
	public void introducir_accion(String nombre, Integer nivel, int dir) {
		setNombre(nombre);
		setNivel(nivel);
		setTipo(Tipo_simbolo.ACCION);
		setDir(dir);
	}
	
	public void introducir_parametro(String nombre, Integer nivel, Tipo_variable variable, Clase_parametro parametro, int dir) {
		setNombre(nombre);
		setNivel(nivel);
		setTipo(Tipo_simbolo.PARAMETRO);
		setVariable(variable);
		setParametro(parametro);
		setDir(dir);
	}
	
	// Funciones extra - analisis semantico
	public boolean ES_PROGRAMA() 	{ return this.tipo == Tipo_simbolo.PROGRAMA; }
	public boolean ES_VARIABLE() 	{ return this.tipo == Tipo_simbolo.VARIABLE; }
	public boolean ES_ACCION() 		{ return this.tipo == Tipo_simbolo.ACCION; }
	public boolean ES_PARAMETRO()	{ return this.tipo == Tipo_simbolo.PARAMETRO; }
	public boolean ES_VALOR() 		{ return ES_PARAMETRO() && (this.parametro == Clase_parametro.VAL);}
	public boolean ES_REFERENCIA() 	{ return ES_PARAMETRO() && (this.parametro == Clase_parametro.REF);}
}
