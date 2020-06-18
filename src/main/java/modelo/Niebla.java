package modelo;

/**
 *{@link Hechizo} de tipo niebla<br>
 */
public class Niebla implements Hechizo {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.niebla();
	}

	@Override
	public String getNombre() {
		return "Niebla";
	}
	

}
