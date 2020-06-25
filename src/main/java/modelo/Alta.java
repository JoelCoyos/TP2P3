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
		//Torneo.getInstance().inicializarArenas();
		
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
	}

	@Override
	public void ganadorBatalla(Entrenador entrenador) {
	}

	public boolean faseCompletada() {
		boolean respuesta = true;
		if (!Torneo.getInstance().cantidadEntrenadoresNecesaria()) {
			respuesta = false;
		} else {
			Iterator<Entrenador> it = Torneo.getInstance().getEntrenadores().iterator();
			while (it.hasNext() && respuesta == true) {
				Entrenador e = it.next();
				if (e.cantidadPokemones() < 3)
					respuesta = false;
			}		
			respuesta = true;
		}
		return respuesta;
	}

}
