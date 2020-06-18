package excepciones;

/**
 * Excepcion lanzada cuando se quiere ingresar una cantidad de entrenadores mayor a la prevista <br>
 */
public class MaximaCapacidadEntrenadoresException extends Exception {
	private int cantidadMaxima;
	
	public MaximaCapacidadEntrenadoresException(String arg0, int cantidadMaxima) {
		super(arg0);
		this.cantidadMaxima = cantidadMaxima;
	}
	
	public int getCantidadMaxima() {
		return cantidadMaxima;
	}
}
