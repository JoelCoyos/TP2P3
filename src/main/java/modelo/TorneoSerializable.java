package modelo;

import java.util.ArrayList;

public class TorneoSerializable {
	
	private ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	private ArrayList<Entrenador> participantesActuales = new ArrayList<Entrenador>();
	private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
	private IEtapas etapa;
	
	public TorneoSerializable() {

	}

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public ArrayList<Entrenador> getParticipantesActuales() {
		return participantesActuales;
	}

	public void setParticipantesActuales(ArrayList<Entrenador> participantesActuales) {
		this.participantesActuales = participantesActuales;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

	public void setEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
		this.enfrentamientos = enfrentamientos;
	}

	public IEtapas getEtapa() {
		return etapa;
	}

	public void setEtapa(IEtapas etapa) {
		this.etapa = etapa;
	}
	
	

}
