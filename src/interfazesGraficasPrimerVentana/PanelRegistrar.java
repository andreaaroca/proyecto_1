package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PanelRegistrar extends JPanel {
	
	private JLabel nombreL;
	private JLabel nombreUsuarioL;
	private JLabel contrasenaL;
	private JTextField nombre;
	private JTextField nombreUsuario;
	private JTextField contrasena;
	

	public PanelRegistrar() {
		
		setLayout(new GridLayout(3,2));
		
		JLabel nombreL= new JLabel("Nombre");
        nombreL.setOpaque(true);
        JLabel nombreUsuarioL= new JLabel("Escribe un Nombre de Usuario");
        nombreUsuarioL.setOpaque(true);
        JLabel contrasenaL= new JLabel("Escribe una Contraseña");
        contrasenaL.setOpaque(true);
        this.nombre = new JTextField();
        this.nombreUsuario = new JTextField();
        this.contrasena = new JTextField();
        add(nombreL);
        add(nombre);
        add(nombreUsuarioL);
        add(nombreUsuario);
        add(contrasenaL);
        add(contrasena);
        
	}


	public String getNombre() {
		return nombre.getText();
	}


	public String getNombreUsuario() {
		return nombreUsuario.getText();
	}


	public String getContrasena() {
		return contrasena.getText();
	}


	
	
	
	
	

}
