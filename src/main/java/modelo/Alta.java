package modelo;

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
			Torneo.getInstance().setEtapa(new CuartosFinal());
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
		return 	(Torneo.getInstance().cantidadEntrenadoresNecesaria());
	}

}
