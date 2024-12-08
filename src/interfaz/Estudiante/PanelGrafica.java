package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class PanelGrafica extends JPanel {
	
	HashMap<String, Integer> mesCantidad;
	public PanelGrafica(HashMap<String, Integer> mesCantidad) {
		this.mesCantidad=mesCantidad;
		
	}
	
	@Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;
        
        int x1=0;
        
        
        
        for(String mes:mesCantidad.keySet()) {
	    	g2d.drawRect(x1, 50, 50, (((mesCantidad.get(mes))*10)+50));
	    	g2d.drawString(mes, x1, 20);
	    	g2d.drawString((mesCantidad.get(mes)).toString(), x1, 35);
	    	x1=x1+70;
	    	
	    	
        }
        	
        repaint();
    }

}
