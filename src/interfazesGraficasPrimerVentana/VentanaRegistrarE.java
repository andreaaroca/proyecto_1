package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controlador.Controlador;
import co.edu.andes.sistema.*;

public class VentanaRegistrarE extends JFrame implements ActionListener {
	
	
	private PanelRegistrar pRegistrar;
	private JButton butRegistrarE;
	
	private static final String REGISTRARE = "Registrar Estudiante";

	public VentanaRegistrarE() {
		
		this.pRegistrar=new PanelRegistrar();
		setLayout(new BorderLayout());
		add(pRegistrar,BorderLayout.CENTER);
		
		butRegistrarE = new JButton("Registrar Estudiante en la plataforma");
        butRegistrarE.addActionListener(this);
        butRegistrarE.setActionCommand(REGISTRARE);
        add(butRegistrarE,BorderLayout.SOUTH);
		
        setTitle("Registrar Estudiante");
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
	}

}
