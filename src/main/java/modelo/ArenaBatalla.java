package modelo;

import java.util.Random;

public class ArenaBatalla implements iStateArena {

	private Arena arena;

	/**
	 * @param arena: Arena a la cual pertenece esta fase
	 */
	public ArenaBatalla(Arena arena) {
		this.arena = arena;
	}
	
	public ArenaBatalla() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Se decide al azar que Entrenador comenzara, si tienen se elijen sus hechizos, y ambos Pokemones se enfrentan. 
	 * Se notifica por la arena que termino la batalla y se cambia el estado a {@link ArenaFinalizacion}
	 * 
	 * <b>Pre: </b> arena distinto de null, y con entrenador1, entrenador2, pokemon1, pokemon2 distintos de null
	 */
	@Override
	public void ejecutarFase() {

		Random r = new Random();
		int primero = r.nextInt(2);

		arena.notificaEstado("SE DA INICIO A LA BATALLA\n");

		if (arena.getHechizo1() != null)
			arena.getEntrenador1().hechizar(arena.getHechizo1(), arena.getPokemon2());
		if (arena.getHechizo2() != null)
			arena.getEntrenador2().hechizar(arena.getHechizo2(), arena.getPokemon1());

		if (primero == 1) {
			arena.notificaEstado(
					arena.getPokemon1().getNombre() + " realiza sus ataques sobre " + arena.getPokemon2().getNombre());
			arena.getPokemon1().ataque(arena.getPokemon2());
			arena.notificaEstado(
					arena.getPokemon2().getNombre() + " realiza sus ataques sobre " + arena.getPokemon1().getNombre());
			arena.getPokemon2().ataque(arena.getPokemon1());

		} else {
			arena.notificaEstado(
					arena.getPokemon2().getNombre() + " realiza sus ataques sobre " + arena.getPokemon1().getNombre());
			arena.getPokemon2().ataque(arena.getPokemon1());
			arena.notificaEstado(
					arena.getPokemon1().getNombre() + " realiza sus ataques sobre " + arena.getPokemon2().getNombre());
			arena.getPokemon1().ataque(arena.getPokemon2());

		}

		arena.notificaEstado("FINALIZA LA BATALLA\n");
		arena.setEstado(new ArenaFinalizacion(arena));

	}

	@Override
	public String nombreEstado() {
		return "Batalla";
	}
	
	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

}
