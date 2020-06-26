package modelo;

import java.util.Observable;

public class Arena extends Observable {

	private Batalla batalla;
	private iStateArena estado;

	public Arena() {
	}

	/**
	 * @param batalla: Batalla que ingresara a esta Arena
	 * Se avisa a los observadores que una Batalla ingreso a la Arena
	 * <b>Pre: </b> batalla distinto de null
	 * 
	 */
	public void ingresarArena(Batalla batalla) {
		estado = new ArenaPreliminar(this);
		this.batalla = batalla;
		setChanged();
		notifyObservers(new Object[] { batalla, "Inicia" });
	}


	/**
	 * @param string: mensaje que se envia a los observadores
	 * <b>Pre: </b> string distinto de null
	 */
	public void notificaEstado(String string) {
		setChanged();
		notifyObservers(new Object[] { null, string });
	}

	public Batalla getBatalla() {
		return batalla;
	}


	/**
	 * Delega el funcionamiento de cada fase a su estado
	 */
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
