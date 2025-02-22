package modelo;

/**
 * La clase Batalla se extiene de Thread, ya que se van a ejecutar varias batallas en paralelo.
 *
 */
public class Batalla extends Thread {

	private Entrenador entrenador1, entrenador2;
	private Pokemon pokemon1, pokemon2;
	private Hechizo hechizo1, hechizo2;
	private Arena arena;
	
	/**
	 * @param entrenador1
	 * @param entrenador2
	 * @param pokemon1
	 * @param pokemon2
	 * @param hechizo1
	 * @param hechizo2
	 */
	public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2, Hechizo hechizo1, Hechizo hechizo2) {
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.hechizo1 = hechizo1;
		this.hechizo2 = hechizo2;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
	}
	
	public Batalla() {
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public Entrenador getEntrenador1() {
		return entrenador1;
	}

	public Entrenador getEntrenador2() {
		return entrenador2;
	}

	public Pokemon getPokemon1() {
		return pokemon1;
	}

	public Pokemon getPokemon2() {
		return pokemon2;
	}

	public Hechizo getHechizo1() {
		return hechizo1;
	}

	public Hechizo getHechizo2() {
		return hechizo2;
	}

	public Arena getArena() {
		return arena;
	}
	

	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public void setHechizo1(Hechizo hechizo1) {
		this.hechizo1 = hechizo1;
	}

	public void setHechizo2(Hechizo hechizo2) {
		this.hechizo2 = hechizo2;
	}

	/**
	 * Método que invoca todos los métodos referidos a las fases de la batalla.
	 * Primero se obtiene una arena sobre la cual se desarrollará la batalla.
	 * Luego las fases se ejecutarán a partir de la misma.
	 */
	public void run() {
		try {
			this.arena = Torneo.getInstance().asignarArena();
			arena.ingresarArena(this);
			arena.ejecutarFase(); // preliminar
			sleep(2000);
			arena.ejecutarFase(); // batalla
			sleep(5000);
			arena.ejecutarFase(); // definicion
			sleep(1000);
			arena.ejecutarFase(); // limpieza
			Torneo.getInstance().liberarArena(arena);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setEntrenador1(Entrenador entrenador1) {
		this.entrenador1 = entrenador1;
	}

	public void setEntrenador2(Entrenador entrenador2) {
		this.entrenador2 = entrenador2;
	}
	
	

}
