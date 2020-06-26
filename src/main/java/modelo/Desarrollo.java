package modelo;

import java.util.ArrayList;

public class Desarrollo implements IEtapas {
	
	private int cantidadParticipantes = Torneo.getInstance().getParticipantesActuales().size();
	
	public Desarrollo() {
	}

	public int getCantidadParticipantes() {
		return cantidadParticipantes;
	}

	public void setCantidadParticipantes(int cantidadParticipantes) {
		this.cantidadParticipantes = cantidadParticipantes;
	}

	@Override
	public void comenzarBatallas() {
		
		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		Torneo.getInstance().getParticipantesActuales().clear();
		
		while (!batallas.isEmpty())
			batallas.remove(0).start();
	}

	@Override
	public void avanzarFase() {
		if (cantidadParticipantes == 2) {
			Torneo.getInstance().setEtapa(new Alta());
		}
		else {
			Torneo.getInstance().setEtapa(new Desarrollo());
		}
	}

	@Override
	public String getNombre() {
		return "Desarrollo";
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		
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
		return (cantidadParticipantes/2 == Torneo.getInstance().getParticipantesActuales().size());
	}

}
