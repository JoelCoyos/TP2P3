package modelo;

import java.util.ArrayList;

public class Desarrollo implements IEtapas {
	
	private int cantidadParticipantes;
	
	public Desarrollo() {
		this.cantidadParticipantes = Torneo.getInstance().getParticipantesActuales().size();
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
		if (cantidadParticipantes == 1)
			Torneo.getInstance().setEtapa(new Premiacion());
		else
			Torneo.getInstance().setEtapa(new Desarrollo());
	}

	@Override
	public String getNombre() {
		return "Desarrollo";
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
		return (cantidadParticipantes/2 == Torneo.getInstance().getParticipantesActuales().size());
	}

}
