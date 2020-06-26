package modelo;

public class ArenaPreliminar implements iStateArena {

	private Arena arena;
	
	public ArenaPreliminar(Arena arena) {
		this.arena = arena;
	}
	
	public ArenaPreliminar() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *Se notifican los entrenadores que participaran en esta arena. Se cambia el estado de la arena a {@link ArenaBatalla}
	 *
	 *<b>Pre: </b> arena distinto de null, y con entrenador1, entrenador2, pokemon1, pokemon2 distintos de null
	 */
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
	
	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

}
