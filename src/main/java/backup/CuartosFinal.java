package backup;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Entrenador;

public class CuartosFinal implements IEtapas {
	
	private Torneo torneo;
	private Entrenador[] ganadores = new Entrenador[4];
	
	public CuartosFinal(Torneo torneo) {
		this.torneo = torneo;
	}

	@Override
	public void realizarRonda(Entrenador[] entrenadores) {
		
		int i;
		
		for(i =0;i<8;i+=2)
		{
			Batalla batalla = new Batalla(entrenadores[i], entrenadores[i+1], torneo);
			batalla.setEstado(new Preliminar());
			batalla.start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
