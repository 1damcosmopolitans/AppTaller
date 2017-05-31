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
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

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
	private String tipoV;

	/**
	 * Create the application.
	 */
	public FichaVehiculo(String matricula, boolean modo) {
		getContentPane().setBackground(new Color(204, 255, 153));
		this.matricula = matricula;
		this.modo = modo;
		initialize();
		setEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(modo)
			setBounds(100, 100, 263, 435);
		else
			setBounds(100, 100, 543, 435);
		getContentPane().setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo.setBounds(88, 100, 115, 25);
		getContentPane().add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(88, 190, 70, 44);
		getContentPane().add(lblMarca);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo vehiculo:");
		lblTipoVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoVehiculo.setBounds(88, 386, 194, 26);
		getContentPane().add(lblTipoVehiculo);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtModelo.setBounds(88, 141, 251, 44);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMarca.setColumns(10);
		txtMarca.setBounds(88, 240, 251, 44);
		getContentPane().add(txtMarca);
		
		listVehiculo = new JList();
		listVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		listVehiculo.setModel(new AbstractListModel() {
			String[] values = new String[] {"Coche", "Moto", "Camion", "Bicicleta"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listVehiculo.setSelectedIndex(0);
		/**
		 * Le dmos logica a esto para almacenar el valor en un string
		 */
		listVehiculo.setBounds(88, 418, 225, 92);
		getContentPane().add(listVehiculo);
		
		btnVerCliente = new JButton("Ver cliente");
		btnVerCliente.setBackground(new Color(51, 153, 204));
		btnVerCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new FichaCliente(txtDni.getText()).setVisible(true);
			}
		});

		btnVerCliente.setFont(new Font("SimSun", Font.BOLD, 11));
		btnVerCliente.setBounds(392, 21, 127, 99);
		btnVerCliente.setFont(new Font("SimSun", Font.BOLD, 18));
		btnVerCliente.setBounds(621, 52, 180, 133);

		getContentPane().add(btnVerCliente);
		
		btnReparacion = new JButton("Reparacion");
		btnReparacion.setBackground(new Color(255, 215, 0));
		btnReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new FichaReparacion(txtMatricula.getText(), txtDni.getText(),(String)listVehiculo.getSelectedValue()).setVisible(true);		//Modo escritura cogiendo los datos de ficha vehiculos
			}
		});
		
		

		btnReparacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReparacion.setBounds(392, 177, 127, 94);

		btnReparacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReparacion.setBounds(621, 292, 180, 135);

		getContentPane().add(btnReparacion);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblColor.setBounds(88, 522, 91, 20);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtColor.setColumns(10);

		txtColor.setBounds(10, 304, 193, 31);

		txtColor.setBounds(88, 558, 257, 44);
		getContentPane().add(txtColor);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMatricula.setBounds(88, 16, 142, 25);
		getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(88, 51, 251, 44);
		txtMatricula.setText(matricula);
		getContentPane().add(txtMatricula);
		
		btnCrear = new JButton("Añadir");
		btnCrear.setBackground(new Color(204, 255, 204));
		


		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.setBounds(42, 346, 109, 66);

		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrear.setBounds(159, 618, 135, 50);

		getContentPane().add(btnCrear);
		
		JLabel lblDni = new JLabel("Dni propietario:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDni.setBounds(89, 285, 162, 34);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDni.setColumns(10);
		txtDni.setBounds(88, 335, 257, 44);
		getContentPane().add(txtDni);
		
		btnGuardar = new JButton("Guardar");


		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(217, 346, 127, 66);

		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBounds(159, 619, 135, 50);

		getContentPane().add(btnGuardar);
		
		//ESTABLECER EL MODO LECTURA O ESCRITURA
		for(Component i: getContentPane().getComponents()){
			i.setEnabled(modo);
		}
		
		btnVerCliente.setEnabled(true);
		btnReparacion.setEnabled(true);
		/*btnVerCliente.setVisible(!modo);
		btnReparacion.setVisible(!modo);*/
		
		btnEditar = new JToggleButton("Editar");
		btnEditar.setBackground(new Color(153, 153, 102));


		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(392, 344, 127, 66);

		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEditar.setBounds(621, 550, 180, 119);

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
		btnVerCliente.setVisible(!modo);
		btnReparacion.setVisible(!modo);
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
				setVisible(false);
				BuscaAlta p = new BuscaAlta();
				p.setVisible(true);
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