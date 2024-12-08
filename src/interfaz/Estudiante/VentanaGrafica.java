package interfaz.Estudiante;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.*;

import interfazesGraficasPrimerVentana.VentanaLogin;

public class VentanaGrafica extends JFrame {

	HashMap<String, Integer> mesCantidad;
	//VentanaPrincipalMenuEstudiante vPrincipalEst;
	PanelGrafica pGrafica;
	
	public VentanaGrafica() {
		setTitle("Grafica Actividades enviadas en el año");
	    setSize(1000, 500);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible(true);
        setLocationRelativeTo( null );
	    setLayout(new BorderLayout());
	    
	    HashMap<String, Integer> mesCantidad=new HashMap<String,Integer>();
	    mesCantidad.put("Enero", 10);
		mesCantidad.put("Febrero", 8);
		mesCantidad.put("Marzo", 3);
		mesCantidad.put("Abril", 15);
		mesCantidad.put("Mayo", 20);
		mesCantidad.put("Junio", 3);
		mesCantidad.put("Julio", 7);
		mesCantidad.put("Agosto", 9);
		mesCantidad.put("Septiembre", 23);
		mesCantidad.put("Octubre", 2);
		mesCantidad.put("Noviembre", 4);
		mesCantidad.put("Diciembre", 11);
		
		this.pGrafica=new PanelGrafica(mesCantidad);
	    
	    add(pGrafica,BorderLayout.CENTER);
	    
	    
	}
	public static void main( String[] args )
    {
        new VentanaGrafica();
    }
	
}
