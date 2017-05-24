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
import javax.swing.JToggleButton;

public class FichaVehiculo extends JFrame{
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtMatricula;
	private JList listVehiculo;
	private JToggleButton btnEditar;
	private JButton btnVerCliente;
	private JButton btnReparacion;
	private JButton btnGuardar;
	private JButton btnCrear;
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
		setEventos();
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
		
		btnVerCliente = new JButton("Ver cliente");
		btnVerCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new FichaCliente(txtDni.getText()).setVisible(true);
			}
		});
		btnVerCliente.setFont(new Font("SimSun", Font.BOLD, 11));
		btnVerCliente.setBounds(283, 70, 116, 81);
		getContentPane().add(btnVerCliente);
		
		btnReparacion = new JButton("Reparacion");
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
		
		btnCrear = new JButton("Añadir");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		btnGuardar = new JButton("Guardar");

		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(10, 351, 89, 23);
		getContentPane().add(btnGuardar);
		
		//ESTABLECER EL MODO LECTURA O ESCRITURA
		for(Component i: getContentPane().getComponents()){
			i.setEnabled(modo);
		}
		
		btnVerCliente.setEnabled(true);
		btnReparacion.setEnabled(true);
		btnVerCliente.setVisible(!modo);
		btnReparacion.setVisible(!modo);
		
		btnEditar = new JToggleButton("Editar");

		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(283, 336, 116, 38);
		getContentPane().add(btnEditar);
	
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
		
		//BOTONES VISIBILIDAD
		btnEditar.setVisible(!modo);
		btnGuardar.setVisible(!modo);
		btnCrear.setVisible(modo);
	}
	
	public void setEventos(){
		//EVENTO EDITAR VEHICULOS
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					ControlVehiculos.Editar(txtMarca.getText(), txtModelo.getText(), txtDni.getText(), (String)listVehiculo.getSelectedValue(), txtColor.getText(), matricula, txtMatricula.getText());
					JOptionPane.showMessageDialog(null, "Vehiculo modificado con éxito","MODIFICACIÓN VEHICULO", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ep){
					JOptionPane.showMessageDialog(null, ep.getMessage(),"ERROR AL MODIFICAR EL VEHICULO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//EVENTO CREAR VEHICULOS
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
		
		//EVENTO ACTIVAR MODO EDITAR
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component i: getContentPane().getComponents()){
					i.setEnabled(btnEditar.isSelected());
				}
				
				btnEditar.setEnabled(true);
				btnVerCliente.setEnabled(true);
				btnReparacion.setEnabled(true);
			}
		});
	}
}
