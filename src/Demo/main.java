package Demo;

import Models.*;

import java.awt.EventQueue;

import javax.swing.UIManager;

import Gui.*;

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					LoginApp window = new LoginApp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		Runnable Runner = new Runnable() {
			public void run() {
				/**
				 * Aqui instanciamos los objetos para arrancar la Aplicación
				 */

			}
		};

	}


