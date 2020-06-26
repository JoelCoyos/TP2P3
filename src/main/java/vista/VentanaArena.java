package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Insets;

/**
 * Ventana que muestra el desarrollo 
 */
@SuppressWarnings("serial")
public class VentanaArena extends JFrame implements IVistaArena {
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaArena1;
	private JTextArea textAreaArena2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaArena frame = new VentanaArena();
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
	public VentanaArena() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		this.setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		textAreaArena1 = new JTextArea();
		textAreaArena1.setMargin(new Insets(0, 0, 0, 0));
		textAreaArena1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 2), "Arena 1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportView(textAreaArena1);
		
		scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		
		textAreaArena2 = new JTextArea();
		textAreaArena2.setMargin(new Insets(0, 0, 0, 0));
		textAreaArena2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Arena 2 ", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scrollPane_1.setViewportView(textAreaArena2);
		
		this.setVisible(true);
	}

	@Override
	public void muestraMensaje(String mensaje, int numeroPanel) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (numeroPanel == 0) {
					String aux = textAreaArena1.getText();
					textAreaArena1.setText(aux + mensaje + '\n');
				}
				else {
					String aux = textAreaArena2.getText();
					textAreaArena2.setText(aux + mensaje + '\n');
				}
			}
		});

	}

	@Override
	public void cerrarVentana() {
		this.dispose();
	} 
}
