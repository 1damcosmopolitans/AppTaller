package Gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FichaObra extends JFrame{

	private String IdReparacion;
	private JFrame frame;
	private JLabel lblFichaObra ;
	private JTextField txtIdReparacion;
	private JTextField txtTpoInvertido;
	private JTextField txtCostePiezas;
	private JTextField txtTotalPrecio;
	private JButton btnIniRep;
	private JButton btnFinRep;
	private JButton btnGuardar;
	private JLabel lblTpoInvertido;
	private JLabel lblIdReparacion;
	private JLabel lblCostePiezas;
	private JLabel lblTotal;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the application.
	 */
	public FichaObra(String IdReparacion) {
		this.IdReparacion = IdReparacion;
		
		initialize();
		setEventos();
		
	}
	
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		lblFichaObra = new JLabel("FICHA OBRA");
		lblFichaObra.setBounds(286, 11, 280, 36);
		lblFichaObra.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblFichaObra);
		getContentPane().add(lblFichaObra);
		
		lblTpoInvertido = new JLabel("TIEMPO INVERTIDO");
		lblTpoInvertido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTpoInvertido.setBounds(25, 175, 160, 27);
		getContentPane().add(lblTpoInvertido);
		
		lblIdReparacion = new JLabel("ID REPARACION");
		lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdReparacion.setBounds(25, 107, 141, 27);
		getContentPane().add(lblIdReparacion);
		
		lblCostePiezas = new JLabel("COSTE PIEZAS");
		lblCostePiezas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCostePiezas.setBounds(25, 248, 141, 27);
		getContentPane().add(lblCostePiezas);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(25, 345, 95, 27);
		getContentPane().add(lblTotal);
		
		txtIdReparacion = new JTextField();
		
		txtIdReparacion.setBounds(195, 110, 218, 25);
		getContentPane().add(txtIdReparacion);
		txtIdReparacion.setColumns(10);
		
		txtTpoInvertido = new JTextField();
		txtTpoInvertido.setColumns(10);
		txtTpoInvertido.setBounds(195, 178, 218, 25);
		getContentPane().add(txtTpoInvertido);
		
		txtCostePiezas = new JTextField();
		txtCostePiezas.setColumns(10);
		txtCostePiezas.setBounds(195, 248, 218, 25);
		getContentPane().add(txtCostePiezas);
		
		txtTotalPrecio = new JTextField();
		txtTotalPrecio.setColumns(10);
		txtTotalPrecio.setBounds(125, 345, 218, 25);
		getContentPane().add(txtTotalPrecio);
		
		btnIniRep = new JButton("INICIO");
		btnIniRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniRep.setBounds(479, 107, 203, 43);
		getContentPane().add(btnIniRep);
		
		btnFinRep = new JButton("FINALIZAR");
		btnFinRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinRep.setBounds(479, 221, 203, 43);
		getContentPane().add(btnFinRep);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(479, 329, 203, 43);
		getContentPane().add(btnGuardar);
	}
	
	
	
	public void setEventos(){
		
		
	}
}
