package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import excepciones.EntrenadorRepetidoException;
import excepciones.MaximaCapacidadEntrenadoresException;
import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.Pokemon;
import modelo.PokemonFactory;
import modelo.Torneo;

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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaAlta extends JFrame implements KeyListener, IVistaAlta, MouseListener, ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_7;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JTextField textFieldNombre;
	private JPanel panel_12;
	private JButton btnNewButtonTorneo;
	private JPanel panel_13;
	private JButton btnAgregarPokemon;
	private JPanel panel_14;
	private JPanel panel_15;
	private JTextField textFieldNombre1;
	private JTextField textFieldTipo1;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_38;
	private JPanel panel_39;
	private JScrollPane scrollPane;
	private DefaultListModel<Entrenador> listaModelEntrenador = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listaModelPokemon = new DefaultListModel<Pokemon>();
	private ActionListener actionListener;
	private JPanel panel_40;
	private JTextField textFieldRecarga1;
	private JPanel panel_41;
	private JButton btnNewButtonVer;
	private JPanel panel_52;
	private JList<Entrenador> listEntrenadores;
	private JScrollPane scrollPane_1;
	private JPanel panel_53;
	private JTextField textFieldGranRecarga1;
	private JPanel panel_59;
	private JButton btnAgregarEntrenador;
	private JList<Pokemon> listPokemon;

	/**
	 * Create the frame.
	 */
	public VentanaAlta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new TitledBorder(null, "Alta de Entrenadores y Pokemons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.panel_9 = new JPanel();
		this.panel_9.setBorder(new TitledBorder(null, "Nombre del Entrenador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.add(this.panel_9, BorderLayout.NORTH);
		
		this.panel_12 = new JPanel();
		this.panel_9.add(this.panel_12);
		
		this.textFieldNombre = new JTextField();
		this.textFieldNombre.addKeyListener(this);
		this.panel_12.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		btnAgregarEntrenador = new JButton("Agregar");
		btnAgregarEntrenador.setActionCommand("AgregarEntrenador");
		btnAgregarEntrenador.addActionListener(this);
		panel_9.add(btnAgregarEntrenador);
		
		this.panel_10 = new JPanel();
		this.panel.add(this.panel_10, BorderLayout.SOUTH);
		
		this.panel_52 = new JPanel();
		this.panel_10.add(this.panel_52);
		
		this.btnNewButtonVer = new JButton("Ver Pokemon");
		this.btnNewButtonVer.addMouseListener(this);
		this.panel_52.add(this.btnNewButtonVer);
		
		this.panel_13 = new JPanel();
		this.panel_10.add(this.panel_13);
		
		this.btnNewButtonTorneo = new JButton("Comenzar Torneo");
		this.btnNewButtonTorneo.addMouseListener(this);
		this.panel_13.add(this.btnNewButtonTorneo);
		
		this.panel_11 = new JPanel();
		this.panel.add(this.panel_11, BorderLayout.CENTER);
		this.panel_11.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_39 = new JPanel();
		this.panel_11.add(this.panel_39);
		this.panel_39.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_39.add(this.scrollPane);
		
		this.listEntrenadores = new JList<Entrenador>();
		listEntrenadores.addListSelectionListener(this);
		this.listEntrenadores.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane.setViewportView(this.listEntrenadores);
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_11.add(this.scrollPane_1);
		
		listPokemon = new JList();
		scrollPane_1.setViewportView(listPokemon);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(7, 0, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new TitledBorder(null, "Pokemon 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_14 = new JPanel();
		this.panel_14.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_14);
		
		this.panel_26 = new JPanel();
		this.panel_14.add(this.panel_26);
		
		this.textFieldNombre1 = new JTextField();
		this.textFieldNombre1.addKeyListener(this);
		this.panel_26.add(this.textFieldNombre1);
		this.textFieldNombre1.setColumns(10);
		
		this.panel_15 = new JPanel();
		this.panel_15.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_15);
		
		this.panel_27 = new JPanel();
		this.panel_15.add(this.panel_27);
		
		this.textFieldTipo1 = new JTextField();
		this.textFieldTipo1.addKeyListener(this);
		this.panel_27.add(this.textFieldTipo1);
		this.textFieldTipo1.setColumns(10);
		
		this.panel_40 = new JPanel();
		this.panel_40.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_40);
		
		this.panel_41 = new JPanel();
		this.panel_40.add(this.panel_41);
		
		this.textFieldRecarga1 = new JTextField();
		this.textFieldRecarga1.addKeyListener(this);
		this.panel_41.add(this.textFieldRecarga1);
		this.textFieldRecarga1.setColumns(10);
		
		this.panel_53 = new JPanel();
		this.panel_53.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_53);
		
		this.panel_59 = new JPanel();
		this.panel_53.add(this.panel_59);
		
		this.textFieldGranRecarga1 = new JTextField();
		this.textFieldGranRecarga1.addKeyListener(this);
		this.panel_59.add(this.textFieldGranRecarga1);
		this.textFieldGranRecarga1.setColumns(10);
		
		this.panel_7 = new JPanel();
		this.panel_1.add(this.panel_7);
		
		this.panel_38 = new JPanel();
		this.panel_7.add(this.panel_38);
		
		this.btnAgregarPokemon = new JButton("Agregar");
		btnAgregarPokemon.addActionListener(this);
		btnAgregarPokemon.setActionCommand("AgregarPokemon");
		this.btnAgregarPokemon.setEnabled(false);
		this.panel_38.add(this.btnAgregarPokemon);
		
		this.setVisible(true);
	}

	@Override
	public String getNombreEntrenador() {
		return this.textFieldNombre.getText();
	}

	@Override
	public void comenzarTorneo() {
		this.dispose(); //CIERRA VENTANA ACTUAL
	}
	
	public boolean recarga(String r) {
		return r.equalsIgnoreCase("Si");
	}
	
	@Override
	public void agregarEntrenador() {
		if(this.listaModelEntrenador.getSize()<8)
		{
			this.listaModelEntrenador.addElement(new Entrenador(this.getNombreEntrenador()));
		}
		else 
		{
			JOptionPane.showMessageDialog(this,"No puede agregar mas entrenadores");
		}
	}
	
	@Override
	public void agregarPokemon() {
		
		if(listEntrenadores.getSelectedValue()!=null)
		{
			if(!getTipoPokemon().equalsIgnoreCase("hielo"))
			{
				try {
					listEntrenadores.getSelectedValue().aniadirPokemon(PokemonFactory.getPokemon(getNombrePokemon(), getTipoPokemon(), recarga(getRecarga())));
				} catch (TipoNoEncontradoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
				}
			}
			else {
				try {
					listEntrenadores.getSelectedValue().aniadirPokemon(PokemonFactory.getPokemon(getNombrePokemon(), getTipoPokemon(), recarga(getRecarga()),recarga(getGranRecarga())));
				} catch (TipoNoEncontradoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
				}
				
			}
			mostrarPokemon();
			reseteaCampos();
		}
		else {
			JOptionPane.showMessageDialog(this,"Seleccione un entrenador");
		}
		
		
		
		
		
	}
	
	public void reseteaCampos() {
		this.textFieldNombre.setText("");
		this.textFieldNombre1.setText("");
		this.textFieldTipo1.setText("");
		this.textFieldRecarga1.setText("");
		this.textFieldGranRecarga1.setText("");
	}
	
	@Override
	public void mostrarPokemon() {
		if(this.listEntrenadores.getSelectedValue()!=null)
		{
			listaModelPokemon.clear();
			listaModelPokemon.addAll(listEntrenadores.getSelectedValue().getPokemones());
			listPokemon.setModel(listaModelPokemon);
		}
	}

	@Override
	public String getNombrePokemon() {
		return this.textFieldNombre1.getText();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAgregarPokemon.addActionListener(actionListener);
		this.btnNewButtonTorneo.addActionListener(actionListener);
		this.btnNewButtonVer.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		
		if (!this.getNombrePokemon().isEmpty() && !this.getTipoPokemon().isEmpty() && !this.getRecarga().isEmpty() && (this.getGranRecarga().isEmpty() || (!this.getGranRecarga().isEmpty() && this.getTipoPokemon().equalsIgnoreCase("Hielo"))))
		{
			this.btnAgregarPokemon.setEnabled(true);
		}
		else {
			this.btnAgregarPokemon.setEnabled(false);
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRecarga() {
		return this.textFieldRecarga1.getText();
	}
	@Override
	public String getGranRecarga() {
		return this.textFieldGranRecarga1.getText();
	}

	public void mousePressed(MouseEvent e) {
		ActionEvent evento;
		String command;
		JButton boton = (JButton) e.getSource();
		command = boton.getActionCommand();
		evento = new ActionEvent(boton,0,command);
		this.actionListener.actionPerformed(evento);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void setEntrenadores() {
		this.listaModelEntrenador.addAll(Torneo.getInstance().getEntrenadores());
		this.listEntrenadores.setModel(listaModelEntrenador);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("AgregarEntrenador"))
		{
			agregarEntrenador();
		}
		else if(e.getActionCommand().equals("AgregarPokemon"))
		{
			agregarPokemon();
		}
	}

	@Override
	public String getTipoPokemon() {
		return textFieldTipo1.getText();
	}

	
	public void valueChanged(ListSelectionEvent e) {
		
		mostrarPokemon();
	}

	@Override
	public ArrayList<Entrenador> getEntrenadores() {
		return Collections.list(listaModelEntrenador.elements()); //Pasa list model a ArrayList
	}

	@Override
	public boolean sePuedeEmpezar() {
		if(listaModelEntrenador.getSize()<8)
		{
			return false;
		}
		else {
			for (int i = 0; i < listaModelEntrenador.getSize(); i++) {
				if(listaModelEntrenador.get(i).getPokemones().size()<3)
					return false;
			}
			return true;
		}
	}

	@Override
	public void noPuedeEmpezar() {
		JOptionPane.showMessageDialog(this,"No se cumplen las condiciones necesarias como para comenzar");
	}
	
}
