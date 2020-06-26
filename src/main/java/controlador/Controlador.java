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
import modelo.Alta;
import modelo.Arena;
import modelo.Batalla;
import modelo.Desarrollo;
import modelo.Entrenador;
import modelo.IEtapas;
import modelo.Pokemon;
import modelo.Torneo;
import serializacion.DeserializeFromXML;
import serializacion.SerializeToXML;
import vista.IVistaTorneo;
import vista.IVistaAlta;
import vista.IVistaArena;
import vista.VentanaAlta;
import vista.VentanaArena;
import vista.VentanaTorneo;

/**
 * Clase Controlador, perteneciente al patrón MVC. Vínculo entre las vistas y el modelo. Observa a las arenas y el torneo.
 *
 */
public class Controlador implements ActionListener, Observer {

	private IVistaTorneo vistaTorneo;
	private IVistaAlta vistaAlta;
	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	private IVistaArena vistaArena;

	/**
	 * Constructor de la clase. Si existe un archivo XML para recuperar, lo hace. 
	 * En base al estado actual se setea la ventana correspondiente
	 */
	public Controlador() {

		try {
			DeserializeFromXML.leer();
		} catch (FileNotFoundException e) {
		} // Se recupera el torneo
		Torneo.getInstance().addObserver(this);
		if (Torneo.getInstance().getEtapa().getNombre() == "Alta") {
			vistaAlta = new VentanaAlta();
			vistaAlta.setActionListener(this);
			vistaAlta.setEntrenadores(Torneo.getInstance().getEntrenadores());
		} else {
			Iterator<Arena> it = Torneo.getInstance().getArenas().iterator();
			while (it.hasNext()) {
				Arena arena = it.next();
				arena.addObserver(this);
				arenas.add(arena);
			}
			comenzarTorneo();
		}
	}

