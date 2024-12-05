package interfazesGraficasPrimerVentana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PrimerVentana extends JFrame{
	
	private BotonesPrimerVentana panelBotones;
	private JLabel titulo;
	private VentanaLoginEstudiante ventanaLoginEstudiante;
	


	public PrimerVentana() {
        setLayout( new BorderLayout( ) );
        JLabel titulo = new JLabel("Escoga un tipo de Usario");
        this.panelBotones=new BotonesPrimerVentana(this);
        titulo.setBackground(Color.PINK);
        titulo.setOpaque(true);
        add(titulo,BorderLayout.NORTH);
        add( panelBotones, BorderLayout.CENTER );
     
        setTitle( "Grupo 2 Proyecto Learning Paths" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 400, 600 );
        setLocationRelativeTo( null );
        setVisible( true );
       
    }

    
    public void mostrarVetanaLoginEstudiante( )
    {
        if( ventanaLoginEstudiante == null || !ventanaLoginEstudiante.isVisible( ) )
        {
            ventanaLoginEstudiante = new VentanaLoginEstudiante( this );
            ventanaLoginEstudiante.setVisible( true );
            
        }
    }
    
    public static void main( String[] args )
    {
        new PrimerVentana();
    }

}
	
