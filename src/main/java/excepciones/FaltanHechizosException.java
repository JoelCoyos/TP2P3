package excepciones;

/**
 * Excepcion lanzada cuando se quiere utilizar un hechizo pero la cantidad de hechizos actual no lo permite <br>
 */
public class FaltanHechizosException extends Exception {
	
	private String nombreEntrenador;
	private String nombreHechizo;
	
	
	public FaltanHechizosException(String arg0, String nombreEntrenador, String nombreHechizo) {
		super(arg0);
		this.nombreEntrenador = nombreEntrenador;
		this.nombreHechizo = nombreHechizo;
	}


	public String getNombreEntrenador() {
		return nombreEntrenador;
	}


	public String getNombreHechizo() {
		return nombreHechizo;
	}
	
	
	
	
	
	

}
