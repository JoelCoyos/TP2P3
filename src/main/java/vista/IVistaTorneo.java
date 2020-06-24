package vista;

import java.awt.event.ActionListener;

import modelo.Batalla;

public interface IVistaTorneo {
	
	void mostrarEntrenadores();
	void mostrarPokemonHechizos();
	void agregarBatalla();
	void comenzarBatallas();
	void avanzarFase();
	void setActionListener(ActionListener actionListener);
	void mensajeAlerta(String string);
	Batalla getBatalla();
	
}
