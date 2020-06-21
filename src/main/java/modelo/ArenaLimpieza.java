package modelo;

public class ArenaLimpieza implements iStateArena {

	private Arena arena;
	
	public ArenaLimpieza(Arena arena) {
		this.arena = arena;
	}
	
	@Override
	public void ejecutarFase() {
		
		System.out.println("\nSE REALIZAN LAS TAREAS DE LIMPIEZA EN PREPARACION PARA LA SIGUIENTE BATALLA\n");
		
		// sleep?
		
		arena.getSemaforo().release();
	}

}
