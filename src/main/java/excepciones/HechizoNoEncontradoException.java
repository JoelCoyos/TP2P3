package excepciones;

/**
 * Excepcion lanzada cuando se ingresa un hechizo a utilizar, pero el mismo no se encuentra en el ArrayList de hechizos <br>
 */
public class HechizoNoEncontradoException extends Exception{
	String entrada;
	
	public HechizoNoEncontradoException(String arg0, String entrada) {
		super(arg0);
		this.entrada = entrada;
	}
	
	public String getEntrada() {
		return entrada;
	}
}
