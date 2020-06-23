package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class CuartosFinal implements IEtapas {

	public CuartosFinal() {
	}

	@Override
	public void comenzarBatallas() {
		//CAMBIAR ESTRUCTURAS A UNAS DONDE ESTEN ENTRENADORES, POKEMONS Y HECHIZOS
		ArrayList<Entrenador> participantes = Torneo.getInstance().getEntrenadores();
		Torneo.getInstance().setParticipantesActuales(new ArrayList<Entrenador>());
		
		Torneo.getInstance().getArenas().add(new Arena());
		Torneo.getInstance().getArenas().add(new Arena());

		//System.out.println("COMIENZAN LOS CUARTOS DE FINAL\n");


		for (int i = 0; i < 4; i++) {
			Arena arena = Torneo.getInstance().getArenas().poll();
			Batalla batalla = new Batalla( participantes.remove(0), participantes.remove(0),arena);
			Torneo.getInstance().getArenas().add(arena);
			batalla.start();
		}
	}

	@Override
	public String getNombre() {
		return "Cuartos de Final";
	}


}
