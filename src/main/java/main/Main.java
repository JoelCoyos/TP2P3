package main;

import controlador.Controlador;
import excepciones.EntrenadorRepetidoException;
import excepciones.MaximaCapacidadEntrenadoresException;
import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.PokemonFactory;
import modelo.Torneo;

public class Main {

	public static void main(String[] args) {
		
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
		} catch (TipoNoEncontradoException e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntrenadorRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Controlador controlador = new Controlador();
	}

}
