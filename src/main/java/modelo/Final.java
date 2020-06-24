package modelo;

import java.util.ArrayList;

public class Final implements IEtapas {
	
	@Override
	public void comenzarBatallas() {

		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		Torneo.getInstance().getParticipantesActuales().clear();

		// System.out.println("COMIENZAN LOS CUARTOS DE FINAL\n");

		Arena arena = Torneo.getInstance().getArenas().poll();
		batallas.get(0).start();
		Torneo.getInstance().getArenas().add(arena);
	}

	@Override
	public void avanzarFase() {
		Torneo.getInstance().setEtapa(new Alta());
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
	public String getNombre() {
		return "Final";
	}

	public Final() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void ganadorBatalla(Entrenador entrenador) {
		Torneo.getInstance().getParticipantesActuales().add(entrenador);
	}

	@Override
	public boolean faseCompletada() {
		return (Torneo.getInstance().getBatallas().size() == 0);
	}

}
