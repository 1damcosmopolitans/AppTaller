package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.JPanel;

import DAO.connectURL;

public class LoginApp extends JFrame {

	// ATRIBUTOS
	protected static final String PASS = "1234";
	protected static final String USER = "admin";
	private JFrame frame;
	private JPasswordField passwordField;
	private boolean PasswordC;
	private boolean UsuarioC;
	private JTextArea textUsuario;
	private JLabel lberror1, lberror2;
	private JButton btnSalir;
	private JLabel lblFondo;

	/**
	 * Create the application.
	 */
	
	
	public LoginApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		frame = new JFrame();
		getContentPane().setForeground(new Color(51, 153, 51));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 99));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setMinimumSize(new Dimension(1000, 600));
		getContentPane().setBackground(new Color(204, 255, 153));
		getContentPane().setLayout(null);
		
		JLabel lblIcon = new JLabel();
		lblIcon.setBounds(635, 11, 261, 172);
		lblIcon.setIcon(new ImageIcon(LoginApp.class.getResource("/Imagenes/User-icon.png")));
		getContentPane().add(lblIcon);
		
		JLabel lblUsuario = new JLabel("User :");
		lblUsuario.setBounds(176, 186, 224, 152);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		getContentPane().add(lblUsuario);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(176, 391, 224, 158);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		getContentPane().add(lblPassword);

		textUsuario = new JTextArea();
		textUsuario.setBounds(448, 226, 428, 67);
		textUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 45));
		getContentPane().add(textUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(448, 429, 428, 67);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		getContentPane().add(passwordField);

		lberror1 = new JLabel("");
		lberror1.setBounds(448, 334, 419, 50);
		lberror1.setForeground(new Color(204, 0, 0));
		lberror1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lberror1);

		lberror2 = new JLabel("");
		lberror2.setBounds(448, 525, 428, 50);
		lberror2.setForeground(new Color(204, 0, 0));
		lberror2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lberror2);

		JButton BotonListo_1 = new JButton("ENTRAR");
		BotonListo_1.setBounds(985, 198, 200, 113);
		ImageIcon icono=new ImageIcon("Imagenes/Entrar.png");
		BotonListo_1.setBackground(new Color(124, 252, 0));
		BotonListo_1.setForeground(Color.BLACK);
		BotonListo_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(BotonListo_1);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(985, 387, 200, 126);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(255, 102, 102));
		getContentPane().add(btnSalir);
		
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1596, 837);
		lblFondo.setIcon(new ImageIcon(LoginApp.class.getResource("/Imagenes/Login1.jpg")));
		getContentPane().add(lblFondo);
		
		

		BotonListo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(connectURL.login(textUsuario.getText().trim(), passwordField.getText())){
					setVisible(false);
					new BuscaAlta().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "ERROR INICIO SESION", JOptionPane.ERROR_MESSAGE);
				}
				
//				if (textUsuario.getText().trim().equals(USER)) {
//					UsuarioC = true;
//
//					lberror1.setText("");
//				} else {
//					lberror1.setText("Error Usuario Incorrecto!");
//				}
//
//				if (passwordField.getText().equals(PASS)) {
//					PasswordC = true;
//
//					lberror2.setText("");
//				} else {
//					lberror2.setText("Error Password Incorrecta!");
//				}
//
//				if (UsuarioC && PasswordC) {
//					
//                    setVisible(false);
//					BuscaAlta p = new BuscaAlta();
//					p.setVisible(true);
//
//				}
			}
		});

	}
	public JLabel getLberror2() {
		return lberror2;
	}
}

