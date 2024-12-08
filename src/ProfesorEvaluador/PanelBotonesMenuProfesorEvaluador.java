package ProfesorEvaluador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class PanelBotonesMenuProfesorEvaluador extends JPanel implements ActionListener{
	
		
		    private static final String CALIFICARACT= "CALIFICAR ACTIVIDAD";
		    private static final String PROGRESOLP = "PROGRESO LP";
		    private static final String TIEMPOACT = "TIEMPO ACTIVIDAD";
		    private static final String TIEMPOLP = "TIEMPO LP";
		    private static final String TASAACT = "TASA DE EXITO ACTIVIDAD";
		    private static final String REVISARCOMPLETADO = "REVISARCOMPLETADO";
		    private static final String GRAFICA = "GRAFICA";
		    private static final String SALIRMENUPE = "SALIR";

		    private JButton butCalificarAct;
		    private JButton butProgresoLp;
		    private JButton butTiempoAct;
		    private JButton butTiempoLp;
		    private JButton butTasaAct;
		    private JButton butRevisarCompletado;
		    private JButton butGrafica;
		    private JButton butSalirMenuPe;
		    
		    private VentanaPrincipalProfesorEvaluador ventanaPrincipalMenuProfesorEvalauador;
		    
		    
		    
		    public PanelBotonesMenuProfesorEvaluador( VentanaPrincipalProfesorEvaluador ventanaPrincipalMenuProfesorEvalauador )
		    {
		    	this.ventanaPrincipalMenuProfesorEvalauador  = ventanaPrincipalMenuProfesorEvalauador ;

		        setLayout( new FlowLayout( ) );
		        butCalificarAct = new JButton("Calificar/Marcar Completa Actividad");
		        butCalificarAct.setActionCommand(CALIFICARACT);
		        butCalificarAct.addActionListener(this);
		        add(butCalificarAct);
		       

		        butProgresoLp = new JButton("Ver progreso de un estudiante en un LP");
		        butProgresoLp.setActionCommand(PROGRESOLP);
		        butProgresoLp.addActionListener(this);
		        add(butProgresoLp);

		        butTiempoAct = new JButton("Tiempo tomado por Actividad");
		        butTiempoAct.setActionCommand(TIEMPOACT);
		        butTiempoAct.addActionListener(this);
		        add(butTiempoAct);

		        butTiempoLp = new JButton("Tiempo tomado por LP");
		        butTiempoLp.setActionCommand(TIEMPOLP);
		        butTiempoLp.addActionListener(this);
		        add(butTiempoLp);
		        
		        butTasaAct = new JButton("Tasa de exito de una actividad");
		        butTasaAct.setActionCommand(TASAACT);
		        butTasaAct.addActionListener(this);
		        add(butTasaAct);
		        
		        butRevisarCompletado = new JButton("Revisar si una actividad ha sido completada");
		        butRevisarCompletado.setActionCommand(REVISARCOMPLETADO);
		        butRevisarCompletado.addActionListener(this);
		        add(butTiempoAct);
		        
		        butGrafica = new JButton("Grafica actividades durante el año");
		        butRevisarCompletado.setActionCommand(GRAFICA);
		        butRevisarCompletado.addActionListener(this);
		        add(butGrafica);
		        
		  
		        butSalirMenuPe = new JButton("SALIR");
		        butSalirMenuPe.setActionCommand(SALIRMENUPE);
		        butSalirMenuPe.addActionListener(this);
		        add(butSalirMenuPe);
		        
		    }


		@Override
		public void actionPerformed(ActionEvent e) {
			
	        String comando = e.getActionCommand( );
	     // Lógica para cada botón

	        if (comando.equals(CALIFICARACT)) {
	            
	        	VentanaCalificarActividad ventanaCalificarAct = new VentanaCalificarActividad(ventanaPrincipalMenuProfesorEvalauador);
	        	ventanaCalificarAct.setVisible(true);
	            System.out.println("Calificar Actividad"); }
	            
	        else if (comando.equals(PROGRESOLP)) {
	        	 VentanaRevisarProgresoLP ventanaProgresoLP = new VentanaRevisarProgresoLP(ventanaPrincipalMenuProfesorEvalauador);
	             ventanaProgresoLP.setVisible(true);
	             System.out.println("Revisar Progreso Learning Path");
	        }
	             
	       else if (comando.equals(TASAACT)) {
	    	
	            VentanaTasaExitoActividad ventanaTasaExito = new VentanaTasaExitoActividad(ventanaPrincipalMenuProfesorEvalauador);
	                ventanaTasaExito.setVisible(true);
	                 	 
			} else if (comando.equals(TIEMPOACT)) {
			    VentanaTiempoActividad ventanaTiempoActividad = new VentanaTiempoActividad(ventanaPrincipalMenuProfesorEvalauador);
			    ventanaTiempoActividad.setVisible(true);
			    System.out.println("Tiempo Dedicado a Actividad");
			} else if (comando.equals(TIEMPOLP)) {
			    VentanaTiempoLearningPath ventanaTiempoLP = new VentanaTiempoLearningPath(ventanaPrincipalMenuProfesorEvalauador);
			    ventanaTiempoLP.setVisible(true);
			    System.out.println("Tiempo Dedicado a Learning Path");
			}
	        
		else if (comando.equals(SALIRMENUPE)) {
			 ventanaPrincipalMenuProfesorEvalauador.dispose();
		}
		}
}
				
	        	
			
		



