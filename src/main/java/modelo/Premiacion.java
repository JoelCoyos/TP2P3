package modelo;

import java.util.ArrayList;

public class Premiacion implements IEtapas {

	@Override
	public void premiar() {
		Entrenador ganador = Torneo.getInstance().getParticipantesActuales().get(0);
		Torneo.getInstance().getParticipantesActuales().clear();

		System.out.println("EL ENTRENADOR " + ganador.getNombre() + " ES EL GANADOR DEL TORNEO\n");
	}

	@Override
	public String getNombre() {
		return "Premiacion";
	}

	@Override
	public void comenzarBatallas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanzarFase() {
		Torneo.getInstance().setEtapa(new CuartosFinal());
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarBatalla(Batalla batalla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ganadorBatalla(Entrenador entrenador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean faseCompletada() {
		return true;
	}

}
