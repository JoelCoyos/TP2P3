package modelo;

import java.util.ArrayList;

public class Premiacion implements IEtapas {

	@Override
	public String getNombre() {
		return "Premiacion";
	}

	@Override
	public void avanzarFase() {
		Torneo.getInstance().setEtapa(new Alta());
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

	@Override
	public void comenzarBatallas() {
		// TODO Auto-generated method stub
		
	}

}
