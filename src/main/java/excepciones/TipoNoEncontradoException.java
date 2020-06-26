package excepciones;

/**
 * Excepcion lanzada si se ingresa el tipo de un pokemon y el mismo no existe <br>
 */

@SuppressWarnings("serial")
public class TipoNoEncontradoException extends Exception {
	private String nombre;
	private String tipo;
	
	public TipoNoEncontradoException(String arg0, String nombre, String tipo) {
		super(arg0);
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}
}
