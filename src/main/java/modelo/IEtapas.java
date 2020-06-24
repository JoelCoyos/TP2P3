package modelo;

public interface IEtapas {

	void comenzarBatallas();

	void avanzarFase();

	String getNombre();

	void agregarEntrenador(Entrenador entrenador);

	void agregarBatalla(Batalla batalla);

	void ganadorBatalla(Entrenador entrenador);

	boolean faseCompletada();
}
