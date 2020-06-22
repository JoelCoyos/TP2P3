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
import modelo.Hechizo;
import modelo.Niebla;
import modelo.Pokemon;
import modelo.Tormenta;
import modelo.Torneo;
import modelo.Viento;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class VentanaTorneo extends JFrame implements IVistaTorneo, MouseListener {

	private JPanel contentPane;
	private DefaultListModel<Entrenador> listModelEntrenadores = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listModelPokemon1 = new DefaultListModel<Pokemon>();
	private DefaultListModel<Pokemon> listModelPokemon2 = new DefaultListModel<Pokemon>();
	private DefaultListModel<String> listModelHechizo1 = new DefaultListModel<String>();
	private DefaultListModel<String> listModelHechizo2 = new DefaultListModel<String>();
	private ActionListener actionListener;
	private JPanel panel_1;
	private JPanel panel;
	private JTextArea textAreaProgreso;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JPanel panel_5;
	private JTextArea textAreaBatallas;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JButton btnMostrarPokemon;
	private JButton btnAgregarBatalla;
	private JButton btnComenzarBatallas;
	private JButton btnAvanzarFase;
	private JScrollPane scrollPane_1;
	private JPanel panel_10;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JList<Entrenador> listEntrenadores1;
	private JList<Pokemon> listPokemon1;
	private JList<String> listHechizos1;
	private JScrollPane scrollPane_4;
	private JPanel panel_11;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JList<Entrenador> listEntrenadores2;
	private JList<Pokemon> listPokemon2;
	private JList<String> listHechizos2;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;

	/**
	 * Create the frame.
	 */
	public VentanaTorneo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 467);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_2.add(this.scrollPane_1);
		
		this.listEntrenadores1 = new JList<Entrenador>();
		this.listEntrenadores1.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_1.setViewportView(this.listEntrenadores1);
		
		this.panel_10 = new JPanel();
		this.panel_2.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_10.add(this.scrollPane_2);
		
		this.listPokemon1 = new JList<Pokemon>();
		this.listPokemon1.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_2.setViewportView(this.listPokemon1);
		
		this.scrollPane_3 = new JScrollPane();
		this.panel_10.add(this.scrollPane_3);
		
		this.listHechizos1 = new JList<String>();
		this.listHechizos1.setBorder(new TitledBorder(null, "Hechizos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_3.setViewportView(this.listHechizos1);
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.scrollPane_4 = new JScrollPane();
		this.panel_3.add(this.scrollPane_4);
		
		this.listEntrenadores2 = new JList<Entrenador>();
		this.listEntrenadores2.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_4.setViewportView(this.listEntrenadores2);
		
		this.panel_11 = new JPanel();
		this.panel_3.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.scrollPane_5 = new JScrollPane();
		this.panel_11.add(this.scrollPane_5);
		
		this.listPokemon2 = new JList<Pokemon>();
		this.listPokemon2.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_5.setViewportView(this.listPokemon2);
		
		this.scrollPane_6 = new JScrollPane();
		this.panel_11.add(this.scrollPane_6);
		
		this.listHechizos2 = new JList<String>();
		this.listHechizos2.setBorder(new TitledBorder(null, "Hechizos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_6.setViewportView(this.listHechizos2);
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_4.add(this.scrollPane);
		
		this.textAreaBatallas = new JTextArea();
		this.textAreaBatallas.setBorder(new TitledBorder(null, "Batallas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane.setViewportView(this.textAreaBatallas);
		
		this.panel_5 = new JPanel();
		this.panel_4.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_5.add(this.panel_7);
		
		this.panel_12 = new JPanel();
		this.panel_7.add(this.panel_12);
		
		this.btnMostrarPokemon = new JButton("Mostrar Pokemon");
		this.panel_12.add(this.btnMostrarPokemon);
		
		this.panel_6 = new JPanel();
		this.panel_5.add(this.panel_6);
		
		this.panel_13 = new JPanel();
		this.panel_6.add(this.panel_13);
		
		this.btnAgregarBatalla = new JButton("Agregar Batalla");
		this.panel_13.add(this.btnAgregarBatalla);
		
		this.panel_8 = new JPanel();
		this.panel_5.add(this.panel_8);
		
		this.panel_14 = new JPanel();
		this.panel_8.add(this.panel_14);
		
		this.btnComenzarBatallas = new JButton("Comenzar Batallas");
		this.btnComenzarBatallas.setEnabled(false);
		this.panel_14.add(this.btnComenzarBatallas);
		
		this.panel_9 = new JPanel();
		this.panel_5.add(this.panel_9);
		
		this.panel_15 = new JPanel();
		this.panel_9.add(this.panel_15);
		
		this.btnAvanzarFase = new JButton("Avanzar de Fase");
		this.btnAvanzarFase.setEnabled(false);
		this.panel_15.add(this.btnAvanzarFase);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.SOUTH);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.textAreaProgreso = new JTextArea();
		this.textAreaProgreso.setEnabled(false);
		this.textAreaProgreso.setBorder(new TitledBorder(null, "Progreso de Batallas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.add(this.textAreaProgreso, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void mostrarEntrenadores() {
		for (int i=0; i<Torneo.getInstance().getEntrenadores().size(); i++) {
			this.listModelEntrenadores.addElement(Torneo.getInstance().getEntrenadores().get(i));
		}
		this.listEntrenadores1.setModel(listModelEntrenadores);
		this.listEntrenadores2.setModel(listModelEntrenadores);
	}

	@Override
	public void mostrarPokemonHechizos() {
		if (this.listEntrenadores1.getSelectedValue() != null && this.listEntrenadores2.getSelectedValue() != null && this.listEntrenadores1.getSelectedValue() != this.listEntrenadores2.getSelectedValue()) {
			this.listModelPokemon1.clear();
			this.listModelHechizo1.clear();
			this.listModelPokemon2.clear();
			this.listModelHechizo2.clear();
			Entrenador e1 = this.listEntrenadores1.getSelectedValue();
			Entrenador e2 = this.listEntrenadores2.getSelectedValue();
			for (int i=0; i<e1.getPokemones().size(); i++)
				this.listModelPokemon1.addElement(e1.getPokemones().get(i));
			this.listPokemon1.setModel(listModelPokemon1);
			if (e1.getCantidadHechizos()>0) {
				this.listModelHechizo1.addElement("Niebla");
				this.listModelHechizo1.addElement("Tormenta");
				this.listModelHechizo1.addElement("Viento");
				this.listHechizos1.setModel(listModelHechizo1);
			}
			for (int i=0; i<e2.getPokemones().size(); i++)
				this.listModelPokemon2.addElement(e2.getPokemones().get(i));
			this.listPokemon2.setModel(listModelPokemon2);
			if (e2.getCantidadHechizos()>0) {
				this.listModelHechizo2.addElement("Niebla");
				this.listModelHechizo2.addElement("Tormenta");
				this.listModelHechizo2.addElement("Viento");
				this.listHechizos2.setModel(listModelHechizo2);
			}
		}
	}

	@Override
	public void elegirPokemonHechizo() {
		//ELIJO POKEMON DE CADA ENTRENADOR, LO AGREGO AL TEXTFIELD Y BORRO LOS ENTRENADORES DE LAS LISTAS
		if (this.listPokemon1.getSelectedValue() != null && this.listPokemon2.getSelectedValue() != null && this.listEntrenadores1.getSelectedValue() != this.listEntrenadores2.getSelectedValue()) {
			//Aca guardaria en alguna parte del torneo los entrenadores,los pokemon y los hechizos
			String aux = this.textAreaBatallas.getText();
			this.textAreaBatallas.setText(aux + "Entrenador " + this.listEntrenadores1.getSelectedValue().getNombre() + " vs  Entrenador " + this.listEntrenadores2.getSelectedValue().getNombre() + '\n');
			this.listModelEntrenadores.removeElement(this.listEntrenadores1.getSelectedValue());
			this.listModelEntrenadores.removeElement(this.listEntrenadores2.getSelectedValue());
			this.listEntrenadores1.setModel(listModelEntrenadores);
			this.listEntrenadores2.setModel(listModelEntrenadores);
			this.listModelPokemon1.clear();
			this.listModelPokemon2.clear();
			this.listModelHechizo1.clear();
			this.listModelHechizo2.clear();
			this.listPokemon1.setModel(listModelPokemon1);
			this.listPokemon2.setModel(listModelPokemon2);
			this.listHechizos1.setModel(listModelHechizo1);
			this.listHechizos2.setModel(listModelHechizo2);
			if (this.listModelEntrenadores.isEmpty()) {
				this.btnComenzarBatallas.setEnabled(true);
				this.btnAgregarBatalla.setEnabled(false);
				this.btnMostrarPokemon.setEnabled(false);
			}
		}
	}

	@Override
	public void comenzarBatallas() {
		this.contentPane.setEnabled(false);
		this.textAreaProgreso.setEnabled(true);
		//ACA COMIENZAN A EJECUTARSE LOS THREADS
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnComenzarBatallas.addActionListener(actionListener);
		this.btnMostrarPokemon.addActionListener(actionListener);
		this.btnAgregarBatalla.addActionListener(actionListener);
		this.btnAvanzarFase.addActionListener(actionListener);
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
