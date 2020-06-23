package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.FaltanHechizosException;
import excepciones.PokemonNoEncontradoException;

/**
 *Clase que representa a un entrenador en un juego de estrategia por turnos<br>
 */
public class Entrenador implements Cloneable, Clasificable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int cantidadHechizos, puntos = 0;

	/**
	 * @param nombre: nombre del Entrenador<br>
	 */
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Entrenador()
	{
		
	}

	/**
	 * @param pokemon Pokemon a a�adir<br>
	 * A�ade un Pokemon al entrenador<br>
	 * <b>Pre:</b> Es distinto de nulo<br>
	 */
	public void aniadirPokemon(Pokemon pokemon) {
		if (pokemon != null)
			pokemones.add(pokemon);
	}
	
	/**
	 * @param pokemon Pokemon que se quitara del entrenador<br>
	 * Quita un Pokemon al entrenador<br>
	 * <b>Pre:</b> Es distinto de nulo<br>
	 */

	public void quitarPokemon(Pokemon pokemon) {
		pokemones.remove(pokemon);
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemones() {
		return pokemones;
	}

	public int getCantidadHechizos() {
		return cantidadHechizos;
	}

	protected void setCantidadHechizos(int cantidadHechizos) {
		this.cantidadHechizos = cantidadHechizos;
	}

	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param hechizo {@link Hechizo} que se aplicara a un cierto {@link Pokemon}
	 * @param pokemon {@link Pokemon} al que sera aplicado un {@link Hechizo}
	 * @throws FaltanHechizosException En el caso de que el entrenador ya no pueda usar mas hechizos se tirara esta excepcion
	 * Pre: pokemon distinto de nulo
	 */
	public void hechizar(Hechizo hechizo, Pokemon pokemon) throws FaltanHechizosException {
		if (cantidadHechizos > 0) {
			this.cantidadHechizos--;
			hechizo.hechizar(pokemon);
		} else {
			throw new FaltanHechizosException("Un entrenador quizo invocar un hechizo sin tener alguno disponible",
					this.nombre, hechizo.getNombre());
		}

	}

	public int cantidadPokemones() {
		return pokemones.size();
	}

	/**
	 *Clona a un entrenador
	 *@throws CloneNotSupportedException Cuando algunos de los Pokemones que tenga el entrenador no sea cloneable
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Entrenador clonEntrenador = null;
		Pokemon pokeClonado;
		Iterator<Pokemon> iterator = this.pokemones.iterator();
		clonEntrenador = (Entrenador) super.clone();
		clonEntrenador.pokemones = (ArrayList<Pokemon>)pokemones.clone();
		while (iterator.hasNext()) {
			pokeClonado = (Pokemon) iterator.next().clone();
			clonEntrenador.pokemones.add(pokeClonado);
		}
		return clonEntrenador;
	}

	/**
	 * @param nro Numero del pokemon
	 * @return El pokemon solicitado
	 * @throws PokemonNoEncontradoException Se tirara esta expepcion cuando el numero de Pokemon no se encuentre
	 */
	protected Pokemon obtenerPokemon(int nro) throws PokemonNoEncontradoException {
		Pokemon seleccionado = null;
		if (nro >= 1 && nro <= pokemones.size())
			seleccionado = pokemones.get(nro - 1);
		else
			throw new PokemonNoEncontradoException("El Pokemon no fue encontrado", nro, this.getNombre());
		return seleccionado;
	}

	/**
	 * @return Un String con todos los Pokemon
	 */
	public String listadoPokemon() {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		Iterator<Pokemon> it = pokemones.iterator();
		while (it.hasNext()) {
			sb.append(i + 1 + ")- " + it.next().toString());
			sb.append("\n");
			i++;
		}
		return sb.toString();
	}

	/**
	 * Retorna la categoria a la que pertenece el entrenador, la misma se basa en las categorias de sus pokemones
	 */
	@Override
	public int getCategoria() {
		int cont = 0, categoria;
		Iterator<Pokemon> it = pokemones.iterator();
		while (it.hasNext()) {
			cont += it.next().getCategoria() - 1;
		}
		
		if (cont > 4)
			categoria = 3;
		else if (cont > 2)
			categoria = 2;
		else
			categoria = 1;
	
		return categoria;
	}

	/**
	 * Restaura las estadisticas de todos los Pokemon del entrenador
	 */
	public void restaurarPokemones() {
		Iterator<Pokemon> it = pokemones.iterator();
		while (it.hasNext())
			it.next().recuperarse();
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPokemones(ArrayList<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
}
