package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class FichaVehiculo extends JFrame{
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtMatricula;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaVehiculo window = new FichaVehiculo();
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
	public FichaVehiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 54, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 106, 46, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo vehiculo:");
		lblTipoVehiculo.setBounds(10, 162, 75, 14);
		getContentPane().add(lblTipoVehiculo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(10, 75, 193, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(10, 131, 193, 20);
		getContentPane().add(txtMarca);
		
		JList listVehiculo = new JList();
		listVehiculo.setBounds(10, 180, 193, 83);
		getContentPane().add(listVehiculo);
		
		JButton btnVerCoche = new JButton("Ver cliente");
		btnVerCoche.setFont(new Font("SimSun", Font.BOLD, 11));
		btnVerCoche.setBounds(283, 70, 116, 81);
		getContentPane().add(btnVerCoche);
		
		JButton btnReparacion = new JButton("Reparacion");
		btnReparacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReparacion.setBounds(283, 200, 116, 81);
		getContentPane().add(btnReparacion);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 267, 75, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(10, 286, 193, 20);
		getContentPane().add(txtColor);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 11, 57, 14);
		getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(10, 28, 193, 20);
		getContentPane().add(txtMatricula);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(10, 317, 89, 23);
		getContentPane().add(btnEditar);
	}
}
