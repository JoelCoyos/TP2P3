package modelo;

import java.util.concurrent.Semaphore;

public class Arena {

	private Entrenador entrenador1, entrenador2;
	private Pokemon pokemon1, pokemon2;
	private Hechizo hechizo1, hechizo2;
	private iStateArena estado;
	private Semaphore semaforo = new Semaphore(1, false);

	public Arena() {
	}

	public void ingresarArena(Entrenador entrenador1, Entrenador entrenador2) {
		try {
			semaforo.acquire();
			estado = new ArenaEleccion(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
	}

	public void ejecutarFase() {
		estado.ejecutarFase();
	}

	public Entrenador getEntrenador1() {
		return entrenador1;
	}

	public Entrenador getEntrenador2() {
		return entrenador2;
	}

	public Pokemon getPokemon1() {
		return pokemon1;
	}

	public Pokemon getPokemon2() {
		return pokemon2;
	}

	public Hechizo getHechizo1() {
		return hechizo1;
	}

	public Hechizo getHechizo2() {
		return hechizo2;
	}

	public void setEstado(iStateArena estado) {
		this.estado = estado;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public void setHechizo1(Hechizo hechizo1) {
		this.hechizo1 = hechizo1;
	}

	public void setHechizo2(Hechizo hechizo2) {
		this.hechizo2 = hechizo2;
	}

}
