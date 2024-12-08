package ProfesorEvaluador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import Controlador.Controlador;
import Persistencias.*;
import co.edu.andes.usuarios.*;
import co.edu.andes.sistema.*;

public class VentanaCalificarActividad extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String CANCELAR = "CANCELAR";
    private static final String CALIFICAR = "CALIFICAR";
    
    private JTextField txtNombreU;
	private JTextField txtCodigoAct;
	private JTextField txtNota;
	private JPanel panel;
	private JButton btnCalificar;
	private JButton btnCancelar;
	
    private VentanaPrincipalProfesorEvaluador vPrincipalEval;
    
	public VentanaCalificarActividad(VentanaPrincipalProfesorEvaluador vPrincipalEval) {
		this.vPrincipalEval=vPrincipalEval;
		
		
		setTitle("Calificar Actividad");
	    setSize(500, 400);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    setLayout(new BorderLayout());
	    
	    this.panel = new JPanel();
	    this.panel.setLayout(new GridLayout(10, 2, 5, 5));
	    this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    this.panel.add(new JLabel("Nombre de usuario de estudiante:"));
	    this.txtNombreU = new JTextField();
	    this.panel.add(txtNombreU);
	  
	    this.panel.add(new JLabel("Código de Actividad:"));
	    this.txtCodigoAct = new JTextField();
	    this.panel.add(txtCodigoAct);
	    
	    this.panel.add(new JLabel("Ingerese Nota (0.0 si no es calificable):"));
	    this.txtNota = new JTextField();
	    this.panel.add(txtNota);
	    
	    btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        this.panel.add(btnCancelar);
        
        btnCalificar = new JButton("Calificar");
        btnCalificar.setActionCommand(CALIFICAR);
        btnCalificar.addActionListener(this);
        this.panel.add(btnCalificar);
        
        add(panel,BorderLayout.CENTER);
	}
	
	public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CALIFICAR ))
        {
        	String nombreU=txtNombreU.getText();
        	int idActividad=Integer.parseInt(txtCodigoAct.getText());
        	float nota=Float.parseFloat(txtNota.getText());
        	
        	Controlador.profesorCalificarActividad(nombreU, idActividad, nota, vPrincipalEval.getSistema(), vPrincipalEval.getProfesorEvaluador());
        }
        
        else if( comando.equals( CANCELAR ))
        {
        	this.dispose();
        }
    }

}
