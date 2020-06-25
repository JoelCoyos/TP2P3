package modelo;

import java.util.Random;

import excepciones.FaltanHechizosException;

public class ArenaBatalla implements iStateArena {

	private Arena arena;

	public ArenaBatalla(Arena arena) {
		this.arena = arena;
	}

	@Override
	public void ejecutarFase() {

		Random r = new Random();
		int primero = r.nextInt(2);

		System.out.println("SE DA INICIO A LA BATALLA\n");

		if (arena.getHechizo1() != null)
			try {
				arena.getEntrenador1().hechizar(arena.getHechizo1(), arena.getPokemon2());
			} catch (FaltanHechizosException e) {
				System.out.println("El entrenador " + e.getNombreEntrenador() + " intento usar el hechizo "
						+ e.getNombreHechizo() + " pero no le quedaban mas."); // VER SI QUITAR, DEPENDE DE VENTANA
			}
		
		if (arena.getHechizo2() != null)
			try {
				arena.getEntrenador2().hechizar(arena.getHechizo2(), arena.getPokemon1());
			} catch (FaltanHechizosException e) {
				System.out.println("El entrenador " + e.getNombreEntrenador() + " intento usar el hechizo "
						+ e.getNombreHechizo() + " pero no le quedaban mas."); // VER SI QUITAR, DEPENDE DE VENTANA
			}

		if (primero == 1) {
			
			arena.getPokemon1().ataque(arena.getPokemon2());
			arena.getPokemon2().ataque(arena.getPokemon1());
			
		} else {
			
			arena.getPokemon2().ataque(arena.getPokemon1());
			arena.getPokemon1().ataque(arena.getPokemon2());
			
		}
		
		System.out.println("FINALIZA LA BATALLA\n");
		arena.setEstado(new ArenaFinalizacion(arena));
	
	}

	@Override
	public String nombreEstado() {
		return "Batalla";
	}

}
