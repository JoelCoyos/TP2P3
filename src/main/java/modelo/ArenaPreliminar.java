package modelo;

public class ArenaPreliminar implements iStateArena {

	private Arena arena;
	
	public ArenaPreliminar(Arena arena) {
		this.arena = arena;
	}
	
	@Override
	public void ejecutarFase() {

		arena.notificaEstado("LOS ENTRENADORES " + arena.getEntrenador1().getNombre() + " Y " + arena.getEntrenador2().getNombre() + " INGRESAN A LA ARENA\n");
		arena.notificaEstado(arena.getEntrenador1().getNombre() + " utilizara a su Pokemon " + arena.getPokemon1().getNombre());
		arena.notificaEstado(arena.getEntrenador2().getNombre() + " utilizara a su Pokemon " + arena.getPokemon2().getNombre() + "\n");
		if (arena.getHechizo1() == null) {
			arena.notificaEstado(arena.getEntrenador1().getNombre() + " no usara ningun hechizo.");
		}
		else
			arena.notificaEstado(arena.getEntrenador1().getNombre() + " utilizara el hechizo " + arena.getHechizo1().toString());
		if (arena.getHechizo2() == null) {
			arena.notificaEstado(arena.getEntrenador2().getNombre() + " no usara ningun hechizo.\n");
		}
		else
			arena.notificaEstado(arena.getEntrenador2().getNombre() + " utilizara el hechizo " + arena.getHechizo2().toString() + "\n");
		
		arena.setEstado(new ArenaBatalla(arena));
		
	}

	@Override
	public String nombreEstado() {
		return "Preliminar";
	}

}
