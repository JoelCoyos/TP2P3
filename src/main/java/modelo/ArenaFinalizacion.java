package modelo;

public class ArenaFinalizacion implements iStateArena {

	private Arena arena;

	public ArenaFinalizacion(Arena arena) {
		this.arena = arena;
	}
	
	public ArenaFinalizacion() {
	}

	@Override
	public void ejecutarFase() {

		double puntaje1 = Torneo.getInstance().puntaje(arena.getPokemon1());
		double puntaje2 = Torneo.getInstance().puntaje(arena.getPokemon2());

		arena.notificaEstado("RESULTADOS FINALES\n");

		arena.notificaEstado("\nEntrenador " + arena.getEntrenador1().getNombre() + " Pokemon: "
				+ arena.getPokemon1().getNombre() + " Puntaje: " + puntaje1);
		arena.notificaEstado("Entrenador " + arena.getEntrenador2().getNombre() + " Pokemon: "
				+ arena.getPokemon2().getNombre() + " Puntaje: " + puntaje2 + "\n");

		arena.notificaEstado(arena.getPokemon1().toString(
				));
		arena.notificaEstado(arena.getPokemon2().toString());

		if (puntaje1 > puntaje2) {
			Torneo.getInstance().ganadorBatalla(arena.getEntrenador1());
			arena.getEntrenador2().quitarPokemon(arena.getPokemon2());
			arena.getEntrenador1().aniadirPokemon(arena.getPokemon2());
			arena.getPokemon1().ganar();
			arena.getPokemon2().perder();
			Torneo.getInstance().aniadirEnfrentamiento(arena.getEntrenador1(), arena.getPokemon1(), arena.getHechizo1(),
					arena.getEntrenador2(), arena.getPokemon2(), arena.getHechizo2());
			arena.notificaEstado(
					"\n" + arena.getEntrenador1().getNombre() + " gano el enfrentamiento. Toma control del pokemon "
							+ arena.getPokemon2().getNombre() + " de " + arena.getEntrenador2().getNombre());
		} else {
			Torneo.getInstance().ganadorBatalla(arena.getEntrenador2());
			arena.getEntrenador1().quitarPokemon(arena.getPokemon1());
			arena.getEntrenador2().aniadirPokemon(arena.getPokemon1());
			arena.getPokemon2().ganar();
			arena.getPokemon1().perder();
			Torneo.getInstance().aniadirEnfrentamiento(arena.getEntrenador2(), arena.getPokemon2(), arena.getHechizo2(),
					arena.getEntrenador1(), arena.getPokemon1(), arena.getHechizo1());
			arena.notificaEstado(
					"\n" + arena.getEntrenador2().getNombre() + " gano el enfrentamiento. Toma control del pokemon "
							+ arena.getPokemon1().getNombre() + " de " + arena.getEntrenador1().getNombre());
		}

		arena.setEstado(new ArenaLimpieza(arena));
	}

	@Override
	public String nombreEstado() {
		return "Finalizacion";
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	

}
