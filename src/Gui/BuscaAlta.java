package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Controllers.ControlVehiculos;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscaAlta extends JFrame{

	protected JFrame frame;
	private JTextField textFieldMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaAlta window = new BuscaAlta();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscaAlta() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		frame = new JFrame();
		setBounds(100, 100, 590, 357);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//setExtendedState(MAXIMIZED_BOTH);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ControlVehiculos.Buscar(textFieldMatricula.getText()))
				new FichaVehiculo(textFieldMatricula.getText(), false).setVisible(true);
				else
				JOptionPane.showMessageDialog(null, "No se encontro un vehiculo con esa matrícula","ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(37, 29, 220, 66);
		getContentPane().add(btnBuscar);
		
		JButton btnNuevaAlta = new JButton("Nueva Alta");
		btnNuevaAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FichaVehiculo(textFieldMatricula.getText(), true).setVisible(true);
			}
		});
		btnNuevaAlta.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNuevaAlta.setBounds(323, 29, 220, 66);
		getContentPane().add(btnNuevaAlta);
		
		JLabel lblInsertarMatrcula = new JLabel("INSERTAR MATR\u00CDCULA");
		lblInsertarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMatrcula.setBounds(192, 101, 200, 50);
		getContentPane().add(lblInsertarMatrcula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldMatricula.setBounds(68, 143, 461, 95);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(403, 285, 89, 23);
		getContentPane().add(btnLogout);
	}
}
