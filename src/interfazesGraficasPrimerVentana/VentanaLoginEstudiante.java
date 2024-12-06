package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import co.edu.andes.sistema.*;

public class VentanaLoginEstudiante extends JFrame implements ActionListener {

	private static final String REGISTRAR ="Resgistrar";
    private static final String INICIAR = "Iniciar";
    private static final String MOSTRAR = "Mostrar";
    private static final String SALIR = "Salir";

    private JButton butRegistrar;
    private JButton butIniciar;
    private JButton butMostrar;
    private JButton butSalir;
    
    private GestorUsuarios sistema;
    private JPanel panelBut;
    private VentanaRegistrarE ventanaRegistrarE;
    private VentanaIniciarE ventanaIniciarE;
    private VentanaArchivoUsuarios ventanaArchivoUsuarios;
    

    public  VentanaLoginEstudiante()
    {
        
        
        
        setLayout( new BorderLayout() );
        
        
        panelBut=new JPanel();
        panelBut.setLayout(new GridLayout(4,1));
        
        		

        butRegistrar = new JButton("Registrar");
        butRegistrar.addActionListener(this);
        butRegistrar.setActionCommand(REGISTRAR);
        panelBut.add(butRegistrar);

        butIniciar = new JButton("Iniciar Sesion");
        butIniciar.addActionListener(this);
        butIniciar.setActionCommand(INICIAR);
        panelBut.add(butIniciar);
        
        butMostrar = new JButton("Mostrar Ususarios en el Archivo");
        butMostrar.addActionListener(this);
        butMostrar.setActionCommand(MOSTRAR);
        panelBut.add(butMostrar);
        
        butSalir = new JButton("Salir");
        butSalir.addActionListener(this);
        butSalir.setActionCommand(SALIR);
        panelBut.add(butSalir);
        
        add(panelBut,BorderLayout.CENTER);
        
        setTitle( "Grupo 2 Proyecto Learning Paths" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 400, 600 );
        setLocationRelativeTo( null );
        setVisible( true );
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( REGISTRAR ))
        {
        	
            mostrarVetanaRegistrarE( );
        }
        
        else if( comando.equals( INICIAR ))
        {
            mostrarVetanaIniciarSesionE( );
        }
        
        else if( comando.equals( MOSTRAR ))
        {
        	mostrarVetanaArchivoUsuarios( );
        }
        
        else if( comando.equals( SALIR ))
        {
        	this.dispose();
        }
    }
    
    public void mostrarVetanaRegistrarE( )
    {
        if( ventanaRegistrarE == null || !ventanaRegistrarE.isVisible( ) )
        {
            ventanaRegistrarE = new VentanaRegistrarE();
            ventanaRegistrarE.setVisible( true );
        }
    }
    
    public void mostrarVetanaIniciarSesionE( )
    {
        if( ventanaIniciarE == null || !ventanaIniciarE.isVisible( ) )
        {
            ventanaIniciarE = new VentanaIniciarE();
            ventanaIniciarE.setVisible( true );
        }
    }
    
    public void mostrarVetanaArchivoUsuarios( )
    {
        if( ventanaArchivoUsuarios == null || !ventanaArchivoUsuarios.isVisible( ) )
        {
            ventanaArchivoUsuarios = new VentanaArchivoUsuarios( this);
            ventanaArchivoUsuarios.setVisible( true );
        }
    }
    
    
    
   

	public static void main( String[] args )
    {
        new VentanaLoginEstudiante();
}
}
	


