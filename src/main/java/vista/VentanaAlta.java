package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.Pokemon;
import modelo.PokemonFactory;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * Ventana donde se realiza el alta de entrenadores y pokemons.
 * En la misma se los podrá agregar y se lanzarán mensajes de advertencia en caso que no se cumpla alguna de las condiciones
 * para la relización del torneo. Finalizado esto, se dara comienzo al torneo.
 */
@SuppressWarnings("serial")
public class VentanaAlta extends JFrame implements KeyListener, IVistaAlta, MouseListener, ListSelectionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_9;
	private JPanel panel_11;
	private JPanel panel_39;
	private JScrollPane scrollPane;
	private DefaultListModel<Entrenador> listaModelEntrenador = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listaModelPokemon = new DefaultListModel<Pokemon>();
	private ActionListener actionListener;
	private JList<Entrenador> listEntrenadores;
	private JList<Pokemon> listPokemon;
	private JPanel panel_3;
	private JScrollPane scrollPane_2;
	private JPanel panel_8;
	private JPanel panel_13;
	private JButton btnTorneo;
	private JTextField textFieldNombreEntrenador;
	private JPanel panel_12;
	private JPanel panel_14;
	private JTextField textFieldNombrePokemon;
	private JTextField textFieldTipo;
	private JTextField textFieldRecarga;
	private JTextField textFieldGranRecarga;
	private JButton btnAgregarPokemon;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_15;
	private JButton btnAgregarEntrenador;

	/**
	 * Create the frame.
	 */
	public VentanaAlta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 450);
		this.setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new TitledBorder(null, "Alta de Entrenadores y Pokemons", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.panel_9 = new JPanel();
		this.panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entrenador",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panel.add(this.panel_9, BorderLayout.NORTH);

		this.panel_12 = new JPanel();
		this.panel_12.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_9.add(this.panel_12);

		this.textFieldNombreEntrenador = new JTextField();
		this.textFieldNombreEntrenador.addKeyListener(this);
		this.panel_12.add(this.textFieldNombreEntrenador);
		this.textFieldNombreEntrenador.setColumns(10);

		this.panel_14 = new JPanel();
		this.panel_9.add(this.panel_14);

		btnAgregarEntrenador = new JButton("Agregar Entrenador");
		panel_14.add(btnAgregarEntrenador);

		this.panel_11 = new JPanel();
		this.panel.add(this.panel_11, BorderLayout.CENTER);
		this.panel_11.setLayout(new BorderLayout(0, 0));

		this.panel_39 = new JPanel();
		this.panel_11.add(this.panel_39);
		this.panel_39.setLayout(new GridLayout(0, 1, 0, 0));

		this.scrollPane = new JScrollPane();
		this.panel_39.add(this.scrollPane);

		this.listEntrenadores = new JList<Entrenador>();
		listEntrenadores.addListSelectionListener(this);
		this.listEntrenadores
				.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane.setViewportView(this.listEntrenadores);

		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(new BorderLayout(0, 0));

		this.panel_2 = new JPanel();
		this.panel_2.setBorder(null);
		this.panel_1.add(this.panel_2);
		this.panel_2.setLayout(new BorderLayout(0, 0));

		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_3, BorderLayout.NORTH);
		this.panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_4);

		this.textFieldNombrePokemon = new JTextField();
		this.textFieldNombrePokemon.addKeyListener(this);
		this.panel_4.add(this.textFieldNombrePokemon);
		this.textFieldNombrePokemon.setColumns(10);

		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_5);

		this.textFieldTipo = new JTextField();
		this.textFieldTipo.addKeyListener(this);
		this.panel_5.add(this.textFieldTipo);
		this.textFieldTipo.setColumns(10);

		this.panel_6 = new JPanel();
		this.panel_6.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_6);

		this.textFieldRecarga = new JTextField();
		this.textFieldRecarga.addKeyListener(this);
		this.panel_6.add(this.textFieldRecarga);
		this.textFieldRecarga.setColumns(10);

		this.panel_7 = new JPanel();
		this.panel_7
				.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_7);

		this.textFieldGranRecarga = new JTextField();
		this.textFieldGranRecarga.addKeyListener(this);
		this.panel_7.add(this.textFieldGranRecarga);
		this.textFieldGranRecarga.setColumns(10);

		this.panel_15 = new JPanel();
		this.panel_3.add(this.panel_15);

		this.btnAgregarPokemon = new JButton("Agregar Pokemon");
		this.panel_15.add(this.btnAgregarPokemon);

		this.scrollPane_2 = new JScrollPane();
		this.panel_2.add(this.scrollPane_2, BorderLayout.CENTER);

		listPokemon = new JList<Pokemon>();
		this.listPokemon
				.setBorder(new TitledBorder(null, "Pokemons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_2.setViewportView(this.listPokemon);

		this.panel_8 = new JPanel();
		this.panel_2.add(this.panel_8, BorderLayout.SOUTH);

		this.panel_13 = new JPanel();
		this.panel_8.add(this.panel_13);

		this.btnTorneo = new JButton("Comenzar Torneo");
		this.panel_13.add(this.btnTorneo);

		this.setVisible(true);
	}

	/**
	 *Devuelve string que hay en el campo nombre del entrenador
	 */
	@Override
	public String getNombreEntrenador() {
		return this.textFieldNombreEntrenador.getText();
	}

	/**
	 * @param r el string que hay en el campo recarga del Pokemon
	 * @return true si en el campo se escribio "si",false de lo contrario
	 */
	public boolean recarga(String r) {
		return r.equalsIgnoreCase("Si");
	}
	

	/**
	 * Notifica una advertencia de alguna condición no cumplida
	 * <b> Pre: </b> mensaje distinto de null
	 */
	public void mensajeAlerta(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	/**
	 * Método que agrega un entrenador a la JList de Entrenadores.
	 * Luego resetea los campos.
	 * 
	 * <b> Pre: </b> entrenador distinto de null
	 */
	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		this.listaModelEntrenador.addElement(entrenador);
		this.listEntrenadores.setModel(listaModelEntrenador);
		this.reseteaCampos();
	}

	/**
	 * Método que crea y retorna un entrenador en base al nombre ingresado en la ventana.
	 * En caso de no haber ingresado nombre, retorna null.
	 */
	public Entrenador getEntrenador() {
		if(this.getNombreEntrenador().isEmpty())
		{
			return null;
		}
		else {
			return new Entrenador(this.getNombreEntrenador());
		}
		
	}
	
	/**
	 * Método que devuelve un entrenador, el cual fue seleccionado en la JList de Entrenadores
	 */
	public Entrenador entrenadorSeleccionado() {
		return listEntrenadores.getSelectedValue();
	}
	
	/**
	 * Método que crea y devuelve un Pokemon a partir de los parámetros ingresados por el usuario en la ventana.
	 * @throws TipoNoEncontradoException, cuando el tipo ingresado no se corresponde a uno de los tipos de pokemon predeterminados
	 */
	public Pokemon getPokemon() throws TipoNoEncontradoException {
		Pokemon pokemon = null;
		if (this.getRecarga().equalsIgnoreCase("Si") || this.getRecarga().equalsIgnoreCase("No")) {
			if (!getTipoPokemon().equalsIgnoreCase("hielo")) 
				pokemon = PokemonFactory.getPokemon(getNombrePokemon(), getTipoPokemon(), recarga(getRecarga()));
			else
				if (this.getGranRecarga().equalsIgnoreCase("Si") || this.getGranRecarga().equalsIgnoreCase("No"))
					pokemon = PokemonFactory.getPokemon(getNombrePokemon(),getTipoPokemon(), recarga(getRecarga()), recarga(getGranRecarga()));
		}
		return pokemon;
	}

	/**
	 * Método que agrega un pokemon a la Jlist de Pokemon del Entrenador seleccionado en la JList de Entrenadores.
	 * Luego resetea los campos de texto.
	 */
	@Override
	public void agregarPokemon(Pokemon pokemon) {
		this.listEntrenadores.getSelectedValue().aniadirPokemon(pokemon);
		mostrarPokemon();
		reseteaCampos();
	}

	/**
	 * Método que, luego de ingresar un entrenador o un pokemon, resetea los campos para dejarlos vacíos.
	 */
	public void reseteaCampos() {
		this.textFieldNombreEntrenador.setText("");
		this.textFieldNombrePokemon.setText("");
		this.textFieldTipo.setText("");
		this.textFieldRecarga.setText("");
		this.textFieldGranRecarga.setText("");
	}

	/**
	 * Método que, a partir de un entrenador seleccionado en la JList de Entrenadores, muestra en la JList de Pokemones, sus pokemones correspondientes
	 */
	@Override
	public void mostrarPokemon() {
		if (this.listEntrenadores.getSelectedValue() != null) {
			listaModelPokemon.clear();
			for (int i = 0; i < this.listEntrenadores.getSelectedValue().getPokemones().size(); i++)
				listaModelPokemon.addElement(this.listEntrenadores.getSelectedValue().getPokemones().get(i));
			listPokemon.setModel(listaModelPokemon);
		}
	}

	/**
	 *Devuelve el String del campo de nombre del pokemon
	 */
	@Override
	public String getNombrePokemon() {
		return this.textFieldNombrePokemon.getText();
	}

	/**
	 * Método que setea al Controlador como listener de los botones de la ventana.
	 * 
	 * <b> Pre: </b> actionListener distinto de null
	 */
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAgregarEntrenador.addActionListener(actionListener);
		this.btnAgregarPokemon.addActionListener(actionListener);
		this.btnTorneo.addActionListener(actionListener);
		this.actionListener = actionListener;

	}

	/**
	 * Método que habilita o deshabilita el botón para agregar Pokemon dependiendo de los campos ingresados.
	 */
	public void keyReleased(KeyEvent arg0) {

		if (!this.getNombrePokemon().isEmpty() && !this.getTipoPokemon().isEmpty() && !this.getRecarga().isEmpty()
				&& (this.getGranRecarga().isEmpty()
						|| (!this.getGranRecarga().isEmpty() && this.getTipoPokemon().equalsIgnoreCase("Hielo")))) {
			this.btnAgregarPokemon.setEnabled(true);
		} else {
			this.btnAgregarPokemon.setEnabled(false);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public String getRecarga() {
		return this.textFieldRecarga.getText();
	}

	@Override
	public String getGranRecarga() {
		return this.textFieldGranRecarga.getText();
	}

	/**
	 * Método que, cuando se presiona un botón, envía un evento al Controlador para ejecutar los métodos correspondientes
	 */
	public void mousePressed(MouseEvent e) {
		ActionEvent evento;
		String command;
		JButton boton = (JButton) e.getSource();
		command = boton.getActionCommand();
		evento = new ActionEvent(boton, 0, command);
		this.actionListener.actionPerformed(evento);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Método que muestra en el JList de Entrenadores, los entrenadores ingresados hasta el momento.
	 * 
	 * <b> Pre: </b> entrenadores distinto de null
	 */
	@Override
	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		for (int i = 0; i < entrenadores.size(); i++)
			this.listaModelEntrenador.addElement(entrenadores.get(i));
		this.listEntrenadores.setModel(listaModelEntrenador);
	}

	/**
	 *Devuelve el String del campo tipo del pokemon
	 */
	@Override
	public String getTipoPokemon() {
		return textFieldTipo.getText();
	}

	/**
	 * Método que al cambiar una seleccion de la JList de Entrenadores, automaticamente muestra los Pokemones del entrenador seleccionado.
	 *Cuando seleccionamos un entrenador muestra sus Pokemon
	 */
	public void valueChanged(ListSelectionEvent e) {
		mostrarPokemon();
	}

	/**
	 * Método que cierra la ventana
	 */
	@Override
	public void cerrarVentana() {
		this.dispose();
	}
}
