package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import excepciones.EntrenadorRepetidoException;
import excepciones.FaltanEntrenadoresException;
import excepciones.FaltanHechizosException;
import excepciones.HechizoNoEncontradoException;
import excepciones.MaximaCapacidadEntrenadoresException;
import excepciones.PokemonNoEncontradoException;
import excepciones.RequisitosPokemonesException;

/**
 * Clase que maneja el torneo pokemon<br>
 * Este esta compuesto de 8 {@link Entrenador}. El ganador del torneo se
 * decidira en 3 rondas, en un sistema de eliminacion doble<br>
 */
public class Torneo extends Observable {

	private int numeroEntrenadores = 0;
	private ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	private ArrayList<Entrenador> participantesActuales = new ArrayList<Entrenador>();
	private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
	private ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();
	private Queue<Arena> arenas = new LinkedList<Arena>();
	private IEtapas etapa = new CuartosFinal();

	private static Torneo instance = null;

	private Torneo() {
	}

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public static Torneo getInstance() {

		if (Torneo.instance == null)
			Torneo.instance = new Torneo();
		return instance;
	}

	public ArrayList<Entrenador> getParticipantesActuales() {
		return participantesActuales;
	}

	public Queue<Arena> getArenas() {
		return arenas;
	}

	/**
	 * Ejecuta el torneo en tres rondas: Cuartos, semis y final<br>
	 * 
	 * @throws FaltanEntrenadoresException  Cuando el numero de Entrenadores que
	 *                                      participan en el torneo es menor a 8<br>
	 * @throws RequisitosPokemonesException Cuando se detecta que algun
	 *                                      {@link Entrenador} no tiene por lo menos
	 *                                      un Pokemon<br>
	 */

	/*
	 * public void realizarTorneo() throws FaltanEntrenadoresException,
	 * RequisitosPokemonesException { Entrenador noCumpleRequisitos; Entrenador[]
	 * semifinalistas; Entrenador[] finalistas; Entrenador ganador; if
	 * (cantidadEntrenadoresNecesaria()) { noCumpleRequisitos =
	 * noTieneMinimoUnPokemon(); if (noCumpleRequisitos == null) {
	 * inicializarHechizosDisponibles();
	 * System.out.println("\nSE DISPUTAN LOS CUARTOS DE FINAL DEL TORNEO");
	 * semifinalistas = ejecutarRonda(entrenadores);
	 * System.out.println("\nSE DISPUTAN LAS SEMIFINALES DEL TORNEO"); finalistas =
	 * ejecutarRonda(semifinalistas);
	 * System.out.println("\nSE DISPUTA LA FINAL DEL TORNEO"); ganador =
	 * ejecutarFinal(finalistas); System.out.println("\nEL ENTRENADOR " +
	 * ganador.getNombre() + " HA SIDO EL GANADOR DEL TORNEO");
	 * restaurarPokemones(); } else throw new RequisitosPokemonesException(
	 * "Al menos uno de los entrenadores no cumple con las condiciones del torneo",
	 * 1, noCumpleRequisitos.cantidadPokemones(), noCumpleRequisitos); } else throw
	 * new
	 * FaltanEntrenadoresException("Faltan entrenadores para poder iniciar el torneo"
	 * , numeroEntrenadores, 8); }
	 */

	public void realizarRonda() {
		this.etapa.comenzarBatallas(); // VER DE CAMBIAR POR GANADORES
		//this.etapa.avanzarFase();
		String datos[] = new String[2];
		datos[0] = this.etapa.getNombre();
		//datos[1] = this.etapa.
		this.setChanged();
		this.notifyObservers(this.etapa);
	}

	/**
	 * Restaura a todos los Pokemon de todos los entrenadores<br>
	 */
	protected void restaurarPokemones() {
		for (int i = 0; i < entrenadores.size(); i++)
			entrenadores.get(i).restaurarPokemones();
	}

	/**
	 * Ejecuta la final. El ganador sera el que tenga el mayor puntaje<br>
	 * 
	 * @param finalistas Los dos Entrenadores que compitan en la final<br>
	 * @return Entrenador ganador<br>
	 *         Pre: El array de finalistas tiene dos entrenadores no nulos<br>
	 */

