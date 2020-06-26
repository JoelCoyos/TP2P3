package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Clase que maneja el torneo pokemon<br>
 * Este esta compuesto de 8 {@link Entrenador}. El ganador del torneo se
 * decidira en 3 rondas, en un sistema de eliminacion doble<br>
 */
public class Torneo extends Observable {

	private ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	private ArrayList<Entrenador> participantesActuales = new ArrayList<Entrenador>();
	private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
	private ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();
	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	private IEtapas etapa = new Alta();
	private ArrayList<Batalla> batallas = new ArrayList<Batalla>();

	public ArrayList<Batalla> getBatallas() {
		return batallas;
	}

	private static Torneo instance = null;

	/**
	 * Al crear un Torneo se añaden las dos Arenas que se usaran
	 */
	private Torneo() {
	}

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	/**
	 * Aplicacion del patron Singleton
	 * 
	 * @return instancia estatica del torneo
	 */
	public static Torneo getInstance() {

		if (Torneo.instance == null)
			Torneo.instance = new Torneo();
		return instance;
	}

	public ArrayList<Entrenador> getParticipantesActuales() {
		return participantesActuales;
	}

	public void comenzarBatallas() {
		etapa.comenzarBatallas();
	}

	/**
	 * Revisa si es posible avanzar de etapa y lo notifica a sus observadores
	 * 
	 * <b>Pre: </b> etapa distinto de null
	 */
	public void avanzarFase() {
		if (etapa.faseCompletada()) {
			etapa.avanzarFase();
			setChanged();
			notifyObservers(this.etapa);
		} else {
			setChanged();
			notifyObservers(null);
		}
	}

	public void agregarBatalla(Batalla batalla) {
		this.etapa.agregarBatalla(batalla);
	}

	public void agregarEntrenador(Entrenador entrenador) {
		this.etapa.agregarEntrenador(entrenador);
	}

	void ganadorBatalla(Entrenador entrenador) {
		etapa.ganadorBatalla(entrenador);
	}

	/**
	 * Añade un nuevo enfrentamiento
	 * 
	 * @param entGanador   Entrenador que gano la batalla
	 * @param pokeGanador  Pokemon que gano la batalla
	 * @param hecGanador   Hechizo que uso el entrenador ganador
	 * @param entPerdedor  Entrenador que perdio la batalla
	 * @param pokePerdedor Pokemon que gano la batalla
	 * @param hecPerdedor  Hechizo que uso el entrenador perdedor
	 * 
	 *                     <b>Pre: </b> todas las variables distintas de null
	 */
	public void aniadirEnfrentamiento(Entrenador entrenadorGan, Pokemon pokeGan, Hechizo hecGanador,
			Entrenador entrenadorPer, Pokemon pokePer, Hechizo hecPerdedor) {
		String hec1, hec2;
		if (hecGanador != null)
			hec1 = hecGanador.toString();
		else
			hec1 = "Ningun hechizo";
		if (hecPerdedor != null)
			hec2 = hecPerdedor.toString();
		else
			hec2 = "Ningun hechizo";
		enfrentamientos.add(new Enfrentamiento(entrenadorGan.getNombre(), pokeGan.getNombre(), hec1,
				entrenadorPer.getNombre(), pokePer.getNombre(), hec2));
	}

	/**
	 * @return un String con los detalles de cada enfrentamiento<br>
	 */
	public String reporte() {
		Iterator<Enfrentamiento> iterator = enfrentamientos.iterator();
		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			sb.append(iterator.next().toString());
			sb.append("\n\n");
		}
		return sb.toString();
	}

	/**
	 * El puntaje se calcula como la suma del escudo + vitalidad + el 50% de la
	 * fuerza<br>
	 * 
	 * @param pokemon Pokemon a calcular puntaje<br>
	 * @return El puntaje del Pokemon<br>
	 *         Pre: pokemon no nulo
	 */
	protected double puntaje(Pokemon pokemon) {
		return pokemon.getEscudo() + pokemon.getVitalidad() + pokemon.getFuerza() * 0.5;
	}

	/**
	 * Revisa si la cantidad de entrenadores inscriptos es 8<br>
	 */
	public boolean cantidadEntrenadoresNecesaria() {
		return entrenadores.size() == 8;
	}

	/**
	 * Revisa si un entrenador tiene como minimo 1 Pokemon<br>
	 * Si no es asi, devuelve el {@link Entrenador}<br>
	 */
	public boolean tieneMinimoUnPokemon() {
		boolean respuesta = true;
		Iterator<Entrenador> it = entrenadores.iterator();
		while (it.hasNext() && respuesta) {
			if (it.next().cantidadPokemones() < 1)
				respuesta = false;
		}
		return respuesta;
	}

	/**
	 * @param entrenador Entrenador a agregar al torneo<br>
	 * @throws MaximaCapacidadEntrenadoresException Si se agrega mas de 8
	 *                                              entrenadores<br>
	 */

	public void aniadirHechizo(Hechizo hechizo) {
		if (hechizo != null)
			hechizos.add(hechizo);
	}

	public ArrayList<Pokemon> getPokemon(Entrenador entrenador) {
		return entrenador.getPokemones();
	}

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setEtapa(IEtapas etapa) {
		this.etapa = etapa;
	}

	public void setParticipantesActuales(ArrayList<Entrenador> arrayList) {
		participantesActuales = arrayList;
	}

	public IEtapas getEtapa() {
		return etapa;
	}

	/**
	 * Espera que el arrayList de arenas no este vacio
	 * 
	 * @return la primera arena del arrayList
	 * 
	 *         <b>Pre: </b>arenas distinto de null
	 */
	public synchronized Arena asignarArena() {

		while (arenas.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		Arena asignar = this.arenas.remove(0);
		return asignar;
	}

	/**
	 * Agrega una arena al arrayList de arenas y lo notifica
	 * 
	 * @param arena: arena a ingresar
	 * 
	 *               <b>Pre: </b> arena distinto de null
	 */
	public synchronized void liberarArena(Arena arena) {
		arenas.add(arena);
		notifyAll();
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

	public void setEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
		this.enfrentamientos = enfrentamientos;
	}

	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public ArrayList<Arena> getArenas() {
		return arenas;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}

	public void setArenas(ArrayList<Arena> arenas) {
		this.arenas = arenas;
	}

	public void setBatallas(ArrayList<Batalla> batallas) {
		this.batallas = batallas;
	}

}
