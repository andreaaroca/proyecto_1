package interfaz.ProfesorCreador;

import javax.swing.*;

import Persistencias.persistenciaLP;
import co.edu.andes.usuarios.Profesor;
import interfazesGraficasPrimerVentana.VentanaRegistrar;

import java.awt.*;
import java.awt.event.*;



public class VentanaBotonesCrearTiposActividades extends JFrame implements ActionListener {
	
	private static final String TAREA = "TAREA";
    private static final String ENCUESTA = "ENCUESTA";
    private static final String RECURSO = "RECURSO";
    private static final String EXAMEN = "EXAMEN";
    private static final String QUIZ = "QUIZ";

    private JButton butCrearTarea;
    private JButton butCrearEncuesta;
    private JButton butCrearRecurso;
    private JButton butCrearExamen;
    private JButton butCrearQuiz;
    private JPanel pBut;
    private VentanaCrearAcividad vCA;
    private persistenciaLP persistenciaLP;
    private Profesor profesorCreador;
    
	
	public VentanaBotonesCrearTiposActividades(persistenciaLP persistenciaLP, Profesor profesorCreador) {
		
		setTitle("Escoger Actividad a Crear");
	    setSize(400, 500);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
		this.persistenciaLP = persistenciaLP;
		this.profesorCreador = profesorCreador;
		setLayout(new BorderLayout());
		JPanel pBut=new JPanel();
		pBut.setLayout( new FlowLayout( ) );
        butCrearTarea = new JButton("CREAR TAREA");
        butCrearTarea.addActionListener(this);
        butCrearTarea.setActionCommand(TAREA);
        pBut.add(butCrearTarea);
       

        butCrearEncuesta = new JButton("CREAR ENCUESTA");
        butCrearEncuesta.addActionListener(this);
        butCrearEncuesta.setActionCommand(ENCUESTA);
        pBut.add(butCrearEncuesta);
        
        butCrearRecurso = new JButton("CREAR REVISION DE RECURSO");
        butCrearRecurso.addActionListener(this);
        butCrearRecurso.setActionCommand(RECURSO);
        pBut.add(butCrearRecurso);

        butCrearExamen = new JButton("CREAR EXAMEN");
        butCrearExamen.addActionListener(this);
        butCrearExamen.setActionCommand(EXAMEN);
        pBut.add(butCrearExamen);
        
        butCrearQuiz = new JButton("CREAR QUIZ");
        butCrearQuiz.addActionListener(this);
        butCrearQuiz.setActionCommand(QUIZ);
        pBut.add(butCrearQuiz);
        
        add(pBut,BorderLayout.CENTER);
	}

	public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( TAREA ))
        {
        	JLabel ejercicio= new JLabel("Ejercicio: ");
        	JTextField txtEjercicio = new JTextField();
        	
        	mostrarVetanaCrearAcividad( );
            vCA.anadirTarea(ejercicio,txtEjercicio);
            this.dispose();
        }
        
        else if( comando.equals( ENCUESTA))
        {
        	
        	mostrarVetanaCrearAcividad( );
            vCA.anadirEncuesta();
            this.dispose();
        }
        
        else if( comando.equals( RECURSO ))
        {
        	JLabel recurso= new JLabel("Enlace de recurso a revisar: ");
        	JTextField txtRecurso = new JTextField();
        	
        	mostrarVetanaCrearAcividad( );
            vCA.anadirRecurso(recurso,txtRecurso);
            
            this.dispose();
        }
        
        else if( comando.equals( EXAMEN ))
        {
        	JLabel nota= new JLabel("Nota para Aprobar (con un valor decimal): ");
        	JTextField txtnota = new JTextField();
        	
        	mostrarVetanaCrearAcividad( );
            vCA.anadirExamen(nota,txtnota);
        }
        
        else if( comando.equals( QUIZ ))
        {
        	JLabel nota= new JLabel("Nota para Aprobar (con un valor decimal): ");
        	JTextField txtnota = new JTextField();
        	
        	mostrarVetanaCrearAcividad( );
            vCA.anadirQuiz(nota,txtnota);
        }
    }

	public void mostrarVetanaCrearAcividad( )
    {
        if( vCA == null || !vCA.isVisible( ) )
        {
            vCA = new VentanaCrearAcividad(persistenciaLP,profesorCreador);
            vCA.setVisible( true );
        }
    }
}
