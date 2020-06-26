package modelo;
/**
 *{@link Hechizo} de tipo Viento<br>
 */
public class Viento implements Hechizo {
	
	public Viento() {
	}

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.viento();
	}

	@Override
	public String toString() {
		return "Viento";
	}

}
