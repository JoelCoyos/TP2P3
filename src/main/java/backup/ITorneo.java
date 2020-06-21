package backup;

import java.util.ArrayList;

import modelo.Entrenador;
import modelo.Pokemon;

public interface ITorneo {
	
	Entrenador[] getEntrenadores();
	ArrayList<Pokemon> getPokemon(Entrenador entrenador);
	
	void realizarRonda(Entrenador[] entrenadores);

}
