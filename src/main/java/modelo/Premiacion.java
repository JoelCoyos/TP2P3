package modelo;

import java.util.ArrayList;

public class Premiacion implements IEtapas {

	@Override
	public void comenzarBatallas() {
		Entrenador ganador = Torneo.getInstance().getParticipantesActuales().get(0);
		Torneo.getInstance().getParticipantesActuales().clear();

		System.out.println("EL ENTRENADOR " + ganador.getNombre() + " ES EL GANADOR DEL TORNEO\n");
	}

	@Override
	public String getNombre() {
		return "Premiacion";
	}

}
