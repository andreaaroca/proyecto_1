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
		    private static final String SALIRMENUPC = "SALIR";

		    private JButton butCalificarAct;
		    private JButton butProgresoLp;
		    private JButton butTiempoAct;
		    private JButton butTiempoLp;
		    private JButton butTasaAct;
		    private JButton butRevisarCompletado;
		    private JButton butGrafica;
		    private JButton butSalirMenuPc;
		    
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
		        
		        butTasaAct = new JButton("Tasa de eito de una actividad");
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
		        add(butTiempoAct);
		        
		  
		        butSalirMenuPc = new JButton("SALIR");
		        butSalirMenuPc.setActionCommand(SALIRMENUPC);
		        butSalirMenuPc.addActionListener(this);
		        add(butSalirMenuPc);
		        
		    }


		@Override
		public void actionPerformed(ActionEvent e) {
			
	        String comando = e.getActionCommand( );
	     // Lógica para cada botón

	        if (comando.equals(CALIFICARACT)) {
	            
	            System.out.println("Calificar Actividad"); }
	            
	        /* else if (comando.equals(PROGRESOLP)) {
	        	//VentanaBotonesCrearTiposActividades ventanaEscogerActividad = new VentanaBotonesCrearTiposActividades(ventanaPrincipalMenuProfesorCreador.getLpControl(), ventanaPrincipalMenuProfesorCreador.getProfesorCreador());
	        	//ventanaEscogerActividad.setVisible(true);
	        	System.out.println("Calificar Actividad");
	        	
	        } else if (comando.equals(VERLEARNINGPATHSCREADOS)) {
	        	//VentanaVerLpCreados ventanaVerCreados = new VentanaVerLpCreados(ventanaPrincipalMenuProfesorCreador,ventanaPrincipalMenuProfesorCreador.getLpControl());
	        	//ventanaVerCreados.setVisible(true);
	        	System.out.println("Calificar Actividad");
	        	
	        } else if (comando.equals(ELIMINARLEARNINGPATH)) {
	        	//VentanaEliminarLp ventanaElimLp = new VentanaEliminarLp(ventanaPrincipalMenuProfesorCreador.getLpControl(), ventanaPrincipalMenuProfesorCreador.getProfesorCreador());
	        	//ventanaElimLp.setVisible(true);
	        	System.out.println("Calificar Actividad");
	        	
	        } else if (comando.equals(SALIRMENUPC)) {
	        	ventanaPrincipalMenuProfesorEvalauador.dispose();
	        }
	  */
			
		} 





}