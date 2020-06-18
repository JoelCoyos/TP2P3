package modelo;
/**
 *{@link Hechizo} de tipo Viento<br>
 */
public class Viento implements Hechizo {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.viento();
	}

	@Override
	public String getNombre() {
		return "Viento";
	}

}
