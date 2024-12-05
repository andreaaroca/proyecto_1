package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controlador.Controlador;
import co.edu.andes.sistema.*;
import co.edu.andes.usuarios.Estudiante;

public class VentanaIniciarE extends JFrame implements ActionListener{

	private PanelIniciar pIniciar;
	private JButton butIniciarE;
	//private VentanaPrincipalMenuEstudiante ventanaEstudiante; 
	
	private static final String INICIARE = "Iniciar Sesion Estudiante";

	
	public VentanaIniciarE() {
		this.pIniciar=new PanelIniciar();
		setLayout(new BorderLayout());
		add(pIniciar,BorderLayout.CENTER);
		
		butIniciarE = new JButton("Registrar Estudiante en la plataforma");
        butIniciarE.addActionListener(this);
        butIniciarE.setActionCommand(INICIARE);
        add(butIniciarE,BorderLayout.SOUTH);
		
        setTitle("Iniciar Sesion Estudiante");
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
        	
        	
        }
        
    }
       
	   /* @Override
	    public void actionPerformed( ActionEvent e )
	    {
	        String comando = e.getActionCommand( );
	        if( comando.equals( INICIARE ))
	        {
	       
	        	GestorUsuarios sistema = new GestorUsuarios();
	            String nombreU=pIniciar.getNombreUsuario();
	            String contrasena=pIniciar.getContrasena();
	            GestorUsuarios sistema1 = new GestorUsuarios();
	            String tipoUsuario = sistema1.iniciarSesion(nombreU, contrasena);
	            
	            if (tipoUsuario != null) {
	                System.out.println("Inicio de sesión exitoso como: " + tipoUsuario);
	                
	                Object usuario = sistema1.obtenerUsuario(nombreU);
	                
	                if (tipoUsuario.equals("Estudiante") && usuario instanceof Estudiante) {
	                    System.out.println("Opciones para estudiante:");
	                    Estudiante estudiante = (Estudiante) usuario; 
	                    mostrarVentanaEstudiante();
	                } else {
	                    System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
	                }
	            } else {
	                System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
	            }
	        }
	            this.dispose();
	        }
	    
	    public void mostrarVentanaEstudiante( )
	    {
	        if( ventanaEstudiante == null || !ventanaEstudiante.isVisible( ) )
	        {
	            ventanaEstudiante = new VentanaPrincipalMenuEstudiante ();
	            ventanaEstudiante.setVisible( true );
	        }
	    }*/
	    
}



