package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginApp {
	
	//ATRIBUTOS
	protected static final String PASS="1234";
	protected static final String USER="admin";
	private JFrame frame;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton BotonListo;
	private JTextArea textAreaUsuario;
	private boolean PasswordC;
	private boolean UsuarioC;
	private JTextArea textAreaUsuario_1;
	private JLabel lberror1, lberror2;
	
	

	/**
	 * Inicio de la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginApp window = new LoginApp();
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
	public LoginApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(51, 153, 51));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 99));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH); /*Nos permite poner el frame maximizado ocupando toda la pantalla*/
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(125, 211, 428, 152);
		lblUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 99));
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 99));
		lblPassword.setBounds(125, 561, 428, 152);
		frame.getContentPane().add(lblPassword);
		
		textAreaUsuario_1 = new JTextArea();
		textAreaUsuario_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 99));
		textAreaUsuario_1.setBounds(636, 226, 749, 152);
		frame.getContentPane().add(textAreaUsuario_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 99));
		passwordField.setBounds(636, 561, 749, 152);
		frame.getContentPane().add(passwordField);
		
		lberror1 = new JLabel("");
		lberror1.setForeground(new Color(204, 0, 0));
		lberror1.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lberror1.setBounds(646, 409, 739, 115);
		frame.getContentPane().add(lberror1);
		
		lberror2 = new JLabel("");
		lberror2.setForeground(new Color(204, 0, 0));
		lberror2.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lberror2.setBounds(636, 764, 739, 115);
		frame.getContentPane().add(lberror2);
		
		JButton BotonListo_1 = new JButton("ENTRAR");
	
		BotonListo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textAreaUsuario_1.getText().equals(USER)) {
					UsuarioC = true;

					lberror1.setText("");
				} else {
					lberror1.setText("Error Usuario Incorrecto!");
				}

				if (passwordField.equals(PASS)) {
					PasswordC = true;

					lberror2.setText("");
				} else {
					lberror2.setText("Error Password Incorrecta!");
				}

				if (UsuarioC && PasswordC) {
					lberror1.setText("Login Correcto");
					
				
				}
			}
		});
		BotonListo_1.setBackground(new Color(0, 255, 102));
		BotonListo_1.setForeground(Color.BLACK);
		BotonListo_1.setFont(new Font("Tahoma", Font.PLAIN, 42));
		BotonListo_1.setBounds(1523, 226, 287, 487);
		frame.getContentPane().add(BotonListo_1);
		
		
	}
}
	
		
		
	

