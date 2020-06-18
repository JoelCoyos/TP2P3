package modelo;

import java.util.Random;

import excepciones.FaltanHechizosException;

public class Batalla extends Thread {
	
	private Entrenador entrenador1,entrenador2;
	private Pokemon poke1,poke2;
	private Hechizo hechizo1,hechizo2;
	private int puntaje1,puntaje2;
	private Arena arena;
	private Torneo torneo;
	
	
	
	
	public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2, Hechizo hechizo1,
			Hechizo hechizo2, int puntaje1, int puntaje2,Torneo torneo) {
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.poke1 = pokemon1;
		this.poke2 = pokemon2;
		this.hechizo1 = hechizo1;
		this.hechizo2 = hechizo2;
		this.puntaje1 = puntaje1;
		this.puntaje2 = puntaje2;
		this.torneo = torneo;
	}

	public  Entrenador enfrentar() {
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
				System.out.println("\n" + entrenador1.getNombre() + " gano el enfrentamiento. Toma control del pokemon "
						+ poke2.getNombre() + " de " + entrenador2.getNombre());
			} else {
				entrenador1.quitarPokemon(poke1);
				entrenador2.aniadirPokemon(poke1);
				poke2.ganar();
				poke1.perder();
				ganador = entrenador2;
				System.out.println("\n" + entrenador2.getNombre() + " gano el enfrentamiento. Toma control del pokemon "
						+ poke1.getNombre() + " de " + entrenador1.getNombre());
			}

			return ganador;
		}
	
	public Entrenador getEntrenador1() {
		return entrenador1;
	}

	public Entrenador getEntrenador2() {
		return entrenador2;
	}

	public Pokemon getPoke1() {
		return poke1;
	}

	public Pokemon getPoke2() {
		return poke2;
	}

	public Hechizo getHechizo1() {
		return hechizo1;
	}

	public Hechizo getHechizo2() {
		return hechizo2;
	}

	public int getPuntaje1() {
		return puntaje1;
	}

	public int getPuntaje2() {
		return puntaje2;
	}

	private double puntaje(Pokemon pokemon) {
		return pokemon.getEscudo() + pokemon.getVitalidad() + pokemon.getFuerza() * 0.5;
	}
	
	@Override
	public void run() {
		
		torneo.agregarArena(this);
		Util.espera(2500); //duracion de la batalla
		
		
		
	}

}