	private Entrenador ejecutarFinal(Entrenador[] finalistas) {
		Pokemon poke1, poke2;
		Hechizo hechizo1, hechizo2;
		Entrenador ganador;
		poke1 = seleccionarPokemon(finalistas[0]);
		poke2 = seleccionarPokemon(finalistas[1]);
		hechizo1 = seleccionarHechizo(finalistas[0]);
		hechizo2 = seleccionarHechizo(finalistas[1]);
		System.out.println("\nCOMIENZA EL ENFRENTAMIENTO\n");
		ganador = enfrentar(finalistas[0], poke1, hechizo1, finalistas[1], poke2, hechizo2);
		return ganador;
	}

	/**
	 * Ejecuta los cuartos y la semi. El ganador de cada partido sera el que tenga
	 * el mayor puntaje<br>
	 * 
	 * @param entrenadoresParticipantes<br>
	 * @return Array de entrenadores victoriosos<br>
	 *         Pre: El array de entrenadores tiene entrenadores no nulos<br>
	 */
	/*
	 * private Entrenador[] ejecutarRonda(Entrenador[] entrenadoresParticipantes) {
	 * int i, participantes = entrenadoresParticipantes.length; Pokemon poke1,
	 * poke2; Hechizo hechizo1, hechizo2; Entrenador[] entrenadoresGanadores = new
	 * Entrenador[participantes / 2]; for (i = 0; i < participantes; i += 2) {
	 * System.out.println("\n" + entrenadoresParticipantes[i].getNombre() + " VS " +
	 * entrenadoresParticipantes[i + 1].getNombre()); poke1 =
	 * seleccionarPokemon(entrenadoresParticipantes[i]); poke2 =
	 * seleccionarPokemon(entrenadoresParticipantes[i + 1]); hechizo1 =
	 * seleccionarHechizo(entrenadoresParticipantes[i]); hechizo2 =
	 * seleccionarHechizo(entrenadoresParticipantes[i + 1]);
	 * System.out.println("\nCOMIENZA EL ENFRENTAMIENTO\n"); Batalla batalla = new
	 * Batalla(entrenadoresParticipantes[i], entrenadoresParticipantes[i+1], poke1,
	 * poke2, hechizo1, hechizo2,this); batalla.start(); } return
	 * entrenadoresGanadores; }
	 */

