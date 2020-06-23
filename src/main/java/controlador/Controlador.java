package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import modelo.Final;
import modelo.IEtapas;
import modelo.Premiacion;
import modelo.Semifinal;
import modelo.Torneo;
import serializacion.DeserializeFromXML;
import vista.IVistaTorneo;
import vista.IVistaAlta;
import vista.VentanaAlta;
import vista.VentanaTorneo;

public class Controlador implements ActionListener, Observer {
	
	private IVistaTorneo vistaTorneo;
	private IVistaAlta vistaAlta;
	
	public Controlador() {
		
		try {
			DeserializeFromXML.leer();
		} catch (FileNotFoundException e) {
		} //Se recupera el torneo
		if(Torneo.getInstance().getEtapa().getNombre()=="Alta")
		{
			vistaAlta = new VentanaAlta();
			vistaAlta.setActionListener(this);
			vistaAlta.setEntrenadores();
		}
		else {
			comenzarBatalla();
		}
	}
	
	public void comenzarBatalla()
	{
		Torneo.getInstance().addObserver(this);
		vistaTorneo = new VentanaTorneo();
		vistaTorneo.setActionListener(this);
		vistaTorneo.mostrarEntrenadores();
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
		
		if (comando == "Agregar")//AGREGA ENTRENADOR CON SUS POKEMON A ARRAY DE ENTRENADORES
			this.vistaAlta.agregarEntrenador();
		else
			if (comando == "Ver Pokemon") //MUESTRA EN LIST LOS POKEMON DEL ENTRENADOR SELECCIONADO
				this.vistaAlta.mostrarPokemon();
			else
				if (comando == "Comenzar Torneo") { //COMIENZA EL TORNEO
					if(vistaAlta.sePuedeEmpezar())
					{
						Torneo.getInstance().setEntrenadores(vistaAlta.getEntrenadores()); //Setea los entrenadores que creamos en la ventana
						vistaAlta.comenzarTorneo();
						comenzarBatalla();
					}
					else {
						vistaAlta.noPuedeEmpezar();
					}
					
				}
				else
					if (comando == "Mostrar Pokemon")
						this.vistaTorneo.mostrarPokemonHechizos();
					else
						if (comando == "Agregar Batalla")
							this.vistaTorneo.elegirPokemonHechizo();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		IEtapas etapa = (IEtapas) arg1;
		if (arg0 != Torneo.getInstance())
			throw new InvalidParameterException();
		else
			if (etapa.getNombre() == "Cuartos de Final")
				Torneo.getInstance().setEtapa(new Semifinal());
			else
				if (etapa.getNombre() == "Semifinal")
					Torneo.getInstance().setEtapa(new Final());
				else
					if (etapa.getNombre() == "Final")
						Torneo.getInstance().setEtapa(new Premiacion());
		
	}
	

}
