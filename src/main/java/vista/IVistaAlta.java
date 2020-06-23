package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Entrenador;

public interface IVistaAlta {
	
	String getNombreEntrenador();
	String getNombrePokemon();
	String getTipoPokemon();
	String getRecarga();
	String getGranRecarga();
	void setEntrenadores();
	void comenzarTorneo();
	void agregarEntrenador();
	void agregarPokemon();
	void mostrarPokemon();
	void setActionListener(ActionListener actionListener);
	void reseteaCampos();
	ArrayList<Entrenador> getEntrenadores();
	boolean sePuedeEmpezar();
	void noPuedeEmpezar();

}
