package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Torneo;
import vista.IVista;
import vista.VentanaTorneo;

public class Controlador implements ActionListener {
	
	private Torneo torneo;
	private IVista iVista;
	
	public Controlador() {
		iVista = new VentanaTorneo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
