package modelo;

import java.util.ArrayList;

public class Semifinal implements IEtapas {
	
	public Semifinal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNombre() {
		return "Semifinal";
	}

	
	@Override
	public void comenzarBatallas() {
		// CAMBIAR ESTRUCTURAS A UNAS DONDE ESTEN ENTRENADORES, POKEMONS Y HECHIZOS
		
		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		Torneo.getInstance().getParticipantesActuales().clear();

		// System.out.println("COMIENZAN LOS CUARTOS DE FINAL\n");

		for (int i = 0; i < 2; i++) {
			Arena arena = Torneo.getInstance().getArenas().poll();
			batallas.get(0).start();
			Torneo.getInstance().getArenas().add(arena);
		}
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
	
	public boolean faseCompletada() {
		return (Torneo.getInstance().getBatallas().size() == 0 && Torneo.getInstance().getParticipantesActuales().size() == 2);
	}
}
