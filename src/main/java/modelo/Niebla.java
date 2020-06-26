package modelo;

/**
 *{@link Hechizo} de tipo niebla<br>
 */
public class Niebla implements Hechizo {
	
	public Niebla() {
	}

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.niebla();
	}

	@Override
	public String toString() {
		return "Niebla";
	}
	

}
