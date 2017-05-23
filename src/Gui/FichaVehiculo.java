package Gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controllers.ControlVehiculos;
import Models.Vehiculo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class FichaVehiculo extends JFrame{
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtMatricula;
	private JList listVehiculo;
	private String matricula;
	private boolean modo; //TRUE MODO ESCRITURA FALSE MODO LECTURA
	private JTextField txtDni;

	/**
	 * Create the application.
	 */
	public FichaVehiculo(String matricula, boolean modo) {
		this.matricula = matricula;
		this.modo = modo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 432);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 54, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 106, 46, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo vehiculo:");
		lblTipoVehiculo.setBounds(10, 188, 75, 14);
		getContentPane().add(lblTipoVehiculo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(10, 75, 193, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(10, 119, 193, 20);
		getContentPane().add(txtMarca);
		
		listVehiculo = new JList();
		listVehiculo.setModel(new AbstractListModel() {
			String[] values = new String[] {"Coche", "Moto", "Camion"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listVehiculo.setSelectedIndex(0);
		listVehiculo.setBounds(10, 213, 193, 83);
		getContentPane().add(listVehiculo);
		
		JButton btnVerCliente = new JButton("Ver cliente");
		btnVerCliente.setFont(new Font("SimSun", Font.BOLD, 11));
		btnVerCliente.setBounds(283, 70, 116, 81);
		getContentPane().add(btnVerCliente);
		
		JButton btnReparacion = new JButton("Reparacion");
		btnReparacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReparacion.setBounds(283, 200, 116, 81);
		getContentPane().add(btnReparacion);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 295, 75, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(10, 320, 193, 20);
		getContentPane().add(txtColor);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 11, 57, 14);
		getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(10, 28, 193, 20);
		txtMatricula.setText(matricula);
		getContentPane().add(txtMatricula);
		
		JButton btnCrear = new JButton("Añadir");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					ControlVehiculos.Aniadir(txtMarca.getText(), txtModelo.getText(), txtDni.getText(), (String)listVehiculo.getSelectedValue(), txtColor.getText(), txtMatricula.getText());
					
					JOptionPane.showMessageDialog(null, "Se añadio con exito el vehiculo", "AÑADIR VEHICULO", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL AÑADIR VEHICULO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.setBounds(10, 351, 89, 23);
		getContentPane().add(btnCrear);
		
		JLabel lblDni = new JLabel("Dni propietario:");
		lblDni.setBounds(10, 147, 109, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(10, 160, 193, 20);
		getContentPane().add(txtDni);
		
		//ESTABLECER EL MODO LECTURA O ESCRITURA
		for(Component i: getContentPane().getComponents()){
			i.setEnabled(modo);
		}
		
		btnVerCliente.setEnabled(true);
		btnReparacion.setEnabled(true);
	
		//SI EL MODO ES LECTURA CARGAMOS EL FORMULARIO CON LA INFORMACIÓN CORRESPONDIENTE
		if(!modo){
			if(ControlVehiculos.Buscar(matricula)){
				Vehiculo aux = ControlVehiculos.Obtener(matricula);
				
				txtMatricula.setText(aux.getMatricula());
				txtModelo.setText(aux.getModelo());
				txtMarca.setText(aux.getMarca());
				txtColor.setText(aux.getColor());
				txtDni.setText(aux.getDnipropietario());
				listVehiculo.setSelectedValue(aux.getTipo(), true);
			}
		}
	}
}
