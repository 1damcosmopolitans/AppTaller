package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class BuscaAlta {

	private JFrame frame;
	private JTextField textFieldMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaAlta window = new BuscaAlta();
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
	public BuscaAlta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(37, 29, 220, 66);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnNuevaAlta = new JButton("Nueva Alta");
		btnNuevaAlta.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNuevaAlta.setBounds(323, 29, 220, 66);
		frame.getContentPane().add(btnNuevaAlta);
		
		JLabel lblInsertarMatrcula = new JLabel("INSERTAR MATR\u00CDCULA");
		lblInsertarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMatrcula.setBounds(192, 101, 200, 50);
		frame.getContentPane().add(lblInsertarMatrcula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldMatricula.setBounds(68, 143, 461, 95);
		frame.getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(403, 285, 89, 23);
		frame.getContentPane().add(btnLogout);
	}
}
