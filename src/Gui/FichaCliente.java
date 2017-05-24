package Gui;

import Models.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;		//Para validar email
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controllers.ControlClientes;
import Controllers.ControlVehiculos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FichaCliente extends JFrame {
	
	private JFrame frame3;
	private FichaVehiculo ficha1;
	private String dniCliente;
	private boolean modo;								//TRUE MODO ESCRITURA FALSE MODO LECTURA
	private JPanel contentPane;
	private JLabel lblCabezera;
	private JPanel panelPrincipal;
	private JLabel lblNombre;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblComentarios;
	private JTextField txtFldComentarios;
	private JTextField txtFldDni;
	private JTextField txtFldNombre;
	private JTextField txtFldApellido1;
	private JTextField txtFldApellido2;
	private JTextField txtFldDireccion;
	private JTextField txtFldTelefono;
	private JTextField txtFldEmail;
	private JButton btnEditar;
	private JButton button;
	private JButton button_1;
	private JPanel panelDni;
	private JLabel lblDni;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Constructor
	 */
	
	public FichaCliente(String dni, boolean modo) {
		this.dniCliente = dni;
		this.modo = modo;
		initialize();
		
	}

	/**
	 * Instanciamos los contenidos de la Frame.
	 */
	private void initialize() {
		
		
		txtFldDni.setText(dniCliente);
		
		/*PONEMOS EL DNI SACADO DE LA FICHA DELVEHICULO Y DESABILITAMOS EL PANEL SEGUNDARIO
		panelDni.setEnabled(false);*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		lblCabezera = new JLabel("FICHAS CLIENTES",SwingConstants.CENTER);
		lblCabezera.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCabezera.setBounds(162, 11, 396, 33);
		panelPrincipal.add(lblCabezera);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(25, 139, 69, 33);
		panelPrincipal.add(lblNombre);
		
		lblApellido1 = new JLabel("APELLIDO 1");
		lblApellido1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido1.setBounds(25, 194, 100, 33);
		panelPrincipal.add(lblApellido1);
		
		lblApellido2 = new JLabel("APELLIDO 2");
		lblApellido2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido2.setBounds(25, 248, 100, 33);
		panelPrincipal.add(lblApellido2);
		
		lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(25, 310, 100, 33);
		panelPrincipal.add(lblDireccion);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(25, 372, 100, 33);
		panelPrincipal.add(lblTelefono);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(25, 431, 100, 33);
		panelPrincipal.add(lblEmail);
		
		lblComentarios = new JLabel("COMENTARIOS");
		lblComentarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComentarios.setBounds(494, 261, 114, 33);
		panelPrincipal.add(lblComentarios);
		
		txtFldComentarios = new JTextField();
		txtFldComentarios.setBounds(432, 311, 248, 153);
		panelPrincipal.add(txtFldComentarios);
		txtFldComentarios.setColumns(10);
		
		panelDni = new JPanel();
		panelDni.setBounds(10, 65, 314, 56);
		panelPrincipal.add(panelDni);
		panelDni.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(20, 11, 69, 42);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDni.add(lblDni);
		
		txtFldDni = new JTextField();
		txtFldDni.setBounds(121, 11, 184, 33);
		panelDni.add(txtFldDni);
		txtFldDni.setColumns(10);
		
		txtFldNombre = new JTextField();
		/**
		 * Para impedir que se pueda introducir numeros Y un límite de carácteres de 15
		 */
		txtFldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e1) {
				
				int limit1=15;
				char c1 = e1.getKeyChar();
				if ((c1 < 'a' || c1 > 'z') && (c1 < 'A' || c1 > 'Z')) e1.consume();
				if(txtFldNombre.getText().length() == limit1) e1.consume();
				if(txtFldNombre.getText().matches(".*\\d+.*")){												//Validacion de los simbolos raros
					JOptionPane.showMessageDialog(null,"No se admiten carácteres especiales!");
					txtFldNombre.setText("");
				}		
			}
		});
		
		/**
		 * Restringimos la longitud del texto
		 */
		txtFldNombre.setColumns(10);
		txtFldNombre.setBounds(132, 139, 185, 33);
		panelPrincipal.add(txtFldNombre);
		
		txtFldApellido1 = new JTextField();
		/**
		 * Para impedir que se pueda introducir numeros
		 */
		txtFldApellido1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e2) {
				int limit2=15;
				char c2 = e2.getKeyChar();
				if ((c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) e2.consume();
				if(txtFldApellido1.getText().length() == limit2) e2.consume();
				if(txtFldApellido1.getText().matches(".*\\d+.*")){												//Validacion de los simbolos raros
					JOptionPane.showMessageDialog(null,"No se admiten carácteres especiales!");
					
				}
				
			}
		});
		txtFldApellido1.setColumns(10);
		txtFldApellido1.setBounds(132, 194, 185, 33);
		panelPrincipal.add(txtFldApellido1);
		
		txtFldApellido2 = new JTextField();
		/**
		 * Para impedir que se pueda introducir numeros Y un límite de carácteres de 15
		 */
		txtFldApellido2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e3) {
				int limit3 = 15;
				char c3 = e3.getKeyChar();
				if ((c3 < 'a' || c3 > 'z') && (c3 < 'A' || c3 > 'Z')) e3.consume();
				if(txtFldApellido2.getText().length() == limit3) e3.consume();
				if(txtFldApellido2.getText().matches(".*\\d+.*")){												//Validacion de los simbolos raros
					JOptionPane.showMessageDialog(null,"No se admiten carácteres especiales!");
					
				}
				
			}
		});
		txtFldApellido2.setColumns(10);
		txtFldApellido2.setBounds(132, 248, 185, 33);
		panelPrincipal.add(txtFldApellido2);
		
		txtFldDireccion = new JTextField();
		/**
		 * Limitamos el texto a 50 caracteres
		 */
		txtFldDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e5) {
				int limit4 = 50;
				if(txtFldApellido2.getText().length() == limit4) e5.consume();
			}
		});
		txtFldDireccion.setColumns(10);
		txtFldDireccion.setBounds(132, 310, 276, 33);
		panelPrincipal.add(txtFldDireccion);
		
		txtFldTelefono = new JTextField();
		/**
		 * Para impedir que se pueda introducir letras Y un límite de carácteres de 9
		 */
		txtFldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e6) {
				int limit5 = 9;
				char c4 = e6.getKeyChar();
				if (c4 < '0' || c4 > '9') e6.consume();
				if(txtFldDireccion.getText().length() == limit5) e6.consume();
			}
		});
		txtFldTelefono.setColumns(10);
		txtFldTelefono.setBounds(135, 374, 185, 33);
		panelPrincipal.add(txtFldTelefono);
		
		txtFldEmail = new JTextField();
		/**
		 * Límite de 25 carácteres 
		 */
		txtFldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e7) {
				int limit6 = 25;
				if(txtFldEmail.getText().length() == limit6) e7.consume();
				
				if(!validarEmail(txtFldEmail.getText())){					
						JOptionPane.showMessageDialog(null,"Debes ingresar una mail correcto.");				
				}							
			}
		});
		txtFldEmail.setColumns(10);
		txtFldEmail.setBounds(135, 431, 273, 33);
		panelPrincipal.add(txtFldEmail);
		
		btnEditar = new JButton("EDITAR");
		
		/**
		 * AL RELLENAR EL FORMULARIO VALIDADO GUARDAMOS LOS DATOS***3 CMPOS OBLIGATORIOS
		 */
		
			btnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try{
						if(!txtFldDni.equals("")&& txtFldDni.getText() != null && !txtFldNombre.equals("")&& txtFldNombre.getText() !=null &&!txtFldApellido1.equals("") && txtFldApellido1 != null && !txtFldDireccion.equals("")&& txtFldDireccion != null)
						ControlClientes.Aniadir(txtFldDni.getText(), txtFldNombre.getText(), txtFldApellido1.getText(), txtFldApellido2.getText(),txtFldDireccion.getText(), txtFldTelefono.getText(), txtFldEmail.getText(), txtFldComentarios.getText());
						
						JOptionPane.showMessageDialog(null, "Se añadio con exito el cliente", "AÑADIR CLIENTE", JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL AÑADIR CLIENTE", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
				
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBounds(256, 488, 185, 50);
		panelPrincipal.add(btnEditar);
		
		button = new JButton("VOLVER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ficha1.setVisible(true);
				FichaCliente.this.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(25, 488, 185, 50);
		panelPrincipal.add(button);
		
		button_1 = new JButton("SALIR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(483, 488, 185, 50);
		panelPrincipal.add(button_1);
	}
	
	  private static boolean validarEmail(String email) {
		  
		  	//Compila la expresion regular dada dentro de Pattern
	        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
	 
	        //A ver si coincide el dato introducido contra este Pattern
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	 
	    }
	
	
		
}
