package modelo;

import java.util.ArrayList;

public class Final implements IEtapas {

	@Override
	public void realizarRonda() {
		
		ArrayList<Entrenador> participantes = Torneo.getInstance().getParticipantesActuales();
		Torneo.getInstance().setParticipantesActuales(new ArrayList<Entrenador>());

		Torneo.getInstance().getArenas().add(new Arena());

		System.out.println("COMIENZA LA FINAL\n");
		
		Arena arena = Torneo.getInstance().getArenas().poll();
		Batalla batalla = new Batalla(arena, participantes.remove(0), participantes.remove(0));
		Torneo.getInstance().getArenas().add(arena);
		batalla.start();
		
		Torneo.getInstance().setEtapa(new Premiacion());
		
	}

}
