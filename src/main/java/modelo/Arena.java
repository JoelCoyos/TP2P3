package modelo;

import java.util.Observable;
import java.util.concurrent.Semaphore;

public class Arena extends Observable {

	private Batalla batalla;
	private iStateArena estado;
	private Semaphore semaforo = new Semaphore(1);

	public Arena() {
	}
	
	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void ingresarArena(Batalla batalla) {
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		estado = new ArenaPreliminar(this);
		this.batalla = batalla;
		//notificaEstado("Inicia Batalla");
		setChanged();
		System.out.println("Llega");
		notifyObservers(new Object[] { batalla, "Inicia" });
	}

	public void notificaEstado(String string) {
		setChanged();
		notifyObservers(new Object[] { null, string });
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

	public Entrenador getEntrenador1() {
		return this.batalla.getEntrenador1();
	}

	public Entrenador getEntrenador2() {
		return this.batalla.getEntrenador2();
	}

	public Pokemon getPokemon1() {
		return this.batalla.getPokemon1();
	}

	public Pokemon getPokemon2() {
		return this.batalla.getPokemon2();
	}

	public Hechizo getHechizo1() {
		return this.batalla.getHechizo1();
	}

	public Hechizo getHechizo2() {
		return this.batalla.getHechizo2();
	}

	public iStateArena getEstado() {
		return estado;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

}
