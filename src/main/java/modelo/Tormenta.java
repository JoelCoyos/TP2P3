package modelo;

/**
 *{@link Hechizo} de tipo tormenta<br>
 */
public class Tormenta implements Hechizo {
	
	public Tormenta() {
	}

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.tormenta();
	}

	@Override
	public String toString() {
		return "Tormenta";
	}


}
