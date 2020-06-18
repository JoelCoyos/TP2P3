package modelo;

/**
 *En esta clase se podra guardar todos los detalles de un enfrentamiento<br>
 */
public class Enfrentamiento {
	String entGanador, entPerdedor;
	String pokeGanador, pokePerdedor;
	String hecGanador, hecPerdedor;

	public Enfrentamiento(String entGanador, String pokeGanador, String hecGanador, String entPerdedor,
			String pokePerdedor, String hecPerdedor) {
		this.entGanador = entGanador;
		this.pokeGanador = pokeGanador;
		this.hecGanador = hecGanador;
		this.entPerdedor = entPerdedor;
		this.pokePerdedor = pokePerdedor;
		this.hecPerdedor = hecPerdedor;
	}

	@Override
	public String toString() {
		return "El entrenador " + entGanador + " se enfrento a " + entPerdedor + " y salio victorioso\nEl pokemon "
				+ pokeGanador + " vencio a " + pokePerdedor + "\nHechizo del ganador: " + hecGanador
				+ " Hechizo del perdedor: " + hecPerdedor;
	}
}
