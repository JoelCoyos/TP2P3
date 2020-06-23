package modelo;

import java.util.Observable;
import java.util.concurrent.Semaphore;

public class Arena extends Observable {

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
	
	public Entrenador getEntrenador1()
	{
		return this.batalla.getEntrenador1();
	}
	
	public Entrenador getEntrenador2()
	{
		return this.batalla.getEntrenador2();
	}
	
	public Pokemon getPokemon1()
	{
		return this.batalla.getPokemon1();
	}
	
	public Pokemon getPokemon2()
	{
		return this.batalla.getPokemon2();
	}
	
	public Hechizo getHechizo1()
	{
		return this.batalla.getHechizo1();
	}
	
	public Hechizo getHechizo2()
	{
		return this.batalla.getHechizo2();
	}
	
	public void setPokemon1(Pokemon pokemon1)
	{
		this.batalla.setPokemon1(pokemon1);
	}
	
	public void setPokemon2(Pokemon pokemon2)
	{
		this.batalla.setPokemon2(pokemon2);
	}
	
	public void setHechizo1(Hechizo hechizo1)
	{
		this.batalla.setHechizo1(hechizo1);
	}
	
	public void setHechizo2(Hechizo hechizo2)
	{
		this.batalla.setHechizo2(hechizo2);
	}
	
}
