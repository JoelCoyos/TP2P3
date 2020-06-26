package modelo;

public class ArenaLimpieza implements iStateArena {

	private Arena arena;
	
	public ArenaLimpieza(Arena arena) {
		this.arena = arena;
	}
	
	public ArenaLimpieza() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Se notifica a la arena que se estan realizando las tareas de limpieza
	 * 
	 * <b>Pre: </b> arena distinto de null
	 */
	@Override
	public void ejecutarFase() {
		arena.notificaEstado("\nSE REALIZAN LAS TAREAS DE LIMPIEZA EN PREPARACION PARA LA SIGUIENTE BATALLA\n");
	}

	@Override
	public String nombreEstado() {
		return "Limpieza";
	}
	
	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

}
