package modelo;

import java.util.concurrent.Semaphore;

public class Arena {

	private Batalla batalla;
	private iStateArena estado;
	private Semaphore semaforo = new Semaphore(1, false);

	public Arena() {
	}

	public void ingresarArena(Batalla batalla) {
		try {
			semaforo.acquire();
			estado = new ArenaEleccion(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.batalla = batalla;
	}
	
	public Batalla getBatalla() {
		return batalla;
	}

	public void ejecutarFase() {
		estado.ejecutarFase();
	}

	public void setEstado(iStateArena estado) {
		this.estado = estado;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

}