	/**
	 * Por comandos elejimos que Pokemon del entrenador por batallar<br>
	 * 
	 * @param entrenador Entrenador del que queremos decidir el Pokemon<br>
	 *                   Pre: El entrenador es no nulo y tiene al menos un
	 *                   Pokemon<br>
	 */
	private Pokemon seleccionarPokemon(Entrenador entrenador) {
		Pokemon seleccion = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String nroPokemon;
		int nro;
		do {
			System.out.println("\nPokemones disponibles para " + entrenador.getNombre() + "\n");
			System.out.println(entrenador.listadoPokemon());
			System.out.println("Ingrese el numero del pokemon que desea seleccionar");
			nroPokemon = scanner.nextLine();
			try {
				nro = Integer.parseInt(nroPokemon);
				try {
					seleccion = entrenador.obtenerPokemon(nro);
					System.out.println(entrenador.getNombre() + " selecciona el pokemon " + seleccion.getNombre());
				} catch (PokemonNoEncontradoException e) {
					System.out.println(e.getMessage() + ". El entrenador " + e.getNombreEntrenador()
							+ " no posee un pokemon con indice " + e.getEntrada());
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un numero.");
			}
		} while (seleccion == null);
		return seleccion;

	}

	/**
	 * Por comandos decidimos el Hechizo que usara el entrenador al principio de la
	 * ronda<br>
	 * 
	 * @param entrenador Entrenador que queremos decidir un Hechizo<br>
	 * @return Hechizo decidido, o null si no se usara ninguno<br>
	 *         Pre: Entrenador no nulo<br>
	 */
	private Hechizo seleccionarHechizo(Entrenador entrenador) {
		Hechizo seleccion = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String nombreHechizo;
		System.out.println("\n" + entrenador.getNombre() + " tiene " + entrenador.getCantidadHechizos()
				+ " hechizos disponibles.");
		if (entrenador.getCantidadHechizos() != 0) {
			do {
				System.out.println("Hechizos posibles: " + this.listadoHechizos());
				System.out.println("Ingrese el nombre del hechizo, o \"ninguno\" en caso de que decida no usar uno.");
				nombreHechizo = scanner.nextLine();
				if (!nombreHechizo.equalsIgnoreCase("ninguno")) {
					try {
						seleccion = this.buscarHechizo(nombreHechizo);
						System.out.println(entrenador.getNombre() + " selecciona el hechizo " + seleccion.getNombre());
						nombreHechizo = "ninguno";
					} catch (HechizoNoEncontradoException e) {
						System.out.println(e.getMessage() + ". " + e.getEntrada() + " no existe.");
					}
				}
			} while (!nombreHechizo.equalsIgnoreCase("ninguno"));
		}
		return seleccion;
	}

	/**
	 * Busca un Hechizo que tenga el nombre entregado<br>
	 * 
	 * @param nombreHechizo El nombre del hechizo a buscar<br>
	 * @return Un {@link Hechizo} con el nombre indicado<br>
	 * @throws HechizoNoEncontradoException Si el hechizo con dicho nombre no
	 *                                      existe<br>
	 */
	private Hechizo buscarHechizo(String nombreHechizo) throws HechizoNoEncontradoException {
		Hechizo actual;
		Hechizo seleccion = null;
		Iterator<Hechizo> it = hechizos.iterator();
		while (it.hasNext() && seleccion == null) {
			actual = it.next();
			if (actual.getNombre().equalsIgnoreCase(nombreHechizo))
				seleccion = actual;
		}
		if (seleccion == null)
			throw new HechizoNoEncontradoException("El hechizo no fue encontrado", nombreHechizo);
		return seleccion;
	}

	/**
	 * Enfrenta dos entrenadores, cada uno con un Pokemon.<br>
	 * Se elije al azar quien va primero. Luego cada pokemon ejecuta su secuencia de
	 * ataque<br>
	 * Se calcula el puntaje de cada uno. El ganador sera el que tenga mayor
	 * puntaje<br>
	 * 
	 * @return Ganador<br>
	 *         Pre: Entrenadores y pokemones no nulos<br>
	 */
	private Entrenador enfrentar(Entrenador entrenador1, Pokemon poke1, Hechizo hechizo1, Entrenador entrenador2,
			Pokemon poke2, Hechizo hechizo2) {
		Random r = new Random();
		double puntaje1, puntaje2;
		Entrenador ganador;

		int primero = r.nextInt(2);

		if (hechizo1 != null)
			try {
				entrenador1.hechizar(hechizo1, poke2);
			} catch (FaltanHechizosException e) {
				System.out.println("El entrenador " + e.getNombreEntrenador() + " intento usar el hechizo "
						+ e.getNombreHechizo() + " pero no le quedaban mas."); // en nuestro caso, la lectura no se hace
																				// si cantidad de hechizos = 0
																				// por lo que nunca se lanzara la
																				// excepcion en entrenador.hechizar, se
																				// deja la misma en caso de que otro
																				// torneo
																				// la administre de forma diferente
			}
		if (hechizo2 != null)
			try {
				entrenador2.hechizar(hechizo2, poke1);
			} catch (FaltanHechizosException e) {
				System.out.println("El entrenador " + e.getNombreEntrenador() + " intento usar el hechizo "
						+ e.getNombreHechizo() + " pero no le quedaban mas.");
			}

		if (primero == 1) {
			poke1.ataque(poke2);
			poke2.ataque(poke1);
		} else {
			poke2.ataque(poke1);
			poke1.ataque(poke2);
		}

		puntaje1 = puntaje(poke1);
		puntaje2 = puntaje(poke2);

		System.out.println(
				"\nEntrenador " + entrenador1.getNombre() + " Pokemon: " + poke1.getNombre() + " Puntaje: " + puntaje1);
		System.out.println(
				"Entrenador " + entrenador2.getNombre() + " Pokemon: " + poke2.getNombre() + " Puntaje: " + puntaje2);

		System.out.println(poke1.toString());
		System.out.println(poke2.toString());

		if (puntaje1 > puntaje2) {
			entrenador2.quitarPokemon(poke2);
			entrenador1.aniadirPokemon(poke2);
			poke1.ganar();
			poke2.perder();
			ganador = entrenador1;
			aniadirEnfrentamiento(entrenador1, poke1, hechizo1, entrenador2, poke2, hechizo2);
			System.out.println("\n" + entrenador1.getNombre() + " gano el enfrentamiento. Toma control del pokemon "
					+ poke2.getNombre() + " de " + entrenador2.getNombre());
		} else {
			entrenador1.quitarPokemon(poke1);
			entrenador2.aniadirPokemon(poke1);
			poke2.ganar();
			poke1.perder();
			ganador = entrenador2;
			aniadirEnfrentamiento(entrenador2, poke2, hechizo2, entrenador1, poke1, hechizo1);
			System.out.println("\n" + entrenador2.getNombre() + " gano el enfrentamiento. Toma control del pokemon "
					+ poke1.getNombre() + " de " + entrenador1.getNombre());
		}

		return ganador;
	}

	public void aniadirEnfrentamiento(Entrenador entrenadorGan, Pokemon pokeGan, Hechizo hecGanador,
			Entrenador entrenadorPer, Pokemon pokePer, Hechizo hecPerdedor) {
		String hec1, hec2;
		if (hecGanador != null)
			hec1 = hecGanador.getNombre();
		else
			hec1 = "Ningun hechizo";
		if (hecPerdedor != null)
			hec2 = hecPerdedor.getNombre();
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
	private boolean cantidadEntrenadoresNecesaria() {
		return numeroEntrenadores == 8;
	}

	/**
	 * Revisa si un entrenador tiene como minimo 1 Pokemon<br>
	 * Si no es asi, devuelve el {@link Entrenador}<br>
	 */
	// private Entrenador noTieneMinimoUnPokemon() {
	// Entrenador respuesta = null;
	// Entrenador actual;
	// int i = 0;
	// while (i < 8 && respuesta == null) {
	// actual = entrenadores[i];
	// if (actual.cantidadPokemones() < 1)
	// respuesta = actual;
	// i++;
	// }
	// return respuesta;
	// }

	/**
	 * @param entrenador Entrenador a agregar al torneo<br>
	 * @throws MaximaCapacidadEntrenadoresException Si se agrega mas de 8
	 *                                              entrenadores<br>
	 */
	public void aniadirEntrenador(Entrenador entrenador)
			throws MaximaCapacidadEntrenadoresException, EntrenadorRepetidoException {
		if (entrenador != null) {
			entrenadores.add(entrenador);
		}
	}

	private boolean isRepetido(Entrenador entrenador) {
		boolean repetido = false;
		int i = 0;
		while (!repetido && i < numeroEntrenadores) {
			// if (entrenadores[i] == entrenador)
			repetido = true;
			i++;
		}
		return repetido;
	}

	public void aniadirHechizo(Hechizo hechizo) {
		if (hechizo != null)
			hechizos.add(hechizo);
	}

	/**
	 * @return Un string listando todos los hechizos<br>
	 */
	private String listadoHechizos() {
		StringBuilder sb = new StringBuilder();
		Iterator<Hechizo> it = hechizos.iterator();
		while (it.hasNext()) {
			sb.append(it.next().getNombre());
			sb.append(" ");
		}
		return sb.toString();
	}

	// private void inicializarHechizosDisponibles() {
	// for (int i = 0; i < entrenadores.length; i++)
	// entrenadores[i].setCantidadHechizos(entrenadores[i].getCategoria());
	// }

	public ArrayList<Pokemon> getPokemon(Entrenador entrenador) {
		return entrenador.getPokemones();
	}

	// public int getNumeroEntrenadores() {
	// return numeroEntrenadores;
	// }

	// public void setNumeroEntrenadores(int numeroEntrenadores) {
	// this.numeroEntrenadores = numeroEntrenadores;
	// }
	// return enfrentamientos;
	// }

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}

	public void setEtapa(IEtapas etapa) {
		this.etapa = etapa;
	}

	public void sigueEnTorneo(Entrenador entrenador) {
		participantesActuales.add(entrenador);
	}

	public void setParticipantesActuales(ArrayList<Entrenador> arrayList) {
		participantesActuales = arrayList;
	}
	
	public void agregarEntrenador(Entrenador entrenador) {
		
	}
	
	public void agregarBatalla(Batalla batalla) {
		
	}
}
