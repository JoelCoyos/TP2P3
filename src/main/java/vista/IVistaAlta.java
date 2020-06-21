package vista;

import java.awt.event.ActionListener;

public interface IVistaAlta {
	
	String getNombreEntrenador();
	String getNombrePokemon1();
	String getNombrePokemon2();
	String getNombrePokemon3();
	String getNombrePokemon4();
	String getNombrePokemon5();
	String getNombrePokemon6();
	String getTipoPokemon1();
	String getTipoPokemon2();
	String getTipoPokemon3();
	String getTipoPokemon4();
	String getTipoPokemon5();
	String getTipoPokemon6();
	String getRecarga1();
	String getRecarga2();
	String getRecarga3();
	String getRecarga4();
	String getRecarga5();
	String getRecarga6();
	String getGranRecarga1();
	String getGranRecarga2();
	String getGranRecarga3();
	String getGranRecarga4();
	String getGranRecarga5();
	String getGranRecarga6();
	void comenzarTorneo();
	void agregarEntrenador();
	void mostrarPokemon();
	void setActionListener(ActionListener actionListener);

}
