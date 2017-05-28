package Gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controllers.ControlClientes;
import Controllers.ControlReparaciones;
import Controllers.ControlVehiculos;
import Models.Vehiculo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.util.Calendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FichaReparacion extends JFrame {

	private JTextField txtFldDni;
	private JLabel lblDniPropietario;
	private JLabel lblFichaReparacion;
	private JLabel lblMatricula;
	private JTextField txtFldMatricula;
	private JTextField txtFldIdReparacion;
	private JLabel lblIdReparacion;
	private JLabel lblTipoVehiculo;
	private JTextField txtTipoVehiculo;
	private JLabel lblFechaEntrega;
	private JTextField txtFechaEntrega;
	private JLabel lblEstadoReparacion;
	private JList estadoList;
	private JList pagoList;
	private JLabel lblPagado;
	private JLabel lblDescripcion;
	private JTextArea textAreaAveria;
	private JLabel lblFechaIngreso;
	private JTextField txtFechaIngreso;
	private JButton btnGuardar;
	private JButton btnSalir;
	private  String idReparacion;
	private String dniPropietario;
	private String matricula;
	private String tipo;
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaReparacion window = new FichaReparacion();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Que se vea la luz !
	 */

	public FichaReparacion(String matricula, String dniPropietario,String tipo) {			//UNA REPARACION SE IDENTIFICA POR LA MATRICULA Y EL DNI DEL PROPIETARIO DEL VEHICULO
		this.matricula = matricula;
		this.dniPropietario = dniPropietario;
		this.tipo = tipo;
		initialize();
		setEventos();
	}
	
	private void initialize() {
		
		/*txtFldDni.setEnabled(false);									//Deshabilitamos la matricula y el dni--> da error
		txtFldMatricula.setEnabled(false);*/
		
		
		getContentPane().setLayout(null);
		setBounds(200, 100, 573, 475);
		
		
		lblDniPropietario = new JLabel("DNI PROPIETARIO");
		lblDniPropietario.setBounds(27, 71, 141, 27);
		lblDniPropietario.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDniPropietario);
		
		txtFldDni = new JTextField();
		
		txtFldDni.setText(dniPropietario);											//Sacamos el dni desde la ficha de vehiculo
		txtFldDni.setEnabled(false);
	
		txtFldDni.setBounds(208, 71, 216, 25);
		getContentPane().add(txtFldDni);
		txtFldDni.setColumns(10);
		
		lblFichaReparacion = new JLabel("FICHA REPARACION");
		lblFichaReparacion.setBounds(208, 11, 203, 27);
		lblFichaReparacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblFichaReparacion);
		
		lblMatricula = new JLabel("MATRICULA");
		lblMatricula.setBounds(27, 109, 141, 27);
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblMatricula);
		
		txtFldMatricula = new JTextField();
		
		txtFldMatricula.setText(matricula); 				//Sacamos la matricula desde la ficha de vehiculo
		txtFldMatricula.setEnabled(false);
		
		txtFldMatricula.setBounds(208, 107, 216, 25);
		txtFldMatricula.setColumns(10);
		getContentPane().add(txtFldMatricula);
		
		txtFldIdReparacion = new JTextField();
		txtFldIdReparacion.setBounds(208, 207, 216, 25);
		txtFldIdReparacion.setColumns(10);
		getContentPane().add(txtFldIdReparacion);
		
		lblIdReparacion = new JLabel("ID REPARACION");
		lblIdReparacion.setBounds(27, 207, 141, 27);
		lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblIdReparacion);
		
		lblTipoVehiculo = new JLabel("TIPO VEHICULO");
		lblTipoVehiculo.setBounds(27, 157, 141, 27);
		lblTipoVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblTipoVehiculo);
		
		txtTipoVehiculo = new JTextField();
		txtTipoVehiculo.setEnabled(false);
		
		txtTipoVehiculo.setText(tipo); 						//AQUI INTRODUCIMOS EL TIPO DE VEHÍCULO SACADO DE LA FICHA DE VEHICULO
		txtTipoVehiculo.setBounds(208, 160, 216, 25);
		txtTipoVehiculo.setColumns(10);
		getContentPane().add(txtTipoVehiculo);
		
		lblFechaEntrega = new JLabel("FECHA ENTREGA");
		lblFechaEntrega.setBounds(27, 457, 141, 27);
		lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFechaEntrega);
		
		txtFechaEntrega = new JTextField();
		txtFechaEntrega.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFechaEntrega.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
				    JOptionPane.showMessageDialog(null,"Debes ingresar un formato de fecha correcto (like 2010-19-19) ");
				}
			}
		});
		
		
		txtFechaEntrega.setBounds(27, 483, 216, 25);
		txtFechaEntrega.setColumns(10);
		getContentPane().add(txtFechaEntrega);
		
		lblEstadoReparacion = new JLabel("ESTADO REPARACION");
		lblEstadoReparacion.setBounds(27, 301, 166, 27);
		lblEstadoReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEstadoReparacion);
		
		estadoList = new JList();
		estadoList.setBounds(208, 308, 79, 70);
		getContentPane().add(estadoList);
		estadoList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Inicial", "Intermedio", "Avanzado","Reparado"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		estadoList.setSelectedIndex(0);
		
		lblPagado = new JLabel("PENDIENTE PAGO");
		lblPagado.setBounds(27, 393, 141, 27);
		lblPagado.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPagado);
		
		pagoList = new JList();
		pagoList.setBounds(208, 400, 62, 32);
		getContentPane().add(pagoList);
		pagoList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pendiente", "Pagado"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pagoList.setSelectedIndex(0);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(324, 302, 166, 24);
		getContentPane().add(lblDescripcion);
		
		final JTextArea txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setBounds(324, 337, 260, 171);
		getContentPane().add(txtAreaDescripcion);
		
		lblFechaIngreso = new JLabel("FECHA INGRESO");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaIngreso.setBounds(27, 245, 141, 27);
		getContentPane().add(lblFechaIngreso);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (txtFechaIngreso.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
			    JOptionPane.showMessageDialog(null,"Debes ingresar un formato de fecha correcto (like 2010-19-19) ");
			}
			}
		});
		txtFechaIngreso.setColumns(10);
		txtFechaIngreso.setBounds(208, 248, 216, 25);
		getContentPane().add(txtFechaIngreso);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//****FichaVehiculo.this.setVisible(true)*****;
				FichaReparacion.this.setVisible(false);
			}
		});
		btnVolver.setBounds(27, 519, 89, 47);
		getContentPane().add(btnVolver);
		
		btnGuardar = new JButton("GUARDAR");
		/**
		 * CAS01: SE GUARDA EN LA LISTA DE REPARACIONES AL INTRODUCIR BIEN LOS CAMPOS DE FECHA DE INGRESO Y EL IDREPARACION
		 * CASO2: SE GUARDA EN LA LISTA DE REPARACIONES PAGADAS AL INTRODUCIR BIEN TODOS LOS CAMPOS  --FALTA POR IMPLEMENTAR (AQUI SE GUARDAN TODAS caso1 y caso2 en la misma lista)
		 */
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override //(String idRep, String matriculaRep, Calendar fechaIni, Calendar fechaFin, int idFactura, String averia, String estado)
			public void mouseClicked(MouseEvent arg0) {
				if(txtFldIdReparacion.getText() == null || txtFldIdReparacion.getText() == "" || txtFechaIngreso.getText()== null || txtFechaIngreso.getText()== ""){					
					JOptionPane.showMessageDialog(null,"Debes ingresar un Id de reparacion y una fecha de ingreso para poder guardar los detalles de la reparacion!");				
				}else{
				try{
					//if(!txtFldDni.equals("")&& txtFldDni.getText() != null && !txtFldMatricula.equals("")&& txtFldMatricula.getText() !=null &&!txtFldIdReparacion.equals("") && txtFldIdReparacion != null && !txtTipoVehiculo.equals("")&& txtTipoVehiculo != null && txtFechaEntrega != null){
					
						ControlReparaciones.Aniadir(txtFldIdReparacion.getText(), txtFldMatricula.getText(), txtFechaIngreso.getText(), txtFechaEntrega.getText(),txtAreaDescripcion.getText(),(String)estadoList.getSelectedValue());
						JOptionPane.showMessageDialog(null, "Se añadio con exito la descripcion de la reparación para este vehículo", "GUARDAR REPARACION", JOptionPane.INFORMATION_MESSAGE);
					//}else{
						//ControlReparaciones.Editar(txtFldIdReparacion.getText(), txtFldMatricula.getText(), txtFechaIngreso.getText(),txtFechaEntrega.getText(), txtAreaDescripcion.getText(),(String)estadoList.getSelectedValue());
						//JOptionPane.showMessageDialog(null, "Se modificó con exito la ficha de la reparación para este vehículo", "REPARACION EDITADA", JOptionPane.INFORMATION_MESSAGE);
					//}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL AÑADIR LA REPARACIÓN", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		btnGuardar.setBounds(226, 519, 149, 47);
		getContentPane().add(btnGuardar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {			//SALIMOS DE LA APP
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(495, 519, 89, 47);
		getContentPane().add(btnSalir);
			
	}
	/**
	 * Los eventos al pulsar los botones
	 */
	public void setEventos(){
	}
	}
	

