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
import javax.swing.JPanel;

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
	private JTextField textField;
	private JButton btnGuardar;
	private JButton btnSalir;
	private boolean modo;
	private  String idReparacion;
	
	
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

	public FichaReparacion(String idReparacion, boolean modo) {
		this.idReparacion = idReparacion;
		this.modo = modo;
		initialize();
		setEventos();
	}
	
	private void initialize() {
		getContentPane().setLayout(null);
		
		lblDniPropietario = new JLabel("DNI PROPIETARIO");
		lblDniPropietario.setBounds(27, 71, 141, 27);
		lblDniPropietario.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDniPropietario);
		
		txtFldDni = new JTextField();
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
		txtFldMatricula.setBounds(208, 107, 216, 25);
		txtFldMatricula.setColumns(10);
		getContentPane().add(txtFldMatricula);
		
		txtFldIdReparacion = new JTextField();
		txtFldIdReparacion.setBounds(208, 150, 216, 25);
		txtFldIdReparacion.setColumns(10);
		getContentPane().add(txtFldIdReparacion);
		
		lblIdReparacion = new JLabel("ID REPARACION");
		lblIdReparacion.setBounds(27, 147, 141, 27);
		lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblIdReparacion);
		
		lblTipoVehiculo = new JLabel("TIPO VEHICULO");
		lblTipoVehiculo.setBounds(27, 196, 141, 27);
		lblTipoVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblTipoVehiculo);
		
		txtTipoVehiculo = new JTextField();
		txtTipoVehiculo.setBounds(208, 198, 216, 25);
		txtTipoVehiculo.setColumns(10);
		getContentPane().add(txtTipoVehiculo);
		
		lblFechaEntrega = new JLabel("FECHA ENTREGA");
		lblFechaEntrega.setBounds(27, 457, 141, 27);
		lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFechaEntrega);
		
		txtFechaEntrega = new JTextField();
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
		
		JTextArea txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setBounds(324, 337, 260, 171);
		getContentPane().add(txtAreaDescripcion);
		
		lblFechaIngreso = new JLabel("FECHA INGRESO");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaIngreso.setBounds(27, 245, 141, 27);
		getContentPane().add(lblFechaIngreso);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(208, 248, 216, 25);
		getContentPane().add(textField);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(27, 519, 89, 47);
		getContentPane().add(btnVolver);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(226, 519, 149, 47);
		getContentPane().add(btnGuardar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(495, 519, 89, 47);
		getContentPane().add(btnSalir);
			
	}
	/**
	 * Los eventos al pulsar los botones
	 */
	public void setEventos(){
	}
	}
	

