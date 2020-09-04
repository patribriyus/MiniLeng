package semantico;

import semantico.Simbolo.Clase_parametro;
import semantico.Simbolo.Tipo_variable;

public class RegistroExpr {
	private Integer valorEnt = null;
	private Boolean valorBool = null;
	private Character valorChar = null;
	private String valorCadena = null;
	
	private Tipo_variable tipo = null;
	private Clase_parametro clase = null;
	
	// Funciones setter
	public void setEnt(int valorEnt)					{ this.valorEnt = valorEnt; 		}
	public void setBool(boolean valorBool)				{ this.valorBool = valorBool; 		}
	public void setChar(char valorChar)					{ this.valorChar = valorChar; 		}
	public void setCadena(String valorCadena)			{ this.valorCadena = valorCadena; 	}
	public void setVariable (Tipo_variable tipo)		{ this.tipo = tipo; 				}
	public void setParametro (Clase_parametro clase)	{ this.clase = clase; 				}

	
	// Funciones getter
	public Integer getEnt()				{ return valorEnt;	  		}
	public Boolean getBool()			{ return valorBool;	  		}
	public Character getChar()			{ return valorChar;	  		}
	public String getCadena()			{ return this.valorCadena; 	}
	public Tipo_variable getVariable()	{ return tipo;		  		}
	public Clase_parametro getClase()	{ return clase; 	  		}
}
