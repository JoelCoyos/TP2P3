package modelo;

import java.util.ArrayList;

public class TorneoSerializable {
	
	
	
	private ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	private ArrayList<Entrenador> participantesActuales = new ArrayList<Entrenador>();
	private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
	private ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();
	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	private ArrayList<Batalla> batallas = new ArrayList<Batalla>(); 
	private IEtapas etapa;
	
	/**
	 * Objecto que usara para guardar las variables del torneo que queremos escribir en un archivo
	 */
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

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}

	public ArrayList<Arena> getArenas() {
		return arenas;
	}

	public void setArenas(ArrayList<Arena> arenas) {
		this.arenas = arenas;
	}

	public ArrayList<Batalla> getBatallas() {
		return batallas;
	}

	public void setBatallas(ArrayList<Batalla> batallas) {
		this.batallas = batallas;
	}
	
	

}
