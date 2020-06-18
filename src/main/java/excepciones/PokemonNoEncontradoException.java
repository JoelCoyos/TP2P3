package excepciones;

/**
 * Excepcion lanzada cuando se quiere ingresar un pokemon del listado mostrado que no existe <br>
 */
public class PokemonNoEncontradoException extends Exception {
	int entrada;
	String nombreEntrenador;
	
	public PokemonNoEncontradoException(String arg0, int entrada, String nombreEntrenador) {
		super(arg0);
		this.entrada = entrada;
		this.nombreEntrenador = nombreEntrenador;
	}
	
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	
	public int getEntrada() {
		return entrada;
	}
}
