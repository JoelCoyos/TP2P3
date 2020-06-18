package excepciones;

import modelo.Entrenador;

/**
 * Excepcion lanzada si no se ingresa por lo menos un pokemon para un entrenador <br>
 */
public class RequisitosPokemonesException extends Exception {
	private int cantidadRequerida;
	private int cantidadActual;
	private Entrenador entrenador;

	public RequisitosPokemonesException(String arg0, int cantidadRequerida, int cantidadActual, Entrenador entrenador) {
		super(arg0);
		this.cantidadRequerida = cantidadRequerida;
		this.cantidadActual = cantidadActual;
		this.entrenador = entrenador;
	}

	public int getCantidadRequerida() {
		return cantidadRequerida;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

}
