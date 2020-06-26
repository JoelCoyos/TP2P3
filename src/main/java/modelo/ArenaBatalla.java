package modelo;

import java.util.Random;

public class ArenaBatalla implements iStateArena {

	private Arena arena;

	public ArenaBatalla(Arena arena) {
		this.arena = arena;
	}

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

}
