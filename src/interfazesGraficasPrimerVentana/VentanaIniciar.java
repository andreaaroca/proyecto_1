package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controlador.Controlador;
import co.edu.andes.sistema.*;
import co.edu.andes.usuarios.Estudiante;
import interfaz.Estudiante.*;
import Persistencias.*;

public class VentanaIniciar extends JFrame implements ActionListener{

	private PanelIniciar pIniciar;
	private JButton butIniciarE;
	private JButton butIniciarPC;
	private JButton butIniciarPE;
	private JPanel butSur;
	private VentanaPrincipalMenuEstudiante ventanaEstudiante;
	
	
	private static final String INICIARE = "Iniciar Sesion Estudiante";
	private static final String INICIARPC = "Iniciar Sesion Profesor Creador";
	private static final String INICIARPE = "Iniciar Sesion Profesro Evaluador";

	
	public VentanaIniciar() {
		this.pIniciar=new PanelIniciar();
		setLayout(new BorderLayout());
		JPanel butSur=new JPanel();
		butSur.setLayout(new FlowLayout());
		
		butIniciarE = new JButton("Iniciar Sesion Estudiante");
        butIniciarE.addActionListener(this);
        butIniciarE.setActionCommand(INICIARE);
        butSur.add(butIniciarE);
        
        butIniciarPC = new JButton("Iniciar Sesion Profesor Creador");
        butIniciarPC.addActionListener(this);
        butIniciarPC.setActionCommand(INICIARPC);
        butSur.add(butIniciarPC);
        
        butIniciarPE = new JButton("Iniciar Sesion Profesor Evaluador");
        butIniciarPE.addActionListener(this);
        butIniciarPE.setActionCommand(INICIARPE);
        butSur.add(butIniciarPE);
        
        add(pIniciar,BorderLayout.CENTER);
        add(butSur,BorderLayout.SOUTH);
        
		
        setTitle("Iniciar Sesion Usuario");
		pack();
        setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	}
	
	
	
       
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
	        String comando = e.getActionCommand( );
	        if( comando.equals( INICIARE ))
	        {
	       
	        	GestorUsuarios sistema=new GestorUsuarios();
	        	sistema.cargarUsuariosDesdeArchivo();
	        	persistenciaLP perLp= new persistenciaLP();
	            String nombreU=pIniciar.getNombreUsuario();
	            String contrasena=pIniciar.getContrasena();
	            String tipoUsuario = sistema.iniciarSesion(nombreU, contrasena);
	            System.out.println(tipoUsuario);
	            
	            if (tipoUsuario != null) {
	                System.out.println("Inicio de sesión exitoso como: " + tipoUsuario);
	                
	                Object usuario = sistema.obtenerUsuario(nombreU);
	                
	                if (tipoUsuario.equals("Estudiante") && usuario instanceof Estudiante) {
	                    System.out.println("Opciones para estudiante:");
	                    Estudiante estudiante = (Estudiante) usuario; 
	                    mostrarVentanaEstudiante(estudiante,perLp);
	                } else {
	                    System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
	                }
	            } else {
	                System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
	            }
	        }
	            this.dispose();
	        }
	    
	    public void mostrarVentanaEstudiante(Estudiante estudiante, persistenciaLP perLp  )
	    {
	        if( ventanaEstudiante == null || !ventanaEstudiante.isVisible( ) )
	        {
	            ventanaEstudiante = new VentanaPrincipalMenuEstudiante (perLp,estudiante);
	            ventanaEstudiante.setVisible( true );
	        }
	    }
	    
}



