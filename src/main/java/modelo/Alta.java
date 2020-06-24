package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Alta implements IEtapas {

	@Override
	public void comenzarBatallas() {
	}

	@Override
	public String getNombre() {
		return "Alta";
	}

	@Override
	public void avanzarFase() {
		
		ArrayList<Entrenador> participantes = new ArrayList<Entrenador>();
		Iterator<Entrenador> it = Torneo.getInstance().getEntrenadores().iterator();
		
		while (it.hasNext())
			participantes.add(it.next());
		
		Torneo.getInstance().setParticipantesActuales(participantes);
		Torneo.getInstance().setEtapa(new Desarrollo());
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		Torneo.getInstance().getEntrenadores().add(entrenador);
	}

	@Override
	public void agregarBatalla(Batalla batalla) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ganadorBatalla(Entrenador entrenador) {
		// TODO Auto-generated method stub

	}

	public boolean faseCompletada() {
		return (Torneo.getInstance().cantidadEntrenadoresNecesaria());
	}

}
