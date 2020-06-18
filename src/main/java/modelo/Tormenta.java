package modelo;

/**
 *{@link Hechizo} de tipo tormenta<br>
 */
public class Tormenta implements Hechizo {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.tormenta();
	}

	@Override
	public String getNombre() {
		return "Tormenta";
	}

}
