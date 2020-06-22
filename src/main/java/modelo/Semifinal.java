package modelo;

import java.util.ArrayList;

public class Semifinal implements IEtapas {

	@Override
	public void realizarRonda() {

		ArrayList<Entrenador> participantes = Torneo.getInstance().getParticipantesActuales();
		Torneo.getInstance().setParticipantesActuales(new ArrayList<Entrenador>());
		
		
		System.out.println("COMIENZAN LAS SEMIFINALES\n");

		for (int i = 0; i < 2; i++) {
			Arena arena = Torneo.getInstance().getArenas().poll();
			Batalla batalla = new Batalla( participantes.remove(0), participantes.remove(0),arena);
			Torneo.getInstance().getArenas().add(arena);
			batalla.start();
		}
		
		Torneo.getInstance().setEtapa(new Final());
		
	}

}
