package interfazesGraficasPrimerVentana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PanelIniciar extends JPanel {
	
	
	private JLabel nombreUsuarioL;
	private JLabel contrasenaL;
	private JTextField nombreUsuario;
	private JTextField contrasena;

	public PanelIniciar() {
		
		
		setLayout(new GridLayout(2,2));
        JLabel nombreUsuarioL= new JLabel("Ingrese su Nombre de Usuario");
        nombreUsuarioL.setOpaque(true);
        JLabel contrasenaL= new JLabel("Ingrese su Contraseña");
        contrasenaL.setOpaque(true);
        this.nombreUsuario = new JTextField("");
        this.contrasena = new JTextField("");
        add(nombreUsuarioL);
        add(nombreUsuario);
        add(contrasenaL);
        add(contrasena);
	}
	
	public String getNombreUsuario() {
		return nombreUsuario.getText();
	}


	public String getContrasena() {
		return contrasena.getText();
	}
	

}
