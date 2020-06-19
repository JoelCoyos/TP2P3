package vista;

import java.awt.event.ActionListener;

import modelo.Entrenador;

public interface IVista {
	
	
	public void generarEntrenadores();
	public void generarPokemones(Entrenador entrenador);
	public Entrenador[] getEntrenadores();
	
	public void setActionListener(ActionListener actionListener);

}
