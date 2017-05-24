package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

public class LoginApp {

	// ATRIBUTOS
	protected static final String PASS = "1234";
	protected static final String USER = "admin";
	private JFrame frame;
	private JPasswordField passwordField;
	private boolean PasswordC;
	private boolean UsuarioC;
	private JTextArea textUsuario;
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
		
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		frame.setMinimumSize(new Dimension(1000, 600));
		frame.getContentPane().setBackground(new Color(152, 251, 152));
				frame.getContentPane().setLayout(null);
		
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setBounds(41, 111, 224, 152);
				lblUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 50));
				frame.getContentPane().add(lblUsuario);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(41, 293, 224, 158);
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		frame.getContentPane().add(lblPassword);

		textUsuario = new JTextArea();
		textUsuario.setBounds(271, 139, 428, 109);
		textUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 45));
		frame.getContentPane().add(textUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(271, 310, 428, 109);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		frame.getContentPane().add(passwordField);

		lberror1 = new JLabel("");
		lberror1.setBounds(281, 255, 396, 50);
		lberror1.setForeground(new Color(204, 0, 0));
		lberror1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(lberror1);

		lberror2 = new JLabel("");
		lberror2.setBounds(275, 430, 428, 34);
		lberror2.setForeground(new Color(204, 0, 0));
		lberror2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(lberror2);

		JButton BotonListo_1 = new JButton("ENTRAR");
		BotonListo_1.setBounds(738, 156, 201, 242);
		BotonListo_1.setBackground(new Color(0, 255, 102));
		BotonListo_1.setForeground(Color.BLACK);
		BotonListo_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(BotonListo_1);

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
					
                    frame.setVisible(false);
					BuscaAlta p = new BuscaAlta();
					p.frame.setVisible(true);

				}
			}
		});

	}
}
