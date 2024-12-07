package interfaz.ProfesorCreador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelBotonesMenuProfesorCreador extends JPanel implements ActionListener{
	
		
	//comit12393748
		    private static final String CREARLEARNINGPATH = "CREAR LEARNINGPATH";
		    private static final String CREARACTIVIDAD = "CREAR ACTIVIDAD";
		    private static final String VERLEARNINGPATHSCREADOS = "VER LEARNINGPATHS CREADOS";
		    private static final String ELIMINARLEARNINGPATH = "ELIMINAR LEARNINGPATH";
		    private static final String SALIRMENUPC = "SALIR";

		    private JButton butCrearLp;
		    private JButton butCrearActividad;
		    private JButton butVerLpCreados;
		    private JButton butEliminarLp;
		    private JButton butSalirMenuPc;
		    
		    private VentanaPrincipalMenuProfesorCreador ventanaPrincipalMenuProfesorCreador;
		    
		    
		    public PanelBotonesMenuProfesorCreador( VentanaPrincipalMenuProfesorCreador ventanaPrincipalMenuProfesorCreador )
		    {
		    	this.ventanaPrincipalMenuProfesorCreador = ventanaPrincipalMenuProfesorCreador;

		        setLayout( new FlowLayout( ) );
		        butCrearLp = new JButton("CREAR LEARNINGPATH");
		        butCrearLp.setActionCommand(CREARLEARNINGPATH);
		        butCrearLp.addActionListener(this);
		        add(butCrearLp);
		       

		        butCrearActividad = new JButton("CREAR ACTIVIDAD");
		        butCrearActividad.setActionCommand(CREARACTIVIDAD);
		        butCrearActividad.addActionListener(this);
		        add(butCrearActividad);

		        butVerLpCreados = new JButton("VER LEARNINGPATHS CREADOS");
		        butVerLpCreados.setActionCommand(VERLEARNINGPATHSCREADOS);
		        butVerLpCreados.addActionListener(this);
		        add(butVerLpCreados);

		        butEliminarLp = new JButton("ELIMINARLEARNINGPATH");
		        butEliminarLp.setActionCommand(ELIMINARLEARNINGPATH);
		        butEliminarLp.addActionListener(this);
		        add(butEliminarLp);
		        
		  
		        butSalirMenuPc = new JButton("SALIR");
		        butSalirMenuPc.setActionCommand(SALIRMENUPC);
		        butSalirMenuPc.addActionListener(this);
		        add(butSalirMenuPc);
		        
		    }


		@Override
		public void actionPerformed(ActionEvent e) {
			
	        String comando = e.getActionCommand( );
	     // Lógica para cada botón

	        if (comando.equals(CREARLEARNINGPATH)) {
	            // Abrir ventana para crear LearningPath
	        	VentanaCrearLp ventanaCrearLp = new VentanaCrearLp(ventanaPrincipalMenuProfesorCreador.getLpControl(), ventanaPrincipalMenuProfesorCreador.getProfesorCreador());
	        	ventanaCrearLp.setVisible(true);
	            
	            System.out.println("CREAR LP");
	        } else if (comando.equals(CREARACTIVIDAD)) {
	            // Abrir ventana para crear Actividad
	        	System.out.println("XXX");
	           
	        } else if (comando.equals(VERLEARNINGPATHSCREADOS)) {
	            // Abrir ventana para ver los LearningPaths creados
	        	System.out.println("XXX");
	        } else if (comando.equals(ELIMINARLEARNINGPATH)) {
	            // Abrir ventana para eliminar un LearningPath
	        	System.out.println("XXX");
	        } else if (comando.equals(SALIRMENUPC)) {
	            ventanaPrincipalMenuProfesorCreador.dispose();
	        }
	  
			
		}





}
