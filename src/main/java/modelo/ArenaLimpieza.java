package modelo;

public class ArenaLimpieza implements iStateArena {

	private Arena arena;
	
	public ArenaLimpieza(Arena arena) {
		this.arena = arena;
	}
	
	@Override
	public void ejecutarFase() {
		
		System.out.println("SE REALIZAN LAS TAREAS DE LIMPIEZA EN PREPARACION PARA LA SIGUIENTE BATALLA");
		
		// sleep?
		
		arena.getSemaforo().release();
	}

}
