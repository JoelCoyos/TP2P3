package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import excepciones.TipoNoEncontradoException;
import modelo.Arena;
import modelo.Batalla;
import modelo.Entrenador;
import modelo.IEtapas;
import modelo.Pokemon;
import modelo.Premiacion;
import modelo.Torneo;
import serializacion.DeserializeFromXML;
import vista.IVistaTorneo;
import vista.IVistaAlta;
import vista.IVistaPremiacion;
import vista.VentanaAlta;
import vista.VentanaPremiacion;
import vista.VentanaTorneo;

public class Controlador implements ActionListener, Observer {
	
	private IVistaTorneo vistaTorneo;
	private IVistaAlta vistaAlta;
	private IVistaPremiacion vistaPremiacion;
	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	
	public Controlador() {
		
		try {
			DeserializeFromXML.leer();
		} catch (FileNotFoundException e) {
		} //Se recupera el torneo
		Torneo.getInstance().addObserver(this);
		Iterator<Arena> it = Torneo.getInstance().getArenas().iterator();
		while (it.hasNext()) {
			arenas.add(it.next());
		}
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
		
		if (comando == "Agregar Entrenador") {
			if (!Torneo.getInstance().cantidadEntrenadoresNecesaria()) {
				Entrenador entrenador = vistaAlta.getEntrenador();
				this.vistaAlta.agregarEntrenador(entrenador);
				Torneo.getInstance().agregarEntrenador(entrenador);
			}
			else
				vistaAlta.mensajeAlerta("No puede agregar mas entrenadores");
		}
		else
			if (comando == "Agregar Pokemon") {
				Entrenador entrenadorSeleccionado = vistaAlta.entrenadorSeleccionado();
				if (entrenadorSeleccionado != null) {
					try {
						Pokemon pokemon = vistaAlta.getPokemon();
						vistaAlta.agregarPokemon(pokemon);
					} catch (TipoNoEncontradoException e1) {
						vistaAlta.mensajeAlerta("El tipo no existe");
					}
				}
				else
					vistaAlta.mensajeAlerta("Seleccione un entrenador");
			}
			else
				if (comando == "Comenzar Torneo") { //COMIENZA EL TORNEO
					Torneo.getInstance().avanzarFase();
				}
				else
					if (comando == "Mostrar Pokemon")
						this.vistaTorneo.mostrarPokemonHechizos();
					else
						if (comando == "Agregar Batalla") {
							Batalla batalla = vistaTorneo.getBatalla();
							if (batalla == null)
								this.vistaTorneo.mensajeAlerta("Ingresar campos correctamente");
							else {
								Torneo.getInstance().agregarBatalla(batalla);
								this.vistaTorneo.agregarBatalla();
							}
						}
						else
							if (comando == "Comenzar Batallas") {
								Torneo.getInstance().comenzarBatallas();
							}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		IEtapas etapa = (IEtapas) arg1;
		if (arg0 != Torneo.getInstance())
			if (arg1 == null) 
				vistaTorneo.mensajeAlerta("No se cumplen las condiciones necesarias para comenzar");
			else 
				if (etapa.getNombre() == "Alta")
					vistaAlta = new VentanaAlta();
				else
					if (etapa.getNombre() == "Desarrollo")
						vistaTorneo = new VentanaTorneo();
					else
						vistaPremiacion = new VentanaPremiacion();
		/*else
			if (arenas.contains(arg0)) {
				
			}
			else
				throw new InvalidParameterException();
			}*/
			
	
	}
}
