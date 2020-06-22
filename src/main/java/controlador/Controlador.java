package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import modelo.Torneo;
import vista.IVistaTorneo;
import vista.IVistaAlta;
import vista.VentanaAlta;
import vista.VentanaTorneo;

public class Controlador implements ActionListener, Observer {
	
	private IVistaTorneo vistaTorneo;
	private IVistaAlta vistaAlta;
	
	public Controlador() {
		vistaAlta = new VentanaAlta();
		vistaAlta.setActionListener(this);
	}

	public IVistaAlta getVistaAlta() {
		return vistaAlta;
	}

	public void setVistaAlta(IVistaAlta vistaAlta) {
		this.vistaAlta = vistaAlta;
		this.vistaAlta.setActionListener(this);
	}
	
	public IVistaTorneo getVistaTorneo() {
		return vistaTorneo;
	}

	public void setVistaTorneo(IVistaTorneo vistaTorneo) {
		this.vistaTorneo = vistaTorneo;
		this.vistaTorneo.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if (comando == "Agregar") {//AGREGA ENTRENADOR CON SUS POKEMON A ARRAY DE ENTRENADORES
			this.vistaAlta.agregarEntrenador();
		}
		else
			if (comando == "Ver Pokemon") //MUESTRA EN LIST LOS POKEMON DEL ENTRENADOR SELECCIONADO
				this.vistaAlta.mostrarPokemon();
			else
				if (comando == "Comenzar Torneo") { //COMIENZA EL TORNEO
					vistaAlta.comenzarTorneo();
					Torneo.getInstance().addObserver(this);
					vistaTorneo = new VentanaTorneo();
					vistaTorneo.setActionListener(this);
					vistaTorneo.mostrarEntrenadores();
				}
				else
					if (comando == "Mostrar Pokemon")
						this.vistaTorneo.mostrarPokemon();
					/*else
						if (comando == "Elegir Pokemon")
							//COMPLETAR
						else
							if (comando == "Comenzar Batallas")
								//COMPLETAR*/
						
		//COMPLETAR
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 != this.torneo)
			throw new InvalidParameterException();
		//if (arg1.toString().contentEquals("Cuartos de final"))
			//this.
	}*/
	

}
