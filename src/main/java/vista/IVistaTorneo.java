package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Batalla;
import modelo.Entrenador;

/**
 * Interfaz implementada en la ventana donde se previsualizan los entrenadores con sus pokemons y los hechizos disponibles para cada uno.
 * En la misma también se setean las batallas a ejecutarse.
 */
public interface IVistaTorneo {
	
	void mostrarPokemonHechizos();
	void agregarBatalla();
	void comenzarBatallas();
	void setActionListener(ActionListener actionListener);
	void mensajeAlerta(String string);
	Batalla getBatalla();
	void mostrarEntrenadores(ArrayList<Entrenador> entrenadores);
	void progresoBatallas(Batalla vector);
	void cerrarVentana();
	void premiacion(Entrenador entrenador);
	
}
