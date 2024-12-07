package interfaz.ProfesorCreador;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Profesor;

public class VentanaPrincipalMenuProfesorCreador extends JFrame{
	

	private PanelBotonesMenuProfesorCreador panelBotonesMenuProfesorCreador;
	private persistenciaLP lpControl;
	private Profesor profesorCreador;

	 public VentanaPrincipalMenuProfesorCreador( persistenciaLP lpControl, Profesor profesorCreador)
	    {
		 
		 	this.lpControl = lpControl;
		 	this.profesorCreador = profesorCreador;
	        
	        
	    
	        
		 	setTitle("Menú Profesor Creador");
	        setLayout(new BorderLayout());


	        panelBotonesMenuProfesorCreador = new PanelBotonesMenuProfesorCreador(this); 
	        add(panelBotonesMenuProfesorCreador, BorderLayout.CENTER);

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
	 public Profesor getProfesorCreador() {
		    return profesorCreador;
		}

		
	 /*public static void main(String[] args) {
		 persistenciaLP lpControl = new persistenciaLP(); 
		 Profesor profesorCreador = new Profesor("Andrea", "AndreaProfesor", "password123", "Profesor"); 
		 
	        new VentanaPrincipalMenuProfesorCreador(lpControl, profesorCreador);
		
	    }*/
	}