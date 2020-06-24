package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class CuartosFinal implements IEtapas {

	public CuartosFinal() {
	}

	@Override
	public void comenzarBatallas() {
		// CAMBIAR ESTRUCTURAS A UNAS DONDE ESTEN ENTRENADORES, POKEMONS Y HECHIZOS

		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		Torneo.getInstance().getParticipantesActuales().clear();

		Torneo.getInstance().getArenas().add(new Arena()); // POR AHORA
		Torneo.getInstance().getArenas().add(new Arena());

		// System.out.println("COMIENZAN LOS CUARTOS DE FINAL\n");

		for (int i = 0; i < 4; i++) {
			Arena arena = Torneo.getInstance().getArenas().poll();
			batallas.get(0).start();
			Torneo.getInstance().getArenas().add(arena);
		}
	}

	@Override
	public String getNombre() {
		return "Cuartos de Final";
	}

	@Override
	public void avanzarFase() {
		Torneo.getInstance().setEtapa(new Final());
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarBatalla(Batalla batalla) {
		Torneo.getInstance().getBatallas().add(batalla);
	}

	@Override
	public void ganadorBatalla(Entrenador entrenador) {
		Torneo.getInstance().getParticipantesActuales().add(entrenador);
	}

	@Override
	public boolean faseCompletada() {
		return (Torneo.getInstance().getBatallas().size() == 0 && Torneo.getInstance().getParticipantesActuales().size() == 4);
	}

}
