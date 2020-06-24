package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.Pokemon;

public interface IVistaAlta {
	
	String getNombreEntrenador();
	String getNombrePokemon();
	String getTipoPokemon();
	String getRecarga();
	String getGranRecarga();
	void setEntrenadores();
	void comenzarTorneo();
	void mostrarPokemon();
	void setActionListener(ActionListener actionListener);
	void reseteaCampos();
	void agregarEntrenador(Entrenador entrenador);
	Entrenador getEntrenador();
	void mensajeAlerta(String string);
	Entrenador entrenadorSeleccionado();
	void agregarPokemon(Pokemon pokemon);
	Pokemon getPokemon() throws TipoNoEncontradoException;

}
