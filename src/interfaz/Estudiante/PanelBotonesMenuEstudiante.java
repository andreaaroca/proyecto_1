package interfaz.Estudiante;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.Controlador;
import Persistencias.persistenciaLP;


@SuppressWarnings("serial")
public class PanelBotonesMenuEstudiante extends JPanel implements ActionListener {
	
	    private static final String VERLEARNINGPATHSDISPONIBLES = "VER LEARNINGPATHS DISPONIBLES";
	    private static final String INSCRIBIRLEARNINGPATH = "INSCRIBIR LEARNINGPATH";
	    private static final String VERLEARNINGPATHSINSCRITOS = "VER LEARNINGPATHS INSCRITOS";
	    private static final String CREARRESEÑA = "CREAR RESEÑA";

	    private JButton butVerLpDisponibles;
	    private JButton butInscribirLp;
	    private JButton butVerLpInscritos;
	    private JButton butCrearReseña;
	    
	    private VentanaPrincipalMenuEstudiante ventanaPrincipalMenuEstudiante;
	    
	    
	    public PanelBotonesMenuEstudiante( VentanaPrincipalMenuEstudiante ventanaPrincipalMenuEstudiante )
	    {
	    	this.ventanaPrincipalMenuEstudiante = ventanaPrincipalMenuEstudiante;

	        setLayout( new FlowLayout( ) );
	        butVerLpDisponibles = new JButton("VER LEARNINGPATHS DISPONIBLES");
	        butVerLpDisponibles.setActionCommand(VERLEARNINGPATHSDISPONIBLES);
	        butVerLpDisponibles.addActionListener(this);
	        add(butVerLpDisponibles);
	       

	        butInscribirLp = new JButton("INSCRIBIR LEARNINGPATH");
	        butInscribirLp.setActionCommand(INSCRIBIRLEARNINGPATH);
	        butInscribirLp.addActionListener(this);
	        add(butInscribirLp);

	        butVerLpInscritos = new JButton("VER LEARNINGPATHS INSCRITOS");
	        butVerLpInscritos.setActionCommand(VERLEARNINGPATHSINSCRITOS);
	        butVerLpInscritos.addActionListener(this);
	        add(butVerLpInscritos);

	        butCrearReseña = new JButton("CREAR RESEÑA");
	        butCrearReseña.setActionCommand(CREARRESEÑA);
	        butCrearReseña.addActionListener(this);
	        add(butCrearReseña);
	    }


	@Override
	public void actionPerformed(ActionEvent e) {
		persistenciaLP lpControl = new persistenciaLP();
        String comando = e.getActionCommand( );
     // Lógica para cada botón
        if (comando.equals(VERLEARNINGPATHSDISPONIBLES)) {
        	new VentanaLpDisponibles(lpControl);
            System.out.println("Ver LearningPaths disponibles");
        } else if (comando.equals(INSCRIBIRLEARNINGPATH)) {
        	 new VentanaInscribirLp(ventanaPrincipalMenuEstudiante.getLpControl(), ventanaPrincipalMenuEstudiante.getEstudiante());
            System.out.println("Inscribir LearningPath");
        } else if (comando.equals(VERLEARNINGPATHSINSCRITOS)) {
            System.out.println("Ver LearningPaths inscritos");
        } else if (comando.equals(CREARRESEÑA)) {
            System.out.println("Crear reseña");
        }
    }
		
	}



