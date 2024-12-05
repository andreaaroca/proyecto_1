package interfazesGraficasPrimerVentana;

import javax.swing.*;

import java.awt.*;
import java.util.List;

import co.edu.andes.sistema.*;

import Controlador.Controlador;

public class VentanaArchivoUsuarios extends JFrame {
	
	private JTextArea areaUsuarios;
	private GestorUsuarios usuariosControl;
	private VentanaLoginEstudiante ventanaLoginE;
	
	public VentanaArchivoUsuarios(VentanaLoginEstudiante ventanaLoginE) {
	
		this.usuariosControl=new GestorUsuarios();
		this.ventanaLoginE=ventanaLoginE;
			
		setTitle("Usuarios Registrados");
	    setSize(400, 300);
	    setLayout(new BorderLayout());
	    
	
	    areaUsuarios = new JTextArea();
	    areaUsuarios.setEditable(false); 
	    add(new JScrollPane(areaUsuarios), BorderLayout.CENTER);
	
	    String usuarios = Controlador.mostrarUsuariosDesdeArchivoGrafica(usuariosControl);
	    areaUsuarios.setText(usuarios);


	
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	}
}