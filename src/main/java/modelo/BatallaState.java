package modelo;

public class BatallaState implements IState {
	
	private Batalla batalla;

	@Override
	public void realizarRonda(Batalla batalla) {
		this.batalla = batalla;
		Util.espera(2500); //Duracion de la batalla
		batalla.enfrentar();
		batalla.setEstado(new Definicion());
	}



}
