package backup;

import java.util.Random;

import excepciones.FaltanHechizosException;
import modelo.Entrenador;
import modelo.Hechizo;
import modelo.IState;
import modelo.Pokemon;

public class Batalla extends Thread {
	
	private Entrenador entrenador1,entrenador2,ganador;
	private Pokemon poke1,poke2;
	private Hechizo hechizo1,hechizo2;
	private int arena;
	private Torneo torneo;
	private IState estado;
	
	public int getArena() {
		return arena;
	}

	
	
	public Batalla(Entrenador entrenador1, Entrenador entrenador2,Torneo torneo) {
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.torneo = torneo;
	
	}

	public Entrenador getGanador() {
		return ganador;
	}

	public void enfrentar() {
			Random r = new Random();
			double puntaje1, puntaje2;

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
		}
	
	@Override
	public void run() {
		while(true)
		{
			this.estado.realizarRonda(this);
		}
		
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


	private double puntaje(Pokemon pokemon) {
		return pokemon.getEscudo() + pokemon.getVitalidad() + pokemon.getFuerza() * 0.5;
	}
	
	public Torneo getTorneo() {
		return torneo;
	}

	public IState getEstado() {
		return estado;
	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}

	public void setEntrenador1(Entrenador entrenador1) {
		this.entrenador1 = entrenador1;
	}

	public void setEntrenador2(Entrenador entrenador2) {
		this.entrenador2 = entrenador2;
	}

	public void setGanador(Entrenador ganador) {
		this.ganador = ganador;
	}

	public void setPoke1(Pokemon poke1) {
		this.poke1 = poke1;
	}

	public void setPoke2(Pokemon poke2) {
		this.poke2 = poke2;
	}

	public void setHechizo1(Hechizo hechizo1) {
		this.hechizo1 = hechizo1;
	}

	public void setHechizo2(Hechizo hechizo2) {
		this.hechizo2 = hechizo2;
	}

	public void setArena(int arena) {
		this.arena = arena;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	

}
