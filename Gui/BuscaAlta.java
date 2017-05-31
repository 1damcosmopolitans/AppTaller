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
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Color;

public class BuscaAlta extends JFrame{

	protected JFrame frame;
	private JTextField textFieldMatricula;

	/**
	 * Create the application.
	 */
	public BuscaAlta() {
		getContentPane().setBackground(new Color(204, 255, 153));
		setMinimumSize(new Dimension(1500, 900));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		frame = new JFrame();
		setBounds(100, 100, 1720, 900);
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
		btnBuscar.setBounds(152, 43, 395, 218);
		getContentPane().add(btnBuscar);
		
		JButton btnNuevaAlta = new JButton("Nueva Alta");
		btnNuevaAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FichaVehiculo(textFieldMatricula.getText(), true).setVisible(true);
			}
		});
		btnNuevaAlta.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNuevaAlta.setBounds(919, 43, 395, 218);
		getContentPane().add(btnNuevaAlta);
		
		JLabel lblInsertarMatrcula = new JLabel("INSERTAR MATR\u00CDCULA");
		lblInsertarMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInsertarMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMatrcula.setBounds(586, 239, 312, 130);
		getContentPane().add(lblInsertarMatrcula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldMatricula.setBounds(281, 350, 922, 95);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				LoginApp p = new LoginApp();
				p.setVisible(true);

			}
		});
		btnLogout.setBackground(new Color(255, 102, 102));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBounds(582, 487, 320, 95);
		getContentPane().add(btnLogout);
		
		JLabel label = new JLabel();
		label.setBounds(0, 0, 1484, 837);
		getContentPane().add(label);
	}
}
