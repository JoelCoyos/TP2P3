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
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class VentanaAlta extends JFrame implements KeyListener, IVistaAlta, MouseListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JTextField textFieldNombre;
	private JPanel panel_12;
	private JButton btnNewButtonTorneo;
	private JPanel panel_13;
	private JButton btnNewButtonAgregar;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JTextField textFieldNombre1;
	private JTextField textFieldTipo1;
	private JTextField textFieldNombre2;
	private JTextField textFieldTipo2;
	private JTextField textFieldNombre3;
	private JTextField textFieldTipo3;
	private JTextField textFieldNombre4;
	private JTextField textFieldTipo4;
	private JTextField textFieldNombre5;
	private JTextField textFieldTipo5;
	private JTextField textFieldNombre6;
	private JTextField textFieldTipo6;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JPanel panel_34;
	private JPanel panel_35;
	private JPanel panel_36;
	private JPanel panel_37;
	private JPanel panel_38;
	private JPanel panel_39;
	private JScrollPane scrollPane;
	private DefaultListModel<Entrenador> listaModelEntrenador = new DefaultListModel<Entrenador>();
	private ActionListener actionListener;
	private JPanel panel_40;
	private JTextField textFieldRecarga1;
	private JPanel panel_41;
	private JPanel panel_42;
	private JPanel panel_43;
	private JPanel panel_44;
	private JPanel panel_45;
	private JPanel panel_46;
	private JTextField textFieldRecarga2;
	private JTextField textFieldRecarga3;
	private JTextField textFieldRecarga4;
	private JTextField textFieldRecarga5;
	private JTextField textFieldRecarga6;
	private JPanel panel_47;
	private JPanel panel_48;
	private JPanel panel_49;
	private JPanel panel_50;
	private JPanel panel_51;
	private JButton btnNewButtonVer;
	private JPanel panel_52;
	private JList<Entrenador> listEntrenadores;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaPokemon;
	private JPanel panel_53;
	private JPanel panel_54;
	private JPanel panel_55;
	private JPanel panel_56;
	private JPanel panel_57;
	private JPanel panel_58;
	private JTextField textFieldGranRecarga1;
	private JTextField textFieldGranRecarga2;
	private JTextField textFieldGranRecarga3;
	private JTextField textFieldGranRecarga4;
	private JTextField textFieldGranRecarga5;
	private JTextField textFieldGranRecarga6;
	private JPanel panel_59;
	private JPanel panel_60;
	private JPanel panel_61;
	private JPanel panel_62;
	private JPanel panel_63;
	private JPanel panel_64;

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
		this.listEntrenadores.setBorder(new TitledBorder(null, "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane.setViewportView(this.listEntrenadores);
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_11.add(this.scrollPane_1);
		
		this.textAreaPokemon = new JTextArea();
		this.textAreaPokemon.setBorder(new TitledBorder(null, "Pokemon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.scrollPane_1.setViewportView(this.textAreaPokemon);
		
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
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(null, "Pokemon 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_16 = new JPanel();
		this.panel_16.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_4.add(this.panel_16);
		
		this.panel_28 = new JPanel();
		this.panel_16.add(this.panel_28);
		
		this.textFieldNombre2 = new JTextField();
		this.panel_28.add(this.textFieldNombre2);
		this.textFieldNombre2.setColumns(10);
		
		this.panel_17 = new JPanel();
		this.panel_17.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_4.add(this.panel_17);
		
		this.panel_29 = new JPanel();
		this.panel_17.add(this.panel_29);
		
		this.textFieldTipo2 = new JTextField();
		this.panel_29.add(this.textFieldTipo2);
		this.textFieldTipo2.setColumns(10);
		
		this.panel_42 = new JPanel();
		this.panel_42.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_4.add(this.panel_42);
		
		this.panel_47 = new JPanel();
		this.panel_42.add(this.panel_47);
		
		this.textFieldRecarga2 = new JTextField();
		this.panel_47.add(this.textFieldRecarga2);
		this.textFieldRecarga2.setColumns(10);
		
		this.panel_54 = new JPanel();
		this.panel_54.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_4.add(this.panel_54);
		
		this.panel_60 = new JPanel();
		this.panel_54.add(this.panel_60);
		
		this.textFieldGranRecarga2 = new JTextField();
		this.panel_60.add(this.textFieldGranRecarga2);
		this.textFieldGranRecarga2.setColumns(10);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new TitledBorder(null, "Pokemon 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_18 = new JPanel();
		this.panel_18.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_5.add(this.panel_18);
		
		this.panel_30 = new JPanel();
		this.panel_18.add(this.panel_30);
		
		this.textFieldNombre3 = new JTextField();
		this.panel_30.add(this.textFieldNombre3);
		this.textFieldNombre3.setColumns(10);
		
		this.panel_19 = new JPanel();
		this.panel_19.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_5.add(this.panel_19);
		
		this.panel_31 = new JPanel();
		this.panel_19.add(this.panel_31);
		
		this.textFieldTipo3 = new JTextField();
		this.panel_31.add(this.textFieldTipo3);
		this.textFieldTipo3.setColumns(10);
		
		this.panel_43 = new JPanel();
		this.panel_43.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_5.add(this.panel_43);
		
		this.panel_48 = new JPanel();
		this.panel_43.add(this.panel_48);
		
		this.textFieldRecarga3 = new JTextField();
		this.panel_48.add(this.textFieldRecarga3);
		this.textFieldRecarga3.setColumns(10);
		
		this.panel_55 = new JPanel();
		this.panel_55.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_5.add(this.panel_55);
		
		this.panel_61 = new JPanel();
		this.panel_55.add(this.panel_61);
		
		this.textFieldGranRecarga3 = new JTextField();
		this.panel_61.add(this.textFieldGranRecarga3);
		this.textFieldGranRecarga3.setColumns(10);
		
		this.panel_6 = new JPanel();
		this.panel_6.setBorder(new TitledBorder(null, "Pokemon 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_6);
		this.panel_6.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_20 = new JPanel();
		this.panel_20.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_6.add(this.panel_20);
		
		this.panel_32 = new JPanel();
		this.panel_20.add(this.panel_32);
		
		this.textFieldNombre4 = new JTextField();
		this.panel_32.add(this.textFieldNombre4);
		this.textFieldNombre4.setColumns(10);
		
		this.panel_21 = new JPanel();
		this.panel_21.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_6.add(this.panel_21);
		
		this.panel_33 = new JPanel();
		this.panel_21.add(this.panel_33);
		
		this.textFieldTipo4 = new JTextField();
		this.panel_33.add(this.textFieldTipo4);
		this.textFieldTipo4.setColumns(10);
		
		this.panel_44 = new JPanel();
		this.panel_44.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_6.add(this.panel_44);
		
		this.panel_49 = new JPanel();
		this.panel_44.add(this.panel_49);
		
		this.textFieldRecarga4 = new JTextField();
		this.panel_49.add(this.textFieldRecarga4);
		this.textFieldRecarga4.setColumns(10);
		
		this.panel_56 = new JPanel();
		this.panel_56.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_6.add(this.panel_56);
		
		this.panel_62 = new JPanel();
		this.panel_56.add(this.panel_62);
		
		this.textFieldGranRecarga4 = new JTextField();
		this.panel_62.add(this.textFieldGranRecarga4);
		this.textFieldGranRecarga4.setColumns(10);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new TitledBorder(null, "Pokemon 5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_22 = new JPanel();
		this.panel_22.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_22);
		
		this.panel_34 = new JPanel();
		this.panel_22.add(this.panel_34);
		
		this.textFieldNombre5 = new JTextField();
		this.panel_34.add(this.textFieldNombre5);
		this.textFieldNombre5.setColumns(10);
		
		this.panel_23 = new JPanel();
		this.panel_23.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_23);
		
		this.panel_35 = new JPanel();
		this.panel_23.add(this.panel_35);
		
		this.textFieldTipo5 = new JTextField();
		this.panel_35.add(this.textFieldTipo5);
		this.textFieldTipo5.setColumns(10);
		
		this.panel_45 = new JPanel();
		this.panel_45.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_45);
		
		this.panel_50 = new JPanel();
		this.panel_45.add(this.panel_50);
		
		this.textFieldRecarga5 = new JTextField();
		this.panel_50.add(this.textFieldRecarga5);
		this.textFieldRecarga5.setColumns(10);
		
		this.panel_57 = new JPanel();
		this.panel_57.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_57);
		
		this.panel_63 = new JPanel();
		this.panel_57.add(this.panel_63);
		
		this.textFieldGranRecarga5 = new JTextField();
		this.panel_63.add(this.textFieldGranRecarga5);
		this.textFieldGranRecarga5.setColumns(10);
		
		this.panel_8 = new JPanel();
		this.panel_8.setBorder(new TitledBorder(null, "Pokemon 6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel_24 = new JPanel();
		this.panel_24.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_8.add(this.panel_24);
		
		this.panel_36 = new JPanel();
		this.panel_24.add(this.panel_36);
		
		this.textFieldNombre6 = new JTextField();
		this.panel_36.add(this.textFieldNombre6);
		this.textFieldNombre6.setColumns(10);
		
		this.panel_25 = new JPanel();
		this.panel_25.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_8.add(this.panel_25);
		
		this.panel_37 = new JPanel();
		this.panel_25.add(this.panel_37);
		
		this.textFieldTipo6 = new JTextField();
		this.panel_37.add(this.textFieldTipo6);
		this.textFieldTipo6.setColumns(10);
		
		this.panel_46 = new JPanel();
		this.panel_46.setBorder(new TitledBorder(null, "Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_8.add(this.panel_46);
		
		this.panel_51 = new JPanel();
		this.panel_46.add(this.panel_51);
		
		this.textFieldRecarga6 = new JTextField();
		this.panel_51.add(this.textFieldRecarga6);
		this.textFieldRecarga6.setColumns(10);
		
		this.panel_58 = new JPanel();
		this.panel_58.setBorder(new TitledBorder(null, "Gran Recarga?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_8.add(this.panel_58);
		
		this.panel_64 = new JPanel();
		this.panel_58.add(this.panel_64);
		
		this.textFieldGranRecarga6 = new JTextField();
		this.panel_64.add(this.textFieldGranRecarga6);
		this.textFieldGranRecarga6.setColumns(10);
		
		this.panel_7 = new JPanel();
		this.panel_1.add(this.panel_7);
		
		this.panel_38 = new JPanel();
		this.panel_7.add(this.panel_38);
		
		this.btnNewButtonAgregar = new JButton("Agregar");
		this.btnNewButtonAgregar.setEnabled(false);
		this.panel_38.add(this.btnNewButtonAgregar);
		
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
		boolean error = false;
		Entrenador entrenador = new Entrenador(this.getNombreEntrenador());
		try {
			entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon1(),this.getTipoPokemon1(),recarga(this.getRecarga1()),recarga(this.getGranRecarga1())));
		} catch (TipoNoEncontradoException e) {
			error = true;
			JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
		}
		if (!this.getNombrePokemon2().isEmpty() && !this.getTipoPokemon2().isEmpty() && !this.getRecarga2().isEmpty() && (this.getGranRecarga2().isEmpty() || (!this.getGranRecarga2().isEmpty() && this.getTipoPokemon2().equalsIgnoreCase("Hielo")))){
			try {
				entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon2(),this.getTipoPokemon2(),recarga(this.getRecarga2()),recarga(this.getGranRecarga2())));
				if (!this.getNombrePokemon3().isEmpty() && !this.getTipoPokemon3().isEmpty() && !this.getRecarga3().isEmpty() && (this.getGranRecarga3().isEmpty() || (!this.getGranRecarga3().isEmpty() && this.getTipoPokemon3().equalsIgnoreCase("Hielo")))) {
					try {
						entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon3(),this.getTipoPokemon3(),recarga(this.getRecarga3()),recarga(this.getGranRecarga3())));
						if (!this.getNombrePokemon4().isEmpty() && !this.getTipoPokemon4().isEmpty() && !this.getRecarga4().isEmpty() && (this.getGranRecarga4().isEmpty() || (!this.getGranRecarga4().isEmpty() && this.getTipoPokemon4().equalsIgnoreCase("Hielo")))) {
							try {
								entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon4(),this.getTipoPokemon4(),recarga(this.getRecarga4()),recarga(this.getGranRecarga4())));
								if (!this.getNombrePokemon5().isEmpty() && !this.getTipoPokemon5().isEmpty() && !this.getRecarga5().isEmpty() && (this.getGranRecarga5().isEmpty() || (!this.getGranRecarga5().isEmpty() && this.getTipoPokemon5().equalsIgnoreCase("Hielo")))) {
									try {
										entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon5(),this.getTipoPokemon5(),recarga(this.getRecarga5()),recarga(this.getGranRecarga5())));
										if (!this.getNombrePokemon6().isEmpty() && !this.getTipoPokemon6().isEmpty() && !this.getRecarga6().isEmpty() && (this.getGranRecarga6().isEmpty() || (!this.getGranRecarga6().isEmpty() && this.getTipoPokemon6().equalsIgnoreCase("Hielo")))) {
											try {
												entrenador.aniadirPokemon(PokemonFactory.getPokemon(this.getNombrePokemon6(),this.getTipoPokemon6(),recarga(this.getRecarga6()),recarga(this.getGranRecarga6())));
											} catch (TipoNoEncontradoException e) {
												error = true;
												JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
											}
										}
									} catch (TipoNoEncontradoException e) {
										error = true;
										JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
									}
								}
							} catch (TipoNoEncontradoException e) {
								error = true;
								JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
							}
						}
					} catch (TipoNoEncontradoException e) {
						error = true;
						JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
					}
				}
			} catch (TipoNoEncontradoException e) {
				error = true;
				JOptionPane.showMessageDialog(this,"El tipo ingresado no existe");
			}
		}
		if (!error) {
			try {
				Torneo.getInstance().aniadirEntrenador(entrenador);
				this.listaModelEntrenador.addElement(entrenador);
				this.listEntrenadores.setModel(listaModelEntrenador);
			} catch (MaximaCapacidadEntrenadoresException e) {
				JOptionPane.showMessageDialog(this,"No puede agregar mas entrenadores");
			} catch (EntrenadorRepetidoException e) {
				JOptionPane.showMessageDialog(this,"Ya existe un entrenador con ese nombre");
			}
			if (this.listaModelEntrenador.getSize()==8)
				this.btnNewButtonTorneo.setEnabled(true);
		}
		this.reseteaCampos();
	}
	
	public void reseteaCampos() {
		this.textFieldNombre.setText("");
		this.textFieldNombre1.setText("");
		this.textFieldNombre2.setText("");
		this.textFieldNombre3.setText("");
		this.textFieldNombre4.setText("");
		this.textFieldNombre5.setText("");
		this.textFieldNombre6.setText("");
		this.textFieldTipo1.setText("");
		this.textFieldTipo2.setText("");
		this.textFieldTipo3.setText("");
		this.textFieldTipo4.setText("");
		this.textFieldTipo5.setText("");
		this.textFieldTipo6.setText("");
		this.textFieldRecarga1.setText("");
		this.textFieldRecarga2.setText("");
		this.textFieldRecarga3.setText("");
		this.textFieldRecarga4.setText("");
		this.textFieldRecarga5.setText("");
		this.textFieldRecarga6.setText("");
		this.textFieldGranRecarga1.setText("");
		this.textFieldGranRecarga2.setText("");
		this.textFieldGranRecarga3.setText("");
		this.textFieldGranRecarga4.setText("");
		this.textFieldGranRecarga5.setText("");
		this.textFieldGranRecarga6.setText("");
	}
	
	@Override
	public void mostrarPokemon() {
		if (this.listEntrenadores.getSelectedValue() != null) {
			this.textAreaPokemon.setText("");
			Entrenador e = this.listEntrenadores.getSelectedValue();
			ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
			pokemon = e.getPokemones();
			for (int i=0; i<pokemon.size(); i++)
				this.textAreaPokemon.append(pokemon.get(i).toString() + '\n');
		}
	}

	@Override
	public String getNombrePokemon1() {
		return this.textFieldNombre1.getText();
	}

	@Override
	public String getNombrePokemon2() {
		return this.textFieldNombre2.getText();
	}

	@Override
	public String getNombrePokemon3() {
		return this.textFieldNombre3.getText();
	}
	
	@Override
	public String getNombrePokemon4() {
		return this.textFieldNombre4.getText();
	}

	@Override
	public String getNombrePokemon5() {
		return this.textFieldNombre5.getText();
	}

	@Override
	public String getNombrePokemon6() {
		return this.textFieldNombre6.getText();
	}

	@Override
	public String getTipoPokemon1() {
		return this.textFieldTipo1.getText();
	}

	@Override
	public String getTipoPokemon2() {
		return this.textFieldTipo2.getText();
	}

	@Override
	public String getTipoPokemon3() {
		return this.textFieldTipo3.getText();
	}

	@Override
	public String getTipoPokemon4() {
		return this.textFieldTipo4.getText();
	}

	@Override
	public String getTipoPokemon5() {
		return this.textFieldTipo5.getText();
	}

	@Override
	public String getTipoPokemon6() {
		return this.textFieldTipo6.getText();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnNewButtonAgregar.addActionListener(actionListener);
		this.btnNewButtonTorneo.addActionListener(actionListener);
		this.btnNewButtonVer.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		if (!this.getNombreEntrenador().isEmpty() && !this.getNombrePokemon1().isEmpty() && !this.getTipoPokemon1().isEmpty() && !this.getRecarga1().isEmpty() && (this.getGranRecarga1().isEmpty() || (!this.getGranRecarga1().isEmpty() && this.getTipoPokemon1().equalsIgnoreCase("Hielo"))))
			this.btnNewButtonAgregar.setEnabled(true);
		else
			this.btnNewButtonAgregar.setEnabled(false);
		
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
	public String getRecarga1() {
		return this.textFieldRecarga1.getText();
	}

	@Override
	public String getRecarga2() {
		return this.textFieldRecarga2.getText();
	}

	@Override
	public String getRecarga3() {
		return this.textFieldRecarga3.getText();
	}

	@Override
	public String getRecarga4() {
		return this.textFieldRecarga4.getText();
	}

	@Override
	public String getRecarga5() {
		return this.textFieldRecarga5.getText();
	}

	@Override
	public String getRecarga6() {
		return this.textFieldRecarga6.getText();
	}

	@Override
	public String getGranRecarga1() {
		return this.textFieldGranRecarga1.getText();
	}

	@Override
	public String getGranRecarga2() {
		return this.textFieldGranRecarga2.getText();
	}

	@Override
	public String getGranRecarga3() {
		return this.textFieldGranRecarga3.getText();
	}

	@Override
	public String getGranRecarga4() {
		return this.textFieldGranRecarga4.getText();
	}

	@Override
	public String getGranRecarga5() {
		return this.textFieldGranRecarga5.getText();
	}

	@Override
	public String getGranRecarga6() {
		return this.textFieldGranRecarga6.getText();
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
}
