package prueba;

import excepciones.EntrenadorRepetidoException;
import excepciones.FaltanEntrenadoresException;
import excepciones.MaximaCapacidadEntrenadoresException;
import excepciones.RequisitosPokemonesException;
import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.Niebla;
import modelo.Pokemon;
import modelo.PokemonFactory;
import modelo.Tormenta;
import modelo.Torneo;
import modelo.Viento;

public class Main {

	public static void main(String[] args) {

		/*cargarEntrenadores();
		cargarHechizos();

		try {
			Torneo.getInstance().realizarTorneo(); // invocar el metodo varias veces para ver el impacto de las categorias en los hechizos
			System.out.println("\nReporte de los enfrentamientos:\n");
			System.out.println(Torneo.getInstance().reporte());
			Torneo.getInstance().realizarTorneo();
		} catch (FaltanEntrenadoresException e) {
			System.out.println(e.getMessage());
			System.out.println("Numero actual de entrenadores: " + e.getCantidadActual()
					+ " Cantidad de entrenadores necesaria: " + e.getCantidadNecesaria());
		} catch (RequisitosPokemonesException e) {
			System.out.println(e.getMessage());
			System.out
					.println("El entrenador " + e.getEntrenador().getNombre() + " no cumple con los requisitos (minimo "
							+ e.getCantidadRequerida() + " pokemon, posee " + e.getCantidadActual() + ")");
		}

	}

	private static void probarClones() {
		Pokemon clonAgua, clonFuego, clonTierra, clonElectrico, clonHielo;
		Pokemon agua, fuego, tierra, electrico, hielo;
		try {
			agua = PokemonFactory.getPokemon("Gyarados", "Agua", true);
			fuego = PokemonFactory.getPokemon("Charizard", "Fuego", true);
			tierra = PokemonFactory.getPokemon("Graveler", "tierra", true);
			electrico = PokemonFactory.getPokemon("Zapdos", "electrico", true);
			hielo = PokemonFactory.getPokemon("Articuno", "hielo", true, true);
			// CLONEABLES
			try {
				clonAgua = (Pokemon) agua.clone();
				clonFuego = (Pokemon) fuego.clone();
				clonTierra = (Pokemon) tierra.clone();

				clonTierra.setNombre("Tierra clonado");
				clonFuego.setNombre("Fuego clonado");
				clonAgua.setNombre("Agua clonado");

				System.out.println(tierra.toString());
				System.out.println(clonTierra.toString());
				System.out.println(fuego.toString());
				System.out.println(clonFuego.toString());
				System.out.println(agua.toString());
				System.out.println(clonAgua.toString());
			} catch (CloneNotSupportedException e) {
				// no entra, son cloneables
			}
			try {
				clonElectrico = (Pokemon) electrico.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("Tipo de pokemon no cloneable");
			}
			try {
				clonHielo = (Pokemon) hielo.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("Tipo de pokemon no cloneable");
			}

			// ENTRENADORES

			Entrenador entrenadorCloneable = new Entrenador("Original"), noCloneable = new Entrenador("Original"),
					entrenadorClon;

			entrenadorCloneable.aniadirPokemon(tierra);
			entrenadorCloneable.aniadirPokemon(fuego);
			entrenadorCloneable.aniadirPokemon(agua);

			noCloneable.aniadirPokemon(electrico);

			try {
				entrenadorClon = (Entrenador) entrenadorCloneable.clone();
				entrenadorClon.aniadirPokemon(PokemonFactory.getPokemon("Ratata", "tierra", true));

				fuego.setNombre("Charmander");

				System.out.println(entrenadorCloneable.listadoPokemon());
				System.out.println(entrenadorClon.listadoPokemon());

			} catch (CloneNotSupportedException e) {
				// no entra
			}

			try {
				entrenadorClon = (Entrenador) noCloneable.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println("El entrenador posee un tipo de pokemon no cloneable");
			}
		} catch (TipoNoEncontradoException e) {

		}
	}

	private static void cargarHechizos() { // pasar a factory
		Torneo.getInstance().aniadirHechizo(new Tormenta());
		Torneo.getInstance().aniadirHechizo(new Viento());
		Torneo.getInstance().aniadirHechizo(new Niebla());
	}

	private static void cargarEntrenadores() {
		Entrenador e1 = new Entrenador("Ash");
		Entrenador e2 = new Entrenador("Misty");
		Entrenador e3 = new Entrenador("Brock");
		Entrenador e4 = new Entrenador("Tracey");
		Entrenador e5 = new Entrenador("Aura");
		Entrenador e6 = new Entrenador("Max");
		Entrenador e7 = new Entrenador("Maya");
		Entrenador e8 = new Entrenador("Ivy");
		try {
			e1.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e1.aniadirPokemon(PokemonFactory.getPokemon("Charizard", "Fuego", false));
			e1.aniadirPokemon(PokemonFactory.getPokemon("Articuno", "Hielo", true));

			e2.aniadirPokemon(PokemonFactory.getPokemon("Lapras", "Agua", true));
			e2.aniadirPokemon(PokemonFactory.getPokemon("Zapdos", "Electrico", false));
			e2.aniadirPokemon(PokemonFactory.getPokemon("Diglett", "Tierra", true));

			e3.aniadirPokemon(PokemonFactory.getPokemon("Jynx", "Hielo", true));
			e3.aniadirPokemon(PokemonFactory.getPokemon("Charizard", "Fuego", false));
			e3.aniadirPokemon(PokemonFactory.getPokemon("Ponyta", "Fuego", true));

			e4.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e4.aniadirPokemon(PokemonFactory.getPokemon("Milotic", "Agua", false));
			e4.aniadirPokemon(PokemonFactory.getPokemon("Magikarp", "Agua", true));

			e5.aniadirPokemon(PokemonFactory.getPokemon("Chimchar", "Fuego", true));
			e5.aniadirPokemon(PokemonFactory.getPokemon("Dewgong", "Hielo", false));
			e5.aniadirPokemon(PokemonFactory.getPokemon("Slowpoke", "Agua", true));

			e6.aniadirPokemon(PokemonFactory.getPokemon("Vulpix", "Fuego", true));
			e6.aniadirPokemon(PokemonFactory.getPokemon("Sandshrew", "Tierra", false));
			e6.aniadirPokemon(PokemonFactory.getPokemon("Cubone", "Tierra", true));

			e7.aniadirPokemon(PokemonFactory.getPokemon("Cubone", "Tierra", true));
			e7.aniadirPokemon(PokemonFactory.getPokemon("Greninja", "Agua", false));
			e7.aniadirPokemon(PokemonFactory.getPokemon("Cloyster", "Hielo", true));

			e8.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e8.aniadirPokemon(PokemonFactory.getPokemon("Slugma", "Fuego", false));
			e8.aniadirPokemon(PokemonFactory.getPokemon("Diglett", "Tierra", true, true));

			// e8.aniadirPokemon(PokemonFactory.getPokemon("Prueba", "psiquico", true));
			// prueba de la excepcion en el factory
		} catch (TipoNoEncontradoException e) {
			System.out.println(e.getMessage());
			System.out
					.println("El pokemon " + e.getNombre() + " no fue creado, el tipo " + e.getTipo() + " no existe.");
		}

		try {
			Torneo.getInstance().aniadirEntrenador(e1);
			Torneo.getInstance().aniadirEntrenador(e2);
			Torneo.getInstance().aniadirEntrenador(e3);
			Torneo.getInstance().aniadirEntrenador(e4);
			Torneo.getInstance().aniadirEntrenador(e5);
			Torneo.getInstance().aniadirEntrenador(e6);
			Torneo.getInstance().aniadirEntrenador(e7);
			Torneo.getInstance().aniadirEntrenador(e8);
		} catch (MaximaCapacidadEntrenadoresException e) {
			System.out.println(e.getMessage());
			System.out.println("Capacidad maxima del torneo: " + e.getCantidadMaxima() + " entrenadores.");
		} catch (EntrenadorRepetidoException e) {
			System.out.println(e.getMessage());
			System.out.println("El entrenador " + e.getEntrenador().getNombre() + " ya esta inscripto en el torneo.");
		}*/

	}

}
