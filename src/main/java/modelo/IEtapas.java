package modelo;

/**
 * Una etapa va a ser referencia a una de las dos posibles etapas del torneo: alta o desarrollo.
 */
public interface IEtapas {

	void comenzarBatallas();

	void avanzarFase();

	String getNombre();

	void agregarEntrenador(Entrenador entrenador);

	void agregarBatalla(Batalla batalla);

	void ganadorBatalla(Entrenador entrenador);

	boolean faseCompletada();
}
