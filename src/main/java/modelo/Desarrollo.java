package modelo;

import java.util.ArrayList;

public class Desarrollo implements IEtapas {

	private int participantesFase;

	public Desarrollo() {
		participantesFase = Torneo.getInstance().getParticipantesActuales().size();
	}

	@Override
	public void comenzarBatallas() {

		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		Torneo.getInstance().getParticipantesActuales().clear();

		if (participantesFase == 8) {
			Torneo.getInstance().getArenas().add(new Arena()); // POR AHORA
			Torneo.getInstance().getArenas().add(new Arena());
		}
		// System.out.println("COMIENZAN LOS CUARTOS DE FINAL\n");

		for (int i = 0; i < participantesFase / 2; i++) {
			batallas.remove(0).start();
		}
	}

	@Override
	public String getNombre() {
		return "Desarrollo";
	}

	@Override
	public void avanzarFase() {
		if (Torneo.getInstance().getParticipantesActuales().size() == 1)
			Torneo.getInstance().setEtapa(new Premiacion());
		else
			Torneo.getInstance().setEtapa(new Desarrollo());
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
		return (Torneo.getInstance().getBatallas().isEmpty()
				&& Torneo.getInstance().getParticipantesActuales().size() == participantesFase / 2);
	}

	@Override
	public void premiar() {
		// TODO Auto-generated method stub

	}

}
