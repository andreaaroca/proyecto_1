package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.*;

import interfazesGraficasPrimerVentana.VentanaLogin;

public class VentanaGrafica extends JFrame {

	HashMap<String, Integer> mesCantidad;
	//VentanaPrincipalMenuEstudiante vPrincipalEst;
	PanelGrafica pGrafica;
	
	
	public VentanaGrafica(HashMap<String, Integer> mesCantidad) {
		setTitle("Grafica Actividades enviadas en el año");
	    setSize(1000, 500);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible(true);
        setLocationRelativeTo( null );
	    setLayout(new BorderLayout());
	    
	    this.mesCantidad=mesCantidad;
	    
		
		this.pGrafica=new PanelGrafica(mesCantidad);
	    
	    add(pGrafica,BorderLayout.CENTER);
	    
	    
	}
	
	
	
}
