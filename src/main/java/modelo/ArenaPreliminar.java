package modelo;

public class ArenaPreliminar implements iStateArena {

	private Arena arena;
	
	public ArenaPreliminar(Arena arena) {
		this.arena = arena;
	}
	
	@Override
	public void ejecutarFase() {
		
		System.out.println("LOS ENTRENADORES " + arena.getEntrenador1().getNombre() + " Y " + arena.getEntrenador2().getNombre() + " INGRESAN A LA ARENA");
		System.out.println(arena.getEntrenador1().getNombre() + " utilizara a su Pokemon " + arena.getPokemon1().getNombre());
		System.out.println(arena.getEntrenador2().getNombre() + " utilizara a su Pokemon " + arena.getPokemon2().getNombre());
		if (arena.getHechizo1() == null) {
			System.out.println(arena.getEntrenador1().getNombre() + " no usara ningun hechizo.");
		}
		else
			System.out.println(arena.getEntrenador1().getNombre() + " utilizara el hechizo " + arena.getHechizo1().getNombre());
		if (arena.getHechizo2() == null) {
			System.out.println(arena.getEntrenador1().getNombre() + " no usara ningun hechizo.");
		}
		else
			System.out.println(arena.getEntrenador1().getNombre() + " utilizara el hechizo " + arena.getHechizo1().getNombre());
		
		arena.setEstado(new ArenaBatalla(arena));
		
	}

}
