package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import modelo.Entrenador;
import modelo.Pokemon;
import modelo.Torneo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class VentanaTorneo extends JFrame implements IVistaTorneo, MouseListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList<Entrenador> listEntrenadores1;
	private JList<Pokemon> listPokemon1;
	private JList<Entrenador> listEntrenadores2;
	private JList<Pokemon> listPokemon2;
	private DefaultListModel<Entrenador> listModelEntrenadores1 = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listModelPokemon1 = new DefaultListModel<Pokemon>();
	private DefaultListModel<Entrenador> listModelEntrenadores2 = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listModelPokemon2 = new DefaultListModel<Pokemon>();
	private JPanel panel;
	private JScrollPane scrollPane_2;
	private JPanel panel_1;
	private JTextArea textAreaBatallas;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnElegirPokemon;
	private JButton btnComenzarBatalla;
	private ActionListener actionListener;
	private JPanel panel_4;
	private JButton btnMostrarPokemon;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;

	/**
	 * Create the frame.
	 */
	public VentanaTorneo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 413);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 5, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane);
		
		this.listEntrenadores1 = new JList<Entrenador>();
		this.listEntrenadores1.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane.setViewportView(this.listEntrenadores1);
		
		this.scrollPane_1 = new JScrollPane();
		this.contentPane.add(this.scrollPane_1);
		
		this.listPokemon1 = new JList<Pokemon>();
		this.listPokemon1.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_1.setViewportView(this.listPokemon1);
		
		this.scrollPane_3 = new JScrollPane();
		this.contentPane.add(this.scrollPane_3);
		
		this.listEntrenadores2 = new JList<Entrenador>();
		this.listEntrenadores2.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_3.setViewportView(this.listEntrenadores2);
		
		this.scrollPane_4 = new JScrollPane();
		this.contentPane.add(this.scrollPane_4);
		
		this.listPokemon2 = new JList<Pokemon>();
		this.listPokemon2.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_4.setViewportView(this.listPokemon2);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		this.panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel.add(this.scrollPane_2);
		
		this.textAreaBatallas = new JTextArea();
		this.textAreaBatallas.setBorder(new TitledBorder(null, "Batallas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_2.setViewportView(this.textAreaBatallas);
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);
		
		this.panel_5 = new JPanel();
		this.panel_2.add(this.panel_5);
		
		this.btnMostrarPokemon = new JButton("Mostrar Pokemon");
		this.panel_5.add(this.btnMostrarPokemon);
		this.btnMostrarPokemon.addMouseListener(this);
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		
		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);
		
		this.btnElegirPokemon = new JButton("Elegir Pokemon");
		this.panel_6.add(this.btnElegirPokemon);
		this.btnElegirPokemon.addMouseListener(this);
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		
		this.panel_7 = new JPanel();
		this.panel_4.add(this.panel_7);
		
		this.btnComenzarBatalla = new JButton("Comenzar Batallas");
		this.panel_7.add(this.btnComenzarBatalla);
		this.btnComenzarBatalla.addMouseListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void mostrarEntrenadores() {
		for (int i=0; i<Torneo.getInstance().getEntrenadores().size(); i++) {
			this.listModelEntrenadores1.addElement(Torneo.getInstance().getEntrenadores().get(i));
		}
		this.listEntrenadores1.setModel(listModelEntrenadores1);
		this.listEntrenadores2.setModel(listModelEntrenadores1);
	}

	@Override
	public void mostrarPokemon() {
		if (this.listEntrenadores1.getSelectedValue() != null && this.listEntrenadores2.getSelectedValue() != null) {
			this.listModelPokemon1.clear();
			this.listPokemon1.setModel(listModelPokemon1);
			this.listPokemon2.setModel(listModelPokemon1);
			Entrenador e1 = this.listEntrenadores1.getSelectedValue();
			Entrenador e2 = this.listEntrenadores2.getSelectedValue();
			for (int i=0; i<e1.getPokemones().size(); i++)
				this.listModelPokemon1.addElement(e1.getPokemones().get(i));
			this.listPokemon1.setModel(listModelPokemon1);
			for (int i=0; i<e2.getPokemones().size(); i++)
				this.listModelPokemon2.addElement(e2.getPokemones().get(i));
			this.listPokemon2.setModel(listModelPokemon2);
		}
	}

	@Override
	public void mostrarBatallas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elegirPokemon() {
		/*//ELIJO POKEMON DE CADA ENTRENADOR, LO AGREGO AL TEXTFIELD Y BORRO LOS ENTRENADORES DE LAS LISTAS
		if (this.listPokemon1.getSelectedValue() != null && this.listPokemon2.getSelectedValue() != null) {
			//Aca guardaria en alguna parte del torneo los entrenadores y los pokemon
			this.listEntrenadores1.clearSelection();
			this.listEntrenadores2.clearSelection();
			if (this.listEntrenadores1.)
		}*/
	}

	@Override
	public void comenzarBatallas() {
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnComenzarBatalla.addActionListener(actionListener);
		this.btnElegirPokemon.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
		ActionEvent evento;
		String command;
		JButton boton = (JButton) arg0.getSource();
		command = boton.getActionCommand();
		evento = new ActionEvent(boton,0,command);
		this.actionListener.actionPerformed(evento);
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
}
