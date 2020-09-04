package gener_cod;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenCod {
	private String nom_fichero;
	private String contenido = null;
	private int n_etiq;
	
	// Constructor
	public GenCod (String fichero) {
		nom_fichero = fichero + ".code";
	}
	
	public void empezar_gencod () {
		contenido = "";
		n_etiq = -1;
	}
	
	public String nueva_etiqueta() {
		n_etiq++;
		return "L" + n_etiq;
	}
	
	public int n_etiqueta() {
		return n_etiq;
	}
	
	public void write(String codigo) {
		contenido += codigo;
	}
	
	public void fin(boolean esCorrecto) throws FileNotFoundException {
		if(esCorrecto) { // se genera el fichero .code
			PrintWriter o = new PrintWriter(nom_fichero);
            o.print(contenido); o.close();
            System.out.println("Compilación finalizada. Se ha generado el fichero " + nom_fichero);
		}
		// else el programa presenta fallos y no se crea el .code
	}
}
