package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Batalla;
import modelo.Entrenador;

public interface IVistaTorneo {
	
	void mostrarPokemonHechizos();
	void agregarBatalla();
	void comenzarBatallas();
	void setActionListener(ActionListener actionListener);
	void mensajeAlerta(String string);
	Batalla getBatalla();
	void mostrarEntrenadores(ArrayList<Entrenador> entrenadores);
	void progresoBatallas(String progreso);
	
}
