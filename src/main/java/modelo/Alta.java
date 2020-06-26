package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Alta implements IEtapas {

	public Alta() {
	}

	@Override
	public void comenzarBatallas() {
	}

	@Override
	public String getNombre() {
		return "Alta";
	}

	/**
	 * Toma los entrenadores del {@link Torneo}, restaura sus Pokemones, les da una
	 * determinada cantidad de hechizos dependiendo de la categoria , los agrega a
	 * los participantes actuales y cambia la etapa del Torneo a Desarrollo
	 *
	 * <b>Pre: </b> El arrayList de entrenadores del Torneo es distinto de null y
	 * cada entrenador tiene por lo menos un Pokemon
	 */
	@Override
	public void avanzarFase() {

		ArrayList<Entrenador> participantes = new ArrayList<Entrenador>();
		Iterator<Entrenador> it = Torneo.getInstance().getEntrenadores().iterator();
		Entrenador entrenador;
		
		if (Torneo.getInstance().getArenas().isEmpty()) {
			Torneo.getInstance().getArenas().add(new Arena());
			Torneo.getInstance().getArenas().add(new Arena());
		}

		while (it.hasNext()) {
			entrenador = it.next();
			participantes.add(entrenador);
			entrenador.restaurarPokemones();
			entrenador.setCantidadHechizos(entrenador.getCategoria());
		}

		Torneo.getInstance().setParticipantesActuales(participantes);
		Torneo.getInstance().setEtapa(new Desarrollo());
	}

	/**
	 * Agrega un {@link Entrenador} al Torneo <b>Pre: </b>El entrenador es distinto
	 * de null
	 */
	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		Torneo.getInstance().getEntrenadores().add(entrenador);
	}

	@Override
	public void agregarBatalla(Batalla batalla) {
	}

	@Override
	public void ganadorBatalla(Entrenador entrenador) {
	}

	/**
	 * Retorna True si en el {@link Torneo} hay la cantidad necesaria de
	 * Entrenadores para comenzar, y si cada uno tiene mas de 1 Pokemon. False de lo
	 * contrario
	 */
	public boolean faseCompletada() {
		boolean respuesta = true;
		if (!Torneo.getInstance().cantidadEntrenadoresNecesaria()) {
			respuesta = false;
		} else {
			Iterator<Entrenador> it = Torneo.getInstance().getEntrenadores().iterator();
			while (it.hasNext() && respuesta == true) {
				Entrenador e = it.next();
				if (e.cantidadPokemones() < 1)
					respuesta = false;
			}
			respuesta = true;
		}
		return respuesta;
	}

}
