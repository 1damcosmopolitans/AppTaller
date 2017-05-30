package Gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Models.Reparacion;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;

public class FichaObra extends JFrame{

	private JLabel lblFichaObra ;
	private JTextField textID;
	private JTextField textTiempo;
	private JTextField textPiezas;
	private JTextField textPrecio;
	private JButton btnIniRep;
	private JButton btnFinRep;
	private JButton btnGuardar;
	private JList listAveria;
	private boolean controlContador;
	private Reparacion reparacion;
	private JLabel lblSegundos;
	private JLabel lblSegs;
	private JPanel panelGuardar;
	private Thread contador;

	private final float precioMin = 1.50f;
	/**
	 * Create the application.
	 */
	public FichaObra(Reparacion rep) {
		getContentPane().setBackground(new Color(102, 153, 204));
		reparacion = rep;
		controlContador = true;
		contador = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 823, 567);
		getContentPane().setLayout(null);
		
		lblFichaObra = new JLabel("FICHA OBRA");
		lblFichaObra.setBounds(286, 11, 280, 36);
		lblFichaObra.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblFichaObra);
		getContentPane().add(lblFichaObra);
		
		JLabel lblTpoInvertido = new JLabel("TIEMPO INVERTIDO");
		lblTpoInvertido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTpoInvertido.setBounds(25, 175, 160, 27);
		getContentPane().add(lblTpoInvertido);
		
		JLabel lblIdReparacion = new JLabel("ID REPARACION");
		lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdReparacion.setBounds(25, 107, 141, 27);
		getContentPane().add(lblIdReparacion);
		
		JLabel lblCostePiezas = new JLabel("COSTE PIEZAS");
		lblCostePiezas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCostePiezas.setBounds(25, 248, 141, 27);
		getContentPane().add(lblCostePiezas);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(25, 345, 95, 27);
		getContentPane().add(lblTotal);
		
		textID = new JTextField();
		textID.setEnabled(false);
		textID.setBounds(195, 110, 218, 25);
		getContentPane().add(textID);
		textID.setColumns(10);
		
		textTiempo = new JTextField();
		textTiempo.setEnabled(false);
		textTiempo.setColumns(10);
		textTiempo.setBounds(195, 178, 218, 25);
		getContentPane().add(textTiempo);
		
		textPiezas = new JTextField();
		textPiezas.setColumns(10);
		textPiezas.setBounds(195, 248, 218, 25);
		getContentPane().add(textPiezas);
		
		textPrecio = new JTextField();
		textPrecio.setEnabled(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(125, 345, 218, 25);
		getContentPane().add(textPrecio);
		
		btnIniRep = new JButton("INICIO");
		btnIniRep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				controlContador = true;
				lblSegundos.setVisible(true);
				lblSegs.setVisible(true);
				contador = new Thread(new Runnable(){
					@Override
					public void run() {
						int segundos = Integer.parseInt(lblSegundos.getText());
						int min = Integer.parseInt(textTiempo.getText());
						
						while(controlContador){
							try{
							Thread.sleep(1000);
							}catch(Exception e){}
							segundos++;
							lblSegundos.setText("" + segundos);
							if(segundos>=60){
								segundos=0;
								min++;
								textTiempo.setText("" + min);
							}
						}
						
						JOptionPane.showMessageDialog(null, "Contador finalizado con exito!", "Contador", JOptionPane.INFORMATION_MESSAGE);
						
				}
				});
				contador.start();
				
				for(Component i: panelGuardar.getComponents()){
					i.setEnabled(false);
				}
			}
		});
		btnIniRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniRep.setBounds(507, 99, 203, 43);
		getContentPane().add(btnIniRep);
		
		btnFinRep = new JButton("FINALIZAR");
		btnFinRep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlContador = false;
				
				for(Component i: panelGuardar.getComponents()){
					i.setEnabled(true);
				}
			}
		});
		btnFinRep.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinRep.setBounds(507, 175, 203, 43);
		getContentPane().add(btnFinRep);
		
		textID.setText(reparacion.getIdRep());
		textTiempo.setText("" + reparacion.getTiempo());
		textPrecio.setText("" + reparacion.getPrecio());
		
		lblSegundos = new JLabel("0");
		lblSegundos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundos.setBounds(342, 214, 40, 14);
		lblSegundos.setVisible(false);
		getContentPane().add(lblSegundos);
		
		lblSegs = new JLabel("segs");
		lblSegs.setBounds(386, 214, 46, 14);
		lblSegs.setVisible(false);
		getContentPane().add(lblSegs);
		
		panelGuardar = new JPanel();
		panelGuardar.setBounds(507, 237, 203, 229);
		getContentPane().add(panelGuardar);
		panelGuardar.setLayout(null);
		
		JButton btnCalcularPrecio = new JButton("CALCULAR PRECIO");
		btnCalcularPrecio.setBounds(0, 0, 203, 42);
		panelGuardar.add(btnCalcularPrecio);
		btnCalcularPrecio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				float precioPiezas = Float.parseFloat(textPiezas.getText());
				int tiempoMin = Integer.parseInt(textTiempo.getText());
				textPrecio.setText("" + (precioPiezas + (float)(tiempoMin*precioMin)));
				JOptionPane.showMessageDialog(null, "Precio calculado con éxito", "CALCULAR PRECIO", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error algún campo es incorrecto", "ERROR CALCULAR PRECIO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalcularPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		listAveria = new JList();
		listAveria.setBounds(39, 49, 147, 118);
		panelGuardar.add(listAveria);
		listAveria.setModel(new AbstractListModel() {
			String[] values = new String[] {"Inicial", "Intermedio", "Avanzado", "Reparado"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAveria.setSelectedIndex(0);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(0, 178, 203, 51);
		panelGuardar.add(btnGuardar);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				reparacion.setEstadoAveria((String)listAveria.getSelectedValue());
				reparacion.incPrecio(Float.parseFloat(textPrecio.getText()));
				reparacion.incTiempo(Integer.parseInt(textTiempo.getText()));
				JOptionPane.showMessageDialog(null, "Cambios guardados con éxito", "Obra", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		listAveria.setSelectedValue(reparacion.getEstadoAveria(), true);
		
	}
}
