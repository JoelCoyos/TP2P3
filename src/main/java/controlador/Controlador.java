package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backup.CuartosFinal;
import backup.Torneo;
import modelo.Entrenador;
import vista.IVista;
import vista.VentanaTorneo;

public class Controlador implements ActionListener {
	
	private Torneo torneo;
	private IVista iVista;
	
	public Controlador() {
		iVista = new VentanaTorneo();
		iVista.setActionListener(this);
		iVista.generarEntrenadores();
		torneo = new Torneo();
		torneo.setEntrenadores(iVista.getEntrenadores());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando =e.getActionCommand();
		
		if(comando=="EMPEZAR")
		{
			torneo.setEtapa(new CuartosFinal(torneo));
			torneo.realizarRonda(torneo.getEntrenadores());
		}
		
	}
	

}
