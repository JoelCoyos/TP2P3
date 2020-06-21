package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import modelo.CuartosFinal;
import modelo.Entrenador;
import modelo.Torneo;
import vista.IVista;
import vista.IVistaAlta;
import vista.VentanaAlta;
import vista.VentanaTorneo;

public class Controlador implements ActionListener, Observer {
	
	private Torneo torneo;
	private IVista iVista;
	private IVistaAlta vistaAlta;
	
	public Controlador() {
		vistaAlta = new VentanaAlta();
		vistaAlta.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if (comando == "Agregar") //AGREGA ENTRENADOR CON SUS POKEMON A ARRAY DE ENTRENADORES
			this.vistaAlta.agregarEntrenador();
		else
			if (comando == "Comenzar Torneo") {//SE PASA A LA VENTANA DEL TORNEO
				this.torneo.addObserver(this);
				this.vistaAlta.comenzarTorneo();
			}
			else
				if (comando == "Empezar") { //COMIENZAN LAS BATALLAS (SOLO PARA CUARTOS DE FINAL, FALTAN DEMAS ETAPAS)
					torneo.setEtapa(new CuartosFinal());
					torneo.realizarRonda();
				}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 != this.torneo)
			throw new InvalidParameterException();
		//if (arg1.toString().contentEquals("Cuartos de final"))
			//this.
	}
	

}
