package modelo;

import java.util.ArrayList;

/**
 * Clase vinculada a la realización de batallas en el torneo
 *
 */
public class Desarrollo implements IEtapas {
	
	private int cantidadParticipantes = Torneo.getInstance().getParticipantesActuales().size();
	
	public Desarrollo() {
	}

	public int getCantidadParticipantes() {
		return cantidadParticipantes;
	}

	public void setCantidadParticipantes(int cantidadParticipantes) {
		this.cantidadParticipantes = cantidadParticipantes;
	}

	/**
	 *Toma los participantes actuales y las batallas del {@link Torneo}, limpia los participantes actuales y comienza los threads de cada batalla
	 *
	 *<b>Pre: </b> batallas distinto de null, participantes actuales distinto de null
	 */
	@Override
	public void comenzarBatallas() {
		
		ArrayList<Batalla> batallas = Torneo.getInstance().getBatallas();
		cantidadParticipantes = Torneo.getInstance().getParticipantesActuales().size();
		Torneo.getInstance().getParticipantesActuales().clear();
		
		while (!batallas.isEmpty())
			batallas.remove(0).start();
	}

	/**
	 *Si la cantidad de particpantes actuales son 2 es porque ocurrio la final, se cambia la etapa del torneo a {@link Alta}. 
	 *De lo contrario, se cambia la etapa a un nuevo {@link Desarrollo}
	 */
	@Override
	public void avanzarFase() {
		if (cantidadParticipantes == 2) {
			Torneo.getInstance().setEtapa(new Alta());
		}
		else {
			Torneo.getInstance().setEtapa(new Desarrollo());
		}
	}

	@Override
	public String getNombre() {
		return "Desarrollo";
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		
	}

	/**
	 * Método que agrega una batalla a ejecutarse en el torneo.
	 * 
	 * <b>Pre: </b> batalla distinta de null
	 */
	@Override
	public void agregarBatalla(Batalla batalla) {
		Torneo.getInstance().getBatallas().add(batalla);
	}

	/**
	 * Método que guarda el ganador de una batalla ya ejecutada en el torneo.
	 * 
	 * <b>Pre: </b> entrenador distinto de null
	 */
	@Override
	public void ganadorBatalla(Entrenador entrenador) {
		Torneo.getInstance().getParticipantesActuales().add(entrenador);
	}

	/**
	 *Retorna true si la cantidad de participantes actuales es igual a la mitad de partipantes que empezaron la etapa
	 *
	 *<b>Pre: </b> participantes actuales distinto de null
	 */
	@Override
	public boolean faseCompletada() {
		return (cantidadParticipantes/2 == Torneo.getInstance().getParticipantesActuales().size());
	}

}
