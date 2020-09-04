package semantico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import semantico.Simbolo.Tipo_simbolo;

public class Tabla_dispersion {
	// El tamanyo de la tabla debe ser un numero primo y de tamanyo razonable
	private int TAM = 251;
	private LinkedList<Simbolo>[] tabla = new LinkedList[TAM];
	
	// Constructor
	public Tabla_dispersion() {
		for (int i=0; i<TAM; i++) {
            tabla[i] = new LinkedList<Simbolo>();
        }
	}
	
	public void existe(String nombre, Integer n) throws SimboloRepetidoException {
        int i = hash_code(nombre);
        Simbolo s = null;
        
        for (int j=0; j<tabla[i].size(); j++) {
            s = tabla[i].get(j);
            
            if (s.getNombre().equals(nombre) && s.getNivel()==n && s.getVisible()) {
                throw new SimboloRepetidoException();
            }
        }       
    }
	
	public Simbolo buscar_simbolo (String nombre) throws SimboloNoEncontradoException {
		int i = hash_code(nombre);
		Simbolo s = null;
		
		for(int j=0; j<tabla[i].size(); j++) {
			s = tabla[i].get(j);
			if(s.getNombre().equals(nombre) && s.getVisible()) return s;
		}
		
		throw new SimboloNoEncontradoException();
	}
	
	public void introducir_simbolo (Simbolo simb){
		int i = hash_code(simb.getNombre());
		tabla[i].addFirst(simb);
	}
	
	
	public void eliminar_nivel (Integer nivel, Tipo_simbolo tipo) {
		Simbolo s = null;
		ListIterator<Simbolo> iter;
		
		for(int i=0; i<TAM; i++) {
			iter = tabla[i].listIterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.getNivel().equals(nivel) && s.getTipo() == tipo) iter.remove();
			}
		}
	}
	
	public void establecer_param_ocultos (Integer nivel) {
		Simbolo s;
		ListIterator<Simbolo> iter;
		
		for(int i=0; i<TAM; i++) {
			iter = tabla[i].listIterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.getNivel().equals(nivel) && s.getTipo() == Tipo_simbolo.PARAMETRO) s.setVisible(false);
			}
		}
	}
	
	public void eliminar_simbolo(Integer nivel, String nombre) {
		Simbolo s;
		ListIterator<Simbolo> iter;
		
		for(int i=0; i<TAM; i++) {
			iter = tabla[i].listIterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.getNivel().equals(nivel) && s.getNombre().equals(nombre)) {
					iter.remove(); break;
				}
			}
		}
	}
	
	public void eliminar_param_ocultos (Integer nivel) {
		Simbolo s;
		ListIterator<Simbolo> iter;
		ArrayList<Simbolo> param;
		
		for(int i=0; i<TAM; i++) {
			iter = tabla[i].listIterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.getNivel().equals(nivel-1) && s.getTipo() == Tipo_simbolo.ACCION) {
					param = s.getLista_parametros();
					if(!param.isEmpty() && !param.get(0).getVisible()) {
						iter.remove();
						for(int j=0; j<param.size(); j++) this.eliminar_simbolo(nivel, param.get(j).getNombre());
					}
				}
			}
		}
	}
	
	// Metodo de la multiplicacion
	public int hash_code(String nombre) {
		int k = nombre.length();
		double A = (Math.sqrt(5)-1)/2;
		
		double h = TAM * (k*A - Math.floor(k*A));
		
		return (int) h;
	}
}