package excepciones;

import modelo.Entrenador;

/**
 * Excepcion que se lanza cuando se quiere ingresar al torneo un entrenador que ya existe<br>
 */
public class EntrenadorRepetidoException extends Exception {
	Entrenador entrenador;
	
	public EntrenadorRepetidoException (String arg0, Entrenador entrenador) {
		super(arg0);
		this.entrenador = entrenador;
	}
	
	public Entrenador getEntrenador() {
		return entrenador;
	}
}
