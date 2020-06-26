package modelo;

/**
 * Las clases que implementan esta interfaz, harán referencia a las etapas por las que pasa una arena durante una batalla.
 */
public interface iStateArena {

	void ejecutarFase();
	String nombreEstado();
	
}
