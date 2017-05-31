package Gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controllers.ControlClientes;
import Controllers.ControlReparaciones;
import Controllers.ControlVehiculos;
import Models.Reparacion;
import Models.Vehiculo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JPanel;

import java.util.Calendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


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
	private JButton btnEliminar;
	private JMenuBar menuBar;
	private JMenu mnLeer;
	private JMenuItem mntmAadir;
	private JLabel lblDe ;
	private JButton btnVolver;
	private JPanel panel;
	private JTextArea txtAreaDescripcion;
	private ArrayList<Reparacion> ListaTemporal;
	private int indice;
	JButton btnReparar;
	private JTextField txtPrecioTotal;
	private JLabel lblEur;

	

	/**
	 * CONSTRUCTOR
	 */

	public FichaReparacion(String matricula, String dniPropietario,String tipo) {			//UNA REPARACION SE IDENTIFICA POR LA MATRICULA Y EL DNI DEL PROPIETARIO DEL VEHICULO
		this.matricula = matricula;
		this.dniPropietario = dniPropietario;
		this.tipo = tipo;
		ListaTemporal = ControlReparaciones.listaTotal(matricula);
		indice = 0;
		initialize();
	}
	
	private void initialize() {
		
		getContentPane().setLayout(null);
		setBounds(200, 100, 729, 616);
		
		
		lblDniPropietario = new JLabel("DNI PROPIETARIO");
		lblDniPropietario.setBounds(27, 71, 141, 27);
		lblDniPropietario.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblDniPropietario);
		
		txtFldDni = new JTextField();
		
		txtFldDni.setText(dniPropietario);				//Sacamos el dni desde la ficha de vehiculo
		txtFldDni.setEnabled(false);
	
		txtFldDni.setBounds(208, 71, 216, 25);
		getContentPane().add(txtFldDni);
		txtFldDni.setColumns(10);
		
		lblFichaReparacion = new JLabel("FICHA REPARACION");
		lblFichaReparacion.setBounds(208, 33, 203, 27);
		lblFichaReparacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblFichaReparacion);
		
		lblMatricula = new JLabel("MATRICULA");
		lblMatricula.setBounds(27, 109, 141, 27);
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblMatricula);
		
		txtFldMatricula = new JTextField();
		
		txtFldMatricula.setText(matricula); 			//Sacamos la matricula desde la ficha de vehiculo
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
				
				/*LOGICA DETRAS DE LA REPARACION PAGADA
				if(txtFechaEntrega.getText() !="" || txtFechaEntrega.getText() !=null){
					txtPrecioTotal.setText(String.valueOf(ControlReparaciones.ObtenerPrecio(matricula)));
					txtPrecioTotal.setEnabled(false);
					btnReparar.setEnabled(false);
					
				}*/
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
		pagoList.setBounds(208, 400, 62, 39);
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
		
		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setBounds(324, 337, 189, 171);
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
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//****FichaVehiculo.this.setVisible(true)*****;
				FichaReparacion.this.setVisible(false);
			}
		});
		btnVolver.setBounds(27, 519, 141, 47);
		getContentPane().add(btnVolver);
		
		btnGuardar = new JButton("GUARDAR");
		/**
		 * CAS01: SE GUARDA EN LA LISTA DE REPARACIONES AL INTRODUCIR BIEN LOS CAMPOS DE FECHA DE INGRESO Y EL IDREPARACION
		 * CASO2: SE GUARDA EN LA LISTA DE REPARACIONES PAGADAS AL INTRODUCIR BIEN TODOS LOS CAMPOS  --FALTA POR IMPLEMENTAR (AQUI SE GUARDAN TODAS caso1 y caso2 en la misma lista)
		 */
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override //(String idRep, String matriculaRep, Calendar fechaIni, Calendar fechaFin, int idFactura, String averia, String estado)
			public void mouseClicked(MouseEvent arg0) {
					try{
						
						/////////Ojo aki
						ControlReparaciones.Aniadir(txtFldIdReparacion.getText(), txtFldMatricula.getText(), txtFechaIngreso.getText(), txtFechaEntrega.getText(),(String)pagoList.getSelectedValue(),(String)estadoList.getSelectedValue(), txtAreaDescripcion.getText(),0,0);
						JOptionPane.showMessageDialog(null, "Se añadio con exito la descripcion de la reparación para este vehículo", "GUARDAR REPARACION", JOptionPane.INFORMATION_MESSAGE);
					
					}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL AÑADIR LA REPARACIÓN", JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		btnGuardar.setBounds(282, 519, 149, 47);
		getContentPane().add(btnGuardar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {			//SALIMOS DE LA APP
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(537, 519, 149, 47);
		getContentPane().add(btnSalir);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 713, 27);
		getContentPane().add(menuBar);
		
		JMenu mnAadir = new JMenu("Nuevo");
		menuBar.add(mnAadir);
		
		mntmAadir = new JMenuItem("A\u00F1adir reparaci\u00F3n");
		mntmAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			ModoEscritura();
				
				
			}
		});
	
		mnAadir.add(mntmAadir);
		
		mnLeer = new JMenu("Leer");
		menuBar.add(mnLeer);
		
		JMenuItem mntmPendienteDeReparacion = new JMenuItem("Pendiente de Reparacion");
		mntmPendienteDeReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ListaTemporal = ControlReparaciones.listaAverias(matricula);
				indice=0;
				Comprobador();
				
				
			}
		});
		
		JMenuItem mntmFichasTotales = new JMenuItem("Fichas Totales");
		mntmFichasTotales.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ListaTemporal = ControlReparaciones.listaTotal(matricula);
				indice=0;
				Comprobador();
			}
		});
		mnLeer.add(mntmFichasTotales);
		mnLeer.add(mntmPendienteDeReparacion);
		
		JMenuItem mntmReparados = new JMenuItem("Reparados");
		mntmReparados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListaTemporal = ControlReparaciones.listaReparados(matricula);
				indice=0;
				Comprobador();
			}
		});
		mnLeer.add(mntmReparados);
		
		JMenuItem mntmPagados = new JMenuItem("Pagados");
		mntmPagados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListaTemporal = ControlReparaciones.listaPagados(matricula);
				indice=0;
				Comprobador();
			}
		});
		mnLeer.add(mntmPagados);
		
		JMenuItem mntmPendienteDePago = new JMenuItem("Pendiente de Pago");
		mntmPendienteDePago.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListaTemporal = ControlReparaciones.listaPendientesPago(matricula);
				indice=0;
				Comprobador();
			}
		});
		mnLeer.add(mntmPendienteDePago);
		
		panel = new JPanel();
		panel.setBounds(439, 33, 264, 258);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnIzq = new JButton("<");
		btnIzq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(indice+1 > 0){
					indice--;
					RellenarFormulario();
					}else
						JOptionPane.showMessageDialog(null, "Te sales del rango...", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					
			}
		});
		btnIzq.setBounds(10, 6, 87, 48);
		panel.add(btnIzq);
		
		lblDe = new JLabel("0 de 0");
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBounds(107, 20, 54, 17);
		panel.add(lblDe);
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if(ControlReparaciones.Borrar(ListaTemporal.get(indice))){
					ListaTemporal.remove(indice);
					JOptionPane.showMessageDialog(null, "Incidencia eliminada con exito", "ELIMINACION CORRECTA", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "No se encontro la incidencia a eliminar", "ERROR AL ELIMINAR", JOptionPane.ERROR_MESSAGE);
				}

				indice = 0;
				Comprobador();
			}
		});
		btnEliminar.setBounds(10, 60, 244, 128);
		panel.add(btnEliminar);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnDerecha = new JButton(">");
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(indice+1 < ListaTemporal.size()){
				indice++;
				RellenarFormulario();
				}else
					JOptionPane.showMessageDialog(null, "Te sales del rango...", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				
				
				
				
			}
		});
		btnDerecha.setBounds(171, 6, 83, 48);
		panel.add(btnDerecha);
		
		btnReparar = new JButton("REPARAR");
		btnReparar.setBounds(34, 204, 203, 43);
		panel.add(btnReparar);
		btnReparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FichaObra(ListaTemporal.get(indice)).setVisible(true);
			}
		});
		btnReparar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblTotCalculado = new JLabel("TOTAL CUENTA");
		lblTotCalculado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotCalculado.setBounds(537, 301, 149, 24);
		getContentPane().add(lblTotCalculado);
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBounds(523, 353, 141, 39);
		getContentPane().add(txtPrecioTotal);
		
		lblEur = new JLabel("\u20AC");
		lblEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEur.setBounds(667, 364, 46, 14);
		getContentPane().add(lblEur);
		//txtPrecioTotal.setText(String.valueOf(ControlReparaciones.ObtenerPrecio(matricula)));			//INSERTAMOS EL DATO
		
		
		
		Comprobador();
	
	
	
	
	}
	
	/**
	 * Modo Lectura
	 */
	
	private void ModoLectura(){
		
		RellenarFormulario();
		
		
		for(Component i : getContentPane().getComponents()){
			
			i.setEnabled(false);
			
		}
		btnVolver.setEnabled(true);
		btnSalir.setEnabled(true);
		panel.setVisible(true);
			
	}
	
	/**
	 * Modo Escritura
	 */
	
	private void ModoEscritura(){
		for(Component i : getContentPane().getComponents()){
			
			
			
			i.setEnabled(true);
			
			
		}
		txtFldDni.setEnabled(false);
		txtFldMatricula.setEnabled(false);
		panel.setVisible(false);
		txtTipoVehiculo.setEnabled(false);
		
		txtFechaEntrega.setText(null);
		txtFechaIngreso.setText(null);
		txtFldIdReparacion.setText(null);
		
		
		pagoList.setSelectedIndex(0);
		txtAreaDescripcion.setText(null);
		estadoList.setSelectedIndex(0);
		
	}
	
	
	
	
	/**
	 * Comprobador
	 */
	
	private void Comprobador(){
	
	if(ListaTemporal.isEmpty()){
		
		ModoEscritura();
	
	}else{
		
		ModoLectura();
		
		
	}
	}
	/**
	 * Rellenar Formulario
	 */
	
	private void RellenarFormulario(){
		Reparacion aux = ListaTemporal.get(indice);
		Vehiculo aux2 = ControlVehiculos.Obtener(matricula);
		
		txtFechaEntrega.setText(aux.getFechaFin());
		txtFechaIngreso.setText(aux.getFechaIni());
		txtFldIdReparacion.setText(aux.getIdRep());
		txtFldMatricula.setText(aux.getMatriculaRep());
		txtFldDni.setText(aux2.getDnipropietario());
		txtTipoVehiculo.setText(aux2.getTipo());
		pagoList.setSelectedValue(aux.getEstadoPago(),true);
		txtAreaDescripcion.setText(aux.getComentario());
		estadoList.setSelectedValue(aux.getEstadoAveria(), true);
		
		
		lblDe.setText(indice+1 + " de " + ListaTemporal.size());
		
		
		
	}
}
