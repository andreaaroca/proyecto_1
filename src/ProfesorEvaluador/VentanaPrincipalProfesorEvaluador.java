package ProfesorEvaluador;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import Actividades.Actividad;
import Actividades.Encuesta;
import Actividades.Quiz;
import LearningPath.LearningPath;
import LearningPath.MonitoreoActividad;
import LearningPath.MonitoreoLearningPath;
import Persistencias.*;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import interfaz.Estudiante.VentanaCasoPruebaGrafica;
import co.edu.andes.sistema.*;

public class VentanaPrincipalProfesorEvaluador extends JFrame{
	

	private PanelBotonesMenuProfesorEvaluador panelBotonesMenuProfesorEvaluador;
	private persistenciaLP lpControl;
	private persistenciaEstudiante estControl;
	private Profesor profesorEvaluador;
	private GestorUsuarios sistema;
	
	 public VentanaPrincipalProfesorEvaluador( persistenciaLP lpControl, Profesor profesorEvaluador, persistenciaEstudiante estControl, GestorUsuarios sistema)
	    {
		 
		 	this.lpControl = lpControl;
		 	this.estControl = estControl;
		 	this.profesorEvaluador = profesorEvaluador;
		 	this.sistema=sistema;
	        
	    
	        
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
	 
	 public persistenciaEstudiante getEstControl() {
		    return estControl;
		}
	 public GestorUsuarios getSistema() {
		    return sistema;
		}

	 
	
	
}