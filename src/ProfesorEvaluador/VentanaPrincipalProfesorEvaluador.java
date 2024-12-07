package ProfesorEvaluador;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Persistencias.*;
import co.edu.andes.usuarios.Profesor;

public class VentanaPrincipalProfesorEvaluador extends JFrame{
	

	private PanelBotonesMenuProfesorEvaluador panelBotonesMenuProfesorEvaluador;
	private persistenciaLP lpControl;
	persistenciaEstudiante estControl;
	private Profesor profesorEvaluador;

	 public VentanaPrincipalProfesorEvaluador( persistenciaLP lpControl, Profesor profesorEvaluador, persistenciaEstudiante estControl)
	    {
		 
		 	this.lpControl = lpControl;
		 	this.estControl = estControl;
		 	this.profesorEvaluador = profesorEvaluador;
	        
	        
	    
	        
		 	setTitle("Menú Profesor Evaluador");
	        setLayout(new BorderLayout());


	        panelBotonesMenuProfesorEvaluador = new PanelBotonesMenuProfesorEvaluador(this); 
	        add(panelBotonesMenuProfesorEvaluador, BorderLayout.CENTER);

	        pack( );
	        setLocationRelativeTo( null );
	        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	        setResizable( false );
	        setVisible(true);
	 
	        setSize(500, 300); 
	       
	        setLocationRelativeTo(null); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE); 
	        setResizable(false);
	        setVisible(true);
	    }
	 public persistenciaLP getLpControl() {
		    return lpControl;
		}
	 public Profesor getProfesorEvaluador() {
		    return profesorEvaluador;
		}
	 
}