	/**
	 * Dicho método comienza el torneo. Abre las ventanas correspondientes.
	 */
	public void comenzarTorneo() {
		if (vistaAlta != null)
			vistaAlta.cerrarVentana();
		vistaTorneo = new VentanaTorneo();
		vistaTorneo.setActionListener(this);
		vistaTorneo.mostrarEntrenadores(Torneo.getInstance().getParticipantesActuales());
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

	/**
	 * Action listener de aquellos boton que necesiten alguna informacion del Torneo, o que quieran modificarlos
	 * 
	 * Agregar Entrenador: Revisa si no se esta excediendo de entrenadores, si no lo esta, 
	 * agrega el entrenador seleccionado en la ventana lista de la ventana 
	 * y al Torneo, en caso contrario muestra mensaje de alerta 
	 * <n>
	 * Agregar Pokemon: Revisa si el pokemon seleccionado en la ventana tiene un tipo valido,
	 * y si se selecciono una recarga valida. De ser asi lo agrega al Entrenador seleccionado
	 * <n>
	 * Comenzar Torneo: Revisa si todos los entrenadores tiene como minimo un entrenador, y
	 * avanza de fase
	 * <n>
	 * Mostrar Pokemon: Despues de seleccionar un entrenador en la {@link VentanaTorneo}, se muestran
	 * sus Pokemones y hechizos
	 * <n>
	 * Agregar Batalla: Toma los entrenadores, pokemones y hechizos de la {@link VentanaTorneo}, crea una
	 * batalla y la agrega al Torneo y a lista de Batallas en la Ventana
	 * <n>
	 * Comenzar Batallas: Crea una nueva {@link VentanaArena} y desabilita el input de la {@link VentanaTorneo}
	 * <n>
	 * Avanzar Fase: Le pide al Torneo avanzar de fase
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando == "Agregar Entrenador") {
			if (!Torneo.getInstance().cantidadEntrenadoresNecesaria()) {
				Entrenador entrenador = vistaAlta.getEntrenador();
				if(entrenador !=null)
				{
					this.vistaAlta.agregarEntrenador(entrenador);
					Torneo.getInstance().agregarEntrenador(entrenador);
				}
				else {
					vistaAlta.mensajeAlerta("Ingrese un nombre valido");
				}
				
			} else {
				vistaAlta.reseteaCampos();
				vistaAlta.mensajeAlerta("No puede agregar mas entrenadores");
			}
		} else if (comando == "Agregar Pokemon") {
			Entrenador entrenadorSeleccionado = vistaAlta.entrenadorSeleccionado();
			if (entrenadorSeleccionado != null) {
				try {
					Pokemon pokemon = vistaAlta.getPokemon();
					if (pokemon == null) {
						vistaAlta.reseteaCampos();
						vistaAlta.mensajeAlerta("Debe introducir si o no para las recargas");
					} else
						vistaAlta.agregarPokemon(pokemon);
				} catch (TipoNoEncontradoException e1) {
					vistaAlta.reseteaCampos();
					vistaAlta.mensajeAlerta("El tipo no existe");
				}
			} else {
				vistaAlta.reseteaCampos();
				vistaAlta.mensajeAlerta("Seleccione un entrenador");
			}
		} else if (comando == "Comenzar Torneo") {
			if (Torneo.getInstance().tieneMinimoUnPokemon())
			{
				vistaAlta.cerrarVentana();
				Torneo.getInstance().avanzarFase();
			}
				
			else
				vistaAlta.mensajeAlerta("Todos los entrenadores tienen que tener minimo un pokemon");
		} else if (comando == "Mostrar Pokemon")
			this.vistaTorneo.mostrarPokemonHechizos();
		else if (comando == "Agregar Batalla") {
			Batalla batalla = vistaTorneo.getBatalla();
			if (batalla == null)
				this.vistaTorneo.mensajeAlerta("Ingresar campos correctamente");
			else {
				Torneo.getInstance().agregarBatalla(batalla);
				this.vistaTorneo.agregarBatalla();
			}
		} else if (comando == "Comenzar Batallas") {
			this.vistaArena = new VentanaArena();
			this.vistaTorneo.comenzarBatallas();
			Torneo.getInstance().comenzarBatallas();
		} else {
			if (comando == "Avanzar de Fase") {
				Torneo.getInstance().avanzarFase();
			}
		}

	}

	/**
	 * Método que recibe notificaciones desde el modelo para efectuar los cambios en las ventanas, como por ejemplo los cambios de fase.
	 *Recibira las notificaciones de los observados
	 *<n>
	 *Si el Observable es el Torneo, nos enviara como objecto una {@link IEtapas}, que sera la siguiente etapa<n>
	 *Si la etapa es null es porque todavia no se cumplen las condiciones necesarias para avanzar de fase<n>
	 *Si la etapa es {@link Alta}, es porque acaba de terminar la final. Se mostrara el ganador del torneo, se cerrara la {@link VentanaTorneo}
	 *y se abrira una nueva {@link VentanaAlta}<n>
	 *Si la etapa es {@link Desarrollo}, se cerraran, si existen las {@link VentanaTorneo} y {@link VentanaArena} existentes. Si nuestra variable<n>
	 *arenas esta vacia, tomamos las arenas del Torneo, las agregamos al arrayList y las observamos. Luego comenzaran las batallas<n>
	 *<n>
	 *Si el Obsevable es una Arena, revisamos si esta dentro de las arenas del controlador, si lo esta guardamos el numero de la arena, y mostramos
	 *el String que nos paso como objeto en la {@link VentanaArena}
	 *<n>
	 *Si no es ninguno de estos Observable, arroja una Excepcion
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == Torneo.getInstance()) {
			IEtapas etapa = (IEtapas) arg1;
			if (arg1 == null)
			{
				if(vistaTorneo!=null)
					vistaTorneo.mensajeAlerta("No se cumplen las condiciones necesarias para comenzar");
				else if(vistaAlta!=null)
					vistaAlta.mensajeAlerta("No se cumplen las condiciones necesarias para comenzar");
			}
				
			else {
				try {
					SerializeToXML.escribirXML();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (etapa.getNombre() == "Alta") {
					if (vistaTorneo != null) {
						vistaTorneo.premiacion(Torneo.getInstance().getParticipantesActuales().get(0));
						vistaArena.cerrarVentana();
					}
					vistaAlta = new VentanaAlta();
					vistaAlta.setActionListener(this);
					vistaAlta.setEntrenadores(Torneo.getInstance().getEntrenadores());
				} else {
					if (this.vistaArena != null)
						this.vistaArena.cerrarVentana();
					if (etapa.getNombre() == "Desarrollo") {
						if (vistaTorneo != null)
							vistaTorneo.cerrarVentana();
						if (arenas.isEmpty()) {
							Iterator<Arena> it = Torneo.getInstance().getArenas().iterator();
							while (it.hasNext()) {
								Arena arena = it.next();
								arenas.add(arena);
								arena.addObserver(this);
							}
						}
						this.comenzarTorneo();
					}
				}
			}
		} else if (arenas.contains(arg0)) {
			Object vector[] = (Object[]) arg1;
			int numeroArena = arenas.indexOf(arg0);
			if (vector[0] == null) {
				vistaArena.muestraMensaje((String) vector[1], numeroArena);
			} else {
				vistaArena.muestraMensaje("----------------------------------------------------------------------------------------------------INICIA LA BATALLA----------------------------------------------------------------------------------------------------", numeroArena);
				vistaTorneo.progresoBatallas((Batalla) vector[0]);
			}
		} else
			throw new InvalidParameterException();
	}
}
