package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import excepciones.TipoNoEncontradoException;
import modelo.Entrenador;
import modelo.Pokemon;
import modelo.PokemonFactory;
import modelo.Torneo;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;

public class VentanaTorneo extends JFrame implements IVista, ListSelectionListener, ActionListener {

	private JPanel contentPane;
	private JPanel panelEntrenadores;
	private JPanel panelPokemones;
	private JPanel panelArenas;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList<String> listArena1;
	private JList<String> listArena2;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JList<Entrenador> listEntreanador;
	private DefaultListModel<Entrenador> listaModelEntrenador = new DefaultListModel<Entrenador>();
	private DefaultListModel<Pokemon> listaModelPokemon = new DefaultListModel<Pokemon>();
	private JList<Pokemon> listPokemon;
	private JButton btnNewEntrenador;
	private JButton btnNewButton;
	private JButton btnEmpezar;
	private ActionListener actionListener;
	
	/**
	 * Create the frame.
	 */
	public VentanaTorneo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelEntrenadores = new JPanel();
		contentPane.add(panelEntrenadores);
		panelEntrenadores.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panelEntrenadores.add(scrollPane_2, BorderLayout.CENTER);
		
		listEntreanador = new JList();
		listEntreanador.addListSelectionListener(this);
		scrollPane_2.setViewportView(listEntreanador);
		listEntreanador.setModel(listaModelEntrenador);
		
		btnNewEntrenador = new JButton("Agregar Entrenador");
		this.btnNewEntrenador.addActionListener(this);
		panelEntrenadores.add(btnNewEntrenador, BorderLayout.NORTH);
		
		panelPokemones = new JPanel();
		contentPane.add(panelPokemones);
		panelPokemones.setLayout(new BorderLayout(0, 0));
		
		scrollPane_3 = new JScrollPane();
		panelPokemones.add(scrollPane_3);
		
		listPokemon = new JList();
		scrollPane_3.setViewportView(listPokemon);
		listPokemon.setModel(listaModelPokemon);
		
		btnNewButton = new JButton("Agregar Pokemon");
		scrollPane_3.setColumnHeaderView(btnNewButton);
		
		panelArenas = new JPanel();
		contentPane.add(panelArenas);
		panelArenas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		scrollPane_1 = new JScrollPane();
		panelArenas.add(scrollPane_1);
		
		listArena1 = new JList();
		scrollPane_1.setViewportView(listArena1);
		
		scrollPane = new JScrollPane();
		panelArenas.add(scrollPane);
		
		listArena2 = new JList();
		scrollPane.setViewportView(listArena2);
		
		btnEmpezar = new JButton("Empezar");
		this.btnEmpezar.setEnabled(false);
		btnEmpezar.setActionCommand("EMPEZAR");
		panelArenas.add(btnEmpezar);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnEmpezar.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	

	@Override
	public void generarEntrenadores() {
		this.listaModelEntrenador.clear();
		Entrenador e1 = new Entrenador("Ash");
		Entrenador e2 = new Entrenador("Misty");
		Entrenador e3 = new Entrenador("Brock");
		Entrenador e4 = new Entrenador("Tracey");
		Entrenador e5 = new Entrenador("Aura");
		Entrenador e6 = new Entrenador("Max");
		Entrenador e7 = new Entrenador("Maya");
		Entrenador e8 = new Entrenador("Ivy");
		try {
			e1.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e1.aniadirPokemon(PokemonFactory.getPokemon("Charizard", "Fuego", false));
			e1.aniadirPokemon(PokemonFactory.getPokemon("Articuno", "Hielo", true));

			e2.aniadirPokemon(PokemonFactory.getPokemon("Lapras", "Agua", true));
			e2.aniadirPokemon(PokemonFactory.getPokemon("Zapdos", "Electrico", false));
			e2.aniadirPokemon(PokemonFactory.getPokemon("Diglett", "Tierra", true));

			e3.aniadirPokemon(PokemonFactory.getPokemon("Jynx", "Hielo", true));
			e3.aniadirPokemon(PokemonFactory.getPokemon("Charizard", "Fuego", false));
			e3.aniadirPokemon(PokemonFactory.getPokemon("Ponyta", "Fuego", true));

			e4.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e4.aniadirPokemon(PokemonFactory.getPokemon("Milotic", "Agua", false));
			e4.aniadirPokemon(PokemonFactory.getPokemon("Magikarp", "Agua", true));

			e5.aniadirPokemon(PokemonFactory.getPokemon("Chimchar", "Fuego", true));
			e5.aniadirPokemon(PokemonFactory.getPokemon("Dewgong", "Hielo", false));
			e5.aniadirPokemon(PokemonFactory.getPokemon("Slowpoke", "Agua", true));

			e6.aniadirPokemon(PokemonFactory.getPokemon("Vulpix", "Fuego", true));
			e6.aniadirPokemon(PokemonFactory.getPokemon("Sandshrew", "Tierra", false));
			e6.aniadirPokemon(PokemonFactory.getPokemon("Cubone", "Tierra", true));

			e7.aniadirPokemon(PokemonFactory.getPokemon("Cubone", "Tierra", true));
			e7.aniadirPokemon(PokemonFactory.getPokemon("Greninja", "Agua", false));
			e7.aniadirPokemon(PokemonFactory.getPokemon("Cloyster", "Hielo", true));

			e8.aniadirPokemon(PokemonFactory.getPokemon("Pikachu", "Electrico", true));
			e8.aniadirPokemon(PokemonFactory.getPokemon("Slugma", "Fuego", false));
			e8.aniadirPokemon(PokemonFactory.getPokemon("Diglett", "Tierra", true, true));
		} catch (TipoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaModelEntrenador.addElement(e1);
		listaModelEntrenador.addElement(e2);
		listaModelEntrenador.addElement(e3);
		listaModelEntrenador.addElement(e4);
		listaModelEntrenador.addElement(e5);
		listaModelEntrenador.addElement(e6);
		listaModelEntrenador.addElement(e7);
		listaModelEntrenador.addElement(e8);
		this.repaint();
	}

	@Override
	public void generarPokemones(Entrenador entrenador) {
		listaModelPokemon.clear();
		Iterator<Pokemon> iterator = entrenador.getPokemones().iterator();
		while(iterator.hasNext())
		{
			listaModelPokemon.addElement(iterator.next());
		}
		this.repaint();
		
		
	}

	public void valueChanged(ListSelectionEvent e) {
		generarPokemones(this.listEntreanador.getSelectedValue());
		
	}

	@Override
	public Entrenador[] getEntrenadores() {
		Entrenador[] entrenadores = new Entrenador[8];
		for(int i=0;i<8;i++)
		{
			entrenadores[i] = listaModelEntrenador.get(i);
		}
		return entrenadores;
		
		
	}


	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand() == "Agregar Entrenador") {
			//VentanaAgregarEntrenador ventana = new VentanaAgregarEntrenador();
		}
		else { //agregar pokemon
			//VentanaAgregarPokemon ventana = new VentanaAgregarPokemon();
		}
	}
}
