package Gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Taller extends JPanel{

public void paintComponent(Graphics e){
	
	Dimension tam=getSize();
	
	ImageIcon imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/taller.jpg")).getImage());
	e.drawImage(imagen.getImage(), 0, 0, tam.width,tam.height,null);
}

}
