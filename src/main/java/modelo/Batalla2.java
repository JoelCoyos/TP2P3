package modelo;

public class Batalla2 extends Thread {

	private Entrenador entrenador1, entrenador2;
	private Arena arena;
	
	public Batalla2(Arena arena, Entrenador entrenador1, Entrenador entrenador2) {
		this.arena = arena;
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
	}
	
	public void run() {
		try {
			arena.ingresarArena(entrenador1, entrenador2);
			arena.ejecutarFase(); // eleccion
			sleep(1000);
			arena.ejecutarFase(); // preliminar
			sleep(2000);
			arena.ejecutarFase(); // batalla
			sleep(5000);
			arena.ejecutarFase(); // definicion
			sleep(1000);
			arena.ejecutarFase(); // limpieza
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
