package Gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FichaObra extends JFrame{

	private JFrame frame;
	JLabel lblFichaObra ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnIniRep;
	private JButton btnFinRep;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaObra window = new FichaObra();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FichaObra() {
		getContentPane().setLayout(null);
		
		lblFichaObra = new JLabel("FICHA OBRA");
		lblFichaObra.setBounds(286, 11, 280, 36);
		lblFichaObra.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblFichaObra);
		getContentPane().add(lblFichaObra);
		
		JLabel lblTpoInvertido = new JLabel("TIEMPO INVERTIDO");
		lblTpoInvertido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTpoInvertido.setBounds(25, 175, 160, 27);
		getContentPane().add(lblTpoInvertido);
		
		JLabel lblIdReparacion = new JLabel("ID REPARACION");
		lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdReparacion.setBounds(25, 107, 141, 27);
		getContentPane().add(lblIdReparacion);
		
		JLabel lblCostePiezas = new JLabel("COSTE PIEZAS");
		lblCostePiezas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCostePiezas.setBounds(25, 248, 141, 27);
		getContentPane().add(lblCostePiezas);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(25, 345, 95, 27);
		getContentPane().add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(195, 110, 218, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 178, 218, 25);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(195, 248, 218, 25);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 345, 218, 25);
		getContentPane().add(textField_3);
		
		btnIniRep = new JButton("INICIO");
		btnIniRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniRep.setBounds(479, 107, 203, 43);
		getContentPane().add(btnIniRep);
		
		btnFinRep = new JButton("FINALIZAR");
		btnFinRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinRep.setBounds(479, 221, 203, 43);
		getContentPane().add(btnFinRep);
		
		button_1 = new JButton("GUARDAR");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(479, 329, 203, 43);
		getContentPane().add(button_1);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
