package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controlador.Controlador;
import co.edu.andes.sistema.*;

public class VentanaRegistrar extends JFrame implements ActionListener {
	
	
	private PanelRegistrar pRegistrar;
	private JButton butRegistrarE;
	private JButton butRegistrarPC;
	private JButton butRegistrarPE;
	private JPanel butSur;
	
	private static final String REGISTRARE = "Registrar Estudiante";
	private static final String REGISTRARPC = "Registrar Profesor Creador";
	private static final String REGISTRARPE = "Registrar Profesor Evaluador";
	
	public VentanaRegistrar() {
		
		this.pRegistrar=new PanelRegistrar();
		setLayout(new BorderLayout());
		add(pRegistrar,BorderLayout.CENTER);
		
		JPanel butSur=new JPanel();
		butSur.setLayout(new FlowLayout());
		
		butRegistrarE = new JButton("Registrar Estudiante");
        butRegistrarE.addActionListener(this);
        butRegistrarE.setActionCommand(REGISTRARE);
        butSur.add(butRegistrarE);
        
        butRegistrarPC = new JButton("Registrar Profesor Creador");
        butRegistrarPC.addActionListener(this);
        butRegistrarPC.setActionCommand(REGISTRARPC);
        butSur.add(butRegistrarPC);
        
        butRegistrarPE = new JButton("Registrar Profesor Evaluador");
        butRegistrarPE.addActionListener(this);
        butRegistrarPE.setActionCommand(REGISTRARPE);
        butSur.add(butRegistrarPE);
        
        add(butSur,BorderLayout.SOUTH);
		
        setTitle("Registrar Usuario");
        pack();
        setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	}
		
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
	        String comando = e.getActionCommand( );
	        if( comando.equals( REGISTRARE ))
	        {
	        	GestorUsuarios sistema = new GestorUsuarios();
	            String nombre=pRegistrar.getNombre();
	            String nombreU=pRegistrar.getNombreUsuario();
	            String contrasena=pRegistrar.getContrasena();
	            Controlador.crearEstudiante(nombre, nombreU, contrasena, sistema);
	            this.dispose();
	        }
	       
	        if( comando.equals( REGISTRARPC )||comando.equals( REGISTRARPE ))
	        {
	        	GestorUsuarios sistema = new GestorUsuarios();
	            String nombre=pRegistrar.getNombre();
	            String nombreU=pRegistrar.getNombreUsuario();
	            String contrasena=pRegistrar.getContrasena();
	            Controlador.crearProfesor(nombre, nombreU, contrasena, sistema);
	            this.dispose();
	        }
	}

}
