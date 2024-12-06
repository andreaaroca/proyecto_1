package interfaz.Estudiante;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Estudiante;


@SuppressWarnings("serial")
public class VentanaPrincipalMenuEstudiante extends JFrame{
	
	private PanelBotonesMenuEstudiante panelBotonesMenuEstudiante;
	private persistenciaLP lpControl;
	private Estudiante estudiante;

	 public VentanaPrincipalMenuEstudiante( persistenciaLP lpControl, Estudiante estudiante)
	    {
		 
		 	this.lpControl = lpControl;
	        this.estudiante = estudiante;
	        
	    
	        
		 	setTitle("Menú Estudiante");
	        setLayout(new BorderLayout());

	    
	        panelBotonesMenuEstudiante = new PanelBotonesMenuEstudiante(this); 
	        add(panelBotonesMenuEstudiante, BorderLayout.CENTER);

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

		public Estudiante getEstudiante() {
		    return estudiante;
		}
	
	 public static void main(String[] args) {
		 persistenciaLP lpControl = new persistenciaLP(); 
		 Estudiante estudiante = new Estudiante("Andrea", "Andrea123", "password123", "Estudiante"); // Ejemplo de inicialización
		 
	        new VentanaPrincipalMenuEstudiante(lpControl, estudiante);
	    }
	}


