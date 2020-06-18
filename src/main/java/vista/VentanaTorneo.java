package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;

public class VentanaTorneo extends JFrame implements IVista,MouseListener {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPaneEntrenadores;
	private JList listEntrenadores;
	private JScrollPane scrollPane;
	private JList listPokemones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTorneo frame = new VentanaTorneo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTorneo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPaneEntrenadores = new JScrollPane();
		panel.add(scrollPaneEntrenadores, BorderLayout.CENTER);
		
		listEntrenadores = new JList();
		scrollPaneEntrenadores.setViewportView(listEntrenadores);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		listPokemones = new JList();
		scrollPane.setViewportView(listPokemones);
	}

	@Override
	public void agregarEntrenador() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPokemon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarEntrenador() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarPokemon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seleccionarHechizo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void empezarTorneo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminarTorneo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
	public void generarEntrenadores() {
		
	}

	@Override
	public void generarPokemones() {
		// TODO Auto-generated method stub
		
	}

}
