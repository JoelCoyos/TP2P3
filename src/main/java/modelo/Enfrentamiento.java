package modelo;

/**
 *En esta clase se podra guardar todos los detalles de un enfrentamiento<br>
 */
public class Enfrentamiento {
	String entGanador, entPerdedor;
	String pokeGanador, pokePerdedor;
	String hecGanador, hecPerdedor;

	/**
	 * Guarda los datos de cada batalla
	 * @param entGanador Entrenador que gano la batalla
	 * @param pokeGanador Pokemon que gano la batalla
	 * @param hecGanador Nombre del hechizo que uso el entrenador ganador
	 * @param entPerdedor Entrenador que perdio la batalla
	 * @param pokePerdedor Pokemon que gano la batalla
	 * @param hecPerdedor Nombre del hechizo que uso el entrenador perdedor
	 * 
	 * <b>Pre: </b> todas las variables distintas de null
	 */
	public Enfrentamiento(String entGanador, String pokeGanador, String hecGanador, String entPerdedor,
			String pokePerdedor, String hecPerdedor) {
		this.entGanador = entGanador;
		this.pokeGanador = pokeGanador;
		this.hecGanador = hecGanador;
		this.entPerdedor = entPerdedor;
		this.pokePerdedor = pokePerdedor;
		this.hecPerdedor = hecPerdedor;
	}
	
	public Enfrentamiento() {
	}

	@Override
	public String toString() {
		return "El entrenador " + entGanador + " se enfrento a " + entPerdedor + " y salio victorioso\nEl pokemon "
				+ pokeGanador + " vencio a " + pokePerdedor + "\nHechizo del ganador: " + hecGanador
				+ " Hechizo del perdedor: " + hecPerdedor;
	}

	public String getEntGanador() {
		return entGanador;
	}

	public void setEntGanador(String entGanador) {
		this.entGanador = entGanador;
	}

	public String getEntPerdedor() {
		return entPerdedor;
	}

	public void setEntPerdedor(String entPerdedor) {
		this.entPerdedor = entPerdedor;
	}

	public String getPokeGanador() {
		return pokeGanador;
	}

	public void setPokeGanador(String pokeGanador) {
		this.pokeGanador = pokeGanador;
	}

	public String getPokePerdedor() {
		return pokePerdedor;
	}

	public void setPokePerdedor(String pokePerdedor) {
		this.pokePerdedor = pokePerdedor;
	}

	public String getHecGanador() {
		return hecGanador;
	}

	public void setHecGanador(String hecGanador) {
		this.hecGanador = hecGanador;
	}

	public String getHecPerdedor() {
		return hecPerdedor;
	}

	public void setHecPerdedor(String hecPerdedor) {
		this.hecPerdedor = hecPerdedor;
	}
	
	
}
