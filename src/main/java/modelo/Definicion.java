package modelo;

public class Definicion implements IState {

	@Override
	public void realizarRonda(Batalla batalla) {
		
		//cosas
		batalla.getTorneo().liberarArena(batalla);
		batalla.stop();
		
		
	}

}
