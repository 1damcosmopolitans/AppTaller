package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import java.awt.SystemColor;

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
		getContentPane().setBackground(new Color(102, 153, 204));
				getContentPane().setLayout(null);
		
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setBounds(263, 130, 224, 152);
				lblUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 50));
				getContentPane().add(lblUsuario);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(263, 359, 224, 158);
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		getContentPane().add(lblPassword);

		textUsuario = new JTextArea();
		textUsuario.setBounds(628, 175, 428, 109);
		textUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 45));
		getContentPane().add(textUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(628, 376, 428, 109);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		getContentPane().add(passwordField);

		lberror1 = new JLabel("");
		lberror1.setBounds(638, 292, 419, 50);
		lberror1.setForeground(new Color(204, 0, 0));
		lberror1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lberror1);

		lberror2 = new JLabel("");
		lberror2.setBounds(628, 490, 428, 50);
		lberror2.setForeground(new Color(204, 0, 0));
		lberror2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lberror2);

		JButton BotonListo_1 = new JButton("ENTRAR");
		BotonListo_1.setBounds(1211, 175, 200, 132);
		BotonListo_1.setBackground(new Color(124, 252, 0));
		BotonListo_1.setForeground(Color.BLACK);
		BotonListo_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(BotonListo_1);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(255, 102, 102));
		btnSalir.setBounds(1211, 354, 200, 131);
		getContentPane().add(btnSalir);
		
		

		BotonListo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textUsuario.getText().trim().equals(USER)) {
					UsuarioC = true;

					lberror1.setText("");
				} else {
					lberror1.setText("Error Usuario Incorrecto!");
				}

				if (passwordField.getText().equals(PASS)) {
					PasswordC = true;

					lberror2.setText("");
				} else {
					lberror2.setText("Error Password Incorrecta!");
				}

				if (UsuarioC && PasswordC) {
					
                    setVisible(false);
					BuscaAlta p = new BuscaAlta();
					p.setVisible(true);

				}
			}
		});

	}
}

