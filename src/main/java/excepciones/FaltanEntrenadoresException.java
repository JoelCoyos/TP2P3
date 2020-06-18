package excepciones;

/**
 * Excepcion que se lanza cuando se ingresa una cantidad de entrenadores menor a la cantidad de entrenadores a enfrentarse <br>
 */
public class FaltanEntrenadoresException extends Exception {
	private int cantidadActual;
	private int cantidadNecesaria;

	public FaltanEntrenadoresException(String arg0, int cantidadActual, int cantidadNecesaria) {
		super(arg0);
		this.cantidadActual = cantidadActual;
		this.cantidadNecesaria = cantidadNecesaria;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public int getCantidadNecesaria() {
		return cantidadNecesaria;
	}

}
