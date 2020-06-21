package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class CuartosFinal2 implements IEtapas2 {

	public CuartosFinal2() {
	}

	@Override
	public void realizarRonda() {

		ArrayList<Entrenador> ganadores = Torneo2.getInstance().getEntrenadores();
		
		Torneo2.getInstance().getArenas().add(new Arena());
		Torneo2.getInstance().getArenas().add(new Arena());
		
		System.out.println("COMIENZAN LOS CUARTOS DE FINAL");
		
		System.out.println(ganadores.get(0).getNombre());
		
		for (int i = 0; i < 8; i += 2) {
			Arena arena = Torneo2.getInstance().getArenas().poll();
			Batalla2 batalla = new Batalla2(arena, ganadores.get(i), ganadores.get(i+1));
			Torneo2.getInstance().getArenas().add(arena);
			batalla.start();
		}
		
	}

}
