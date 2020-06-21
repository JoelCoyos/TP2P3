package modelo;

import java.util.ArrayList;

public interface ITorneo {
	
	Entrenador[] getEntrenadores();
	ArrayList<Pokemon> getPokemon(Entrenador entrenador);
	
	void realizarRonda(Entrenador[] entrenadores);

}
