package modelo;

import java.util.Random;

public class ArenaEleccion implements iStateArena {

	private Arena arena;
	
	public ArenaEleccion(Arena arena) {
		this.arena = arena;
	}
	
	@Override
	public void ejecutarFase() {
		
		arena.setHechizo1(null);
		arena.setHechizo2(null);
		
		Random r = new Random();
		arena.setPokemon1(arena.getEntrenador1().getPokemones().get(0));
		arena.setPokemon2(arena.getEntrenador2().getPokemones().get(0));
		
		arena.setEstado(new ArenaPreliminar(arena));
	}

}
