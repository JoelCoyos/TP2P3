package vista;

import java.awt.event.ActionListener;

public interface IVistaTorneo {
	
	void mostrarEntrenadores();
	void mostrarPokemonHechizos();
	void elegirPokemonHechizo();
	void comenzarBatallas();
	void setActionListener(ActionListener actionListener);
	
}